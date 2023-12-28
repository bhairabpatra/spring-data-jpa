package springdatajpa.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
