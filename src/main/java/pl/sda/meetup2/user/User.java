package pl.sda.meetup2.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.sda.meetup2.comment.Comment;
import pl.sda.meetup2.event.Event;
import pl.sda.meetup2.role.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nick")
    private String nickname;

//    @Column(name = "events")

    @OneToMany(mappedBy = "owner")
    private Set<Event> events;

    //    @Column(name = "comments")
    @OneToMany(mappedBy = "commenter")
    private Set<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public void addRule(Role role) {
        roles.add(role);
        role.add(this);
    }

    public User() {
    }
}
