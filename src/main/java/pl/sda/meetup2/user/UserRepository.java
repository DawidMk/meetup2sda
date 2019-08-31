package pl.sda.meetup2.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.meetup2.user.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByEmail(String email);
}
