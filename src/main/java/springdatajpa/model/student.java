package springdatajpa.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "student_tbl")
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private  String name;
}
