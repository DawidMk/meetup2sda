package pl.sda.meetup2.user;

import lombok.*;
import pl.sda.meetup2.comment.Comment;
import pl.sda.meetup2.event.Event;
import pl.sda.meetup2.role.Role;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    public User() {
    }

}
