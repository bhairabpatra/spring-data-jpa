package springdatajpa.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import springdatajpa.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
