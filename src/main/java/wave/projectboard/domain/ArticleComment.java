package wave.projectboard.domain;

import java.time.LocalDateTime;

public class ArticleComment {

    private Long id;

    private Article article;

    private String hashtag; //해시태그

    private String content; //본문

    private LocalDateTime createdAt; //생성자

    private String createdBy; //생성일시

    private LocalDateTime modifiedAt; //수정자
    private String modifiedBy; //수정일시
    
}
