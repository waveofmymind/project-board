package wave.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import wave.projectboard.domain.ArticleComment;
@RepositoryRestResource

public interface ArticleCommentRepository extends JpaRepository<ArticleComment,Long> {
}
