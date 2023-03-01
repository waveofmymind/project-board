package wave.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.projectboard.domain.ArticleComment;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment,Long> {
}
