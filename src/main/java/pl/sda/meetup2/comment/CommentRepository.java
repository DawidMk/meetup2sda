package pl.sda.meetup2.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.meetup2.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
