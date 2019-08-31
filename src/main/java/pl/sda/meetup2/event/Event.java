package pl.sda.meetup2.event;

import lombok.Getter;
import lombok.Setter;
import pl.sda.meetup2.comment.Comment;
import pl.sda.meetup2.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

//    @Column(name = "comments")
    @OneToMany(mappedBy = "event")
    private Set<Comment> comments;

}
