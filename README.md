# Scentra - Perfume & Fragrance Online Store

## Project Overview

**Scentra** is a full-stack e-commerce web application designed to sell perfumes and fragrances. The application provides a seamless experience for users to browse, view product details, add items to their cart, and manage their orders. Admins can manage product listings and handle orders from an intuitive dashboard. The project is developed using **Spring Boot** for the back-end and **Thymeleaf, HTML, CSS, JavaScript** for the front-end.

## Features

### User Features:
- **Homepage**: Includes a header with promotional content, a featured product section, and a fragrance-related video.
- **Product Catalog**: Displays all products with sorting options.
- **Product Page**: Shows detailed information for individual products with images, descriptions, and an "Add to Cart" button.
- **Cart Page**: Lists all selected items with an order summary and a checkout button.
- **User Dashboard**: Allows users to manage profile information and view/manage their orders.
- **Authentication**: Users can sign up, log in, and securely manage their accounts.

### Admin Features:
- **Admin Dashboard**: Manage products (CRUD operations) and handle order management, including tracking order statuses.
- **Product Management**: Create, update, delete, and list products.
- **Order Management**: View, manage, and track customer orders.

## Tech Stack

### Back-End:
- **Java**: Main programming language.
- **Spring Boot**: Framework for building the back-end of the application.
- **Spring Data JPA & Hibernate**: ORM for database interaction.
- **MySQL**: Relational database for storing data.
- **Spring Security**: For user authentication and password encryption using BCrypt.

### Front-End:
- **Thymeleaf**: Template engine for dynamic HTML rendering.
- **HTML, CSS, JavaScript**: Standard technologies for structuring and styling the pages.
- **Bootstrap**: (Optional) For responsive design and styling.
  
### Database Schema:
The database includes the following core entities:
- **User**: Handles user information and authentication.
- **Product**: Stores product details such as name, description, price, and images.
- **CartItem**: Manages products added to the cart, associated with a user.
- **Order**: Tracks the status and details of each purchase.
- **OrderItem**: Stores each individual product included in an order.

## Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/scentra.git
