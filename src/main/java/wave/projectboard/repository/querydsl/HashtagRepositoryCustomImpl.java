package wave.projectboard.repository.querydsl;


import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import wave.projectboard.domain.Hashtag;
import wave.projectboard.domain.QHashtag;

import java.util.List;

public class HashtagRepositoryCustomImpl extends QuerydslRepositorySupport implements HashtagRepositoryCustom {

    public HashtagRepositoryCustomImpl() {
        super(Hashtag.class);
    }

    @Override
    public List<String> findAllHashtagNames() {
        QHashtag hashtag = QHashtag.hashtag;

        return from(hashtag)
                .select(hashtag.hashtagName)
                .fetch();
    }

}
