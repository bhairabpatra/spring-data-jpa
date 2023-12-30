package springdatajpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "delivery_pin")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Integer pin;

    @ManyToOne(cascade = CascadeType.ALL)
    private Mobile mobile;
}

