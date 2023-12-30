package springdatajpa.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "mobile_tbl")
@NoArgsConstructor
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private  Double price;
    private  String model;
    private  String brand;
    private  String imgUrl;

    private List<String> storage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "color_fk_id")
    private Color color;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_mob_id", referencedColumnName = "id")
    private List<Delivery> deliveries;

    @JsonIgnore
    @ManyToMany(mappedBy = "mobiles")
    private Set<User> users= new HashSet<>();

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", storage=" + storage +
                ", color=" + color +
                ", deliveries=" + deliveries +
                ", users=" + users +
                '}';
    }
}
