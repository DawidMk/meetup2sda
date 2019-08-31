package pl.sda.meetup2.comment;

import pl.sda.meetup2.event.Event;
import pl.sda.meetup2.user.User;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "message")
    private String message;

    //    @Column(name = "commenter")
    @ManyToOne
    @JoinColumn(name = "commenter_id")
    private User commenter;

    //    @Column(name = "event")
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
