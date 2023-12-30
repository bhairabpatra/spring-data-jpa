package springdatajpa.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import springdatajpa.model.Mobile;


public interface MobileRepository extends JpaRepository<Mobile, Long> {

}
