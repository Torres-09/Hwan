package hwan.SMDFA.domain.post.repository;

import hwan.SMDFA.domain.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
