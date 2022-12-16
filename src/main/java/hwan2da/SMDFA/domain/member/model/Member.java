package hwan2da.SMDFA.domain.member.model;

import hwan2da.SMDFA.domain.common.BaseEntity;
import hwan2da.SMDFA.domain.common.type.MemberMarketingConsent;
import hwan2da.SMDFA.domain.post.model.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberMarketingConsent marketingConsent;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private final List<Post> memberPosts = new ArrayList<>();

    @Builder(access = AccessLevel.PRIVATE)
    private Member(@Nullable String socialId, @Nullable MemberSocialType socialType, @Nullable String name, @NotNull MemberMarketingConsent marketingConsent) {
        this.memberSocialInfo = MemberSocialInfo.of(socialId, socialType);
        this.nickname = name;
        this.marketingConsent = marketingConsent;
    }
}
