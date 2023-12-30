package springdatajpa.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import springdatajpa.model.Delivery;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByPin(Long id);
}
