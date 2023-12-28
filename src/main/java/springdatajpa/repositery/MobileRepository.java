package springdatajpa.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import springdatajpa.model.Mobile;


public interface MobileRepository extends JpaRepository<Mobile, Long> {
}
