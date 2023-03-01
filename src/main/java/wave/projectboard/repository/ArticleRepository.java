package wave.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.projectboard.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
