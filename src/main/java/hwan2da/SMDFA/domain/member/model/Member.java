package hwan2da.SMDFA.domain.member.model;

import hwan2da.SMDFA.domain.common.BaseEntity;
import hwan2da.SMDFA.domain.post.model.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    @Embedded
    private MemberSocialInfo memberSocialInfo;

    @Column(length = 50)
    private String nickname;

    @OneToMany(mappedBy = "Member", cascade = CascadeType.ALL)
    private final List<Post> userPosts = new ArrayList<>();
}
