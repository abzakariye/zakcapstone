package app.netlify.scentra.scentra.config;

import app.netlify.scentra.scentra.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

@Controller
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/css/**", "/js/**", "/media/**", "/product-images/**", "/", "/index", "/shop", "/contactus", "/cart", "/login", "/register").permitAll()  // Public access
                        .requestMatchers("/user/dashboard/**").hasRole("USER")  // Employee task hub
                        .requestMatchers("/user/**", "/tasks/upload").hasRole("ADMIN")  // Admin access for managing employees and uploading tasks
                        .requestMatchers("/dashboard/**").hasRole("ADMIN")  // Admin-only access for managing tasks
                        .anyRequest().authenticated())  // All other requests require authentication

                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .permitAll()
                        .successHandler((request, response, authentication) -> {
                            authentication.getAuthorities().forEach(grantedAuthority -> {
                                String role = grantedAuthority.getAuthority();
                                try {
                                    if (role.equals("ROLE_ADMIN")) {
                                        response.sendRedirect("admin/dashboard");  // Admin redirect
                                    } else if (role.equals("ROLE_USER")) {
                                        response.sendRedirect("user/dashboard");  // Employee redirect
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                        }))
                .logout(logout -> logout.logoutSuccessUrl("/login").permitAll())
                .userDetailsService(customUserDetailsService);

        return http.build();
    }

   @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
   }
}
