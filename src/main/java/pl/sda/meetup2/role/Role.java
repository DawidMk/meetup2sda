package pl.sda.meetup2.role;

import lombok.Getter;
import lombok.Setter;
import pl.sda.meetup2.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public void add(User user) {
        users.add(user);
    }
}
