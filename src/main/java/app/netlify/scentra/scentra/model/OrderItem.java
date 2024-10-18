package app.netlify.scentra.scentra.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_items")

@Data
public class OrderItem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
    private double price;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
