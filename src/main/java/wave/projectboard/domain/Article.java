package wave.projectboard.domain;

import java.time.LocalDateTime;

public class Article {

    private Long id;

    private String title; //제목

    private String hashtag; //해시태그

    private String content; //본문

    private LocalDateTime createdAt; //생성자

    private String createdBy; //생성일시

    private LocalDateTime modifiedAt; //수정자
    private String modifiedBy; //수정일시
}
