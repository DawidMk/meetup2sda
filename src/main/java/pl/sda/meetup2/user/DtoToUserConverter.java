package pl.sda.meetup2.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.meetup2.dto.RegisterFormDto;
import pl.sda.meetup2.role.Role;
import pl.sda.meetup2.role.RoleRepository;

@Component
public class DtoToUserConverter {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public DtoToUserConverter(PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User rewriteDtoToUser(RegisterFormDto registerFormDto) {
        Role role = roleRepository.findById(2).orElseThrow(RuntimeException::new);
        User user = User.builder()
                .email(registerFormDto.getEmail())
                .password(passwordEncoder.encode(registerFormDto.getPassword()))
                .nickname(registerFormDto.getNickname())
                .build();
        user.addRole(role);
        return user;
    }
}
