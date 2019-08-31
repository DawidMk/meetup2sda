package pl.sda.meetup2.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Getter
@Setter
@Repository
public class UserDao {

    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUserToDb(User user){
        userRepository.save(user);
    }

    public List<User> findUserInDb(String userEmail){
        return userRepository.findByEmail(userEmail);
    }
}
