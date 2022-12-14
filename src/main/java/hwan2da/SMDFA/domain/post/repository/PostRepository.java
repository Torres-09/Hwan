package hwan2da.SMDFA.domain.post.repository;

import hwan2da.SMDFA.domain.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
