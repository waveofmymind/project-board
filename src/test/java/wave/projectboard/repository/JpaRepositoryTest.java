package wave.projectboard.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import wave.projectboard.config.JpaConfig;
import wave.projectboard.domain.Article;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@DataJpaTest
@Import(JpaConfig.class)
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(@Autowired ArticleRepository articleRepository,@Autowired  ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @BeforeEach
    void setUp() {
        Article article = Article.of("new article","#spring","content");
        articleRepository.save(article);
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        //given

        //when
        List<Article> articles = articleRepository.findAll();
        //then
        assertThat(articles).isNotNull()
                .hasSize(0);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine() {
        //given
        long previousCount = articleRepository.count();
        Article article = Article.of("new article","#spring","content");

        //when
        Article savedArticle = articleRepository.save(article);
        //then
        assertThat(articleRepository.count()).isEqualTo(previousCount+1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine() {
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#springboot";
        article.setHashtag(updatedHashtag);


        //when
        Article savedArticle = articleRepository.saveAndFlush(article);

        //then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag",updatedHashtag);
    }







}