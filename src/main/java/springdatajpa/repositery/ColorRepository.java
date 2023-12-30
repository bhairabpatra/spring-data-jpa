package springdatajpa.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import springdatajpa.model.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
