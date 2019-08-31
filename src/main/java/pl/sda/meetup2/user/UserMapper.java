package pl.sda.meetup2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.meetup2.dto.RegisterFormDto;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User rewriteDtoToUser(RegisterFormDto registerFormDto) {
        return User.builder()
                .email(registerFormDto.getEmail())
                .password(passwordEncoder.encode(registerFormDto.getPassword()))
                .nickname(registerFormDto.getNickname())
                .build();

    }
}
