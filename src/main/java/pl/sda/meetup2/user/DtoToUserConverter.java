package pl.sda.meetup2.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.meetup2.dto.RegisterFormDto;
import pl.sda.meetup2.role.Role;
import pl.sda.meetup2.role.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

        if (user.getRoles() == null) {
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
        } else {
            Set<Role> roles = user.getRoles();
            roles.add(role);
            user.setRoles(roles);
        }
        return user;
    }
}
