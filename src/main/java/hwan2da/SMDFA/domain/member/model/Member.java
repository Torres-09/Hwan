package hwan2da.SMDFA.domain.member.model;

import hwan2da.SMDFA.domain.common.BaseEntity;
import hwan2da.SMDFA.domain.common.type.MemberMarketingConsent;
import hwan2da.SMDFA.domain.post.model.Post;
import lombok.AccessLevel;
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

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberMarketingConsent marketingConsent;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private final List<Post> memberPosts = new ArrayList<>();

    @Builder(access = AccessLevel.PRIVATE)
    private Member(String socialId, String socialEmail, MemberSocialType socialType, String nickname, MemberMarketingConsent marketingConsent) {
        this.memberSocialInfo = MemberSocialInfo.of(socialId, socialEmail, socialType);
        this.nickname = nickname;
        this.marketingConsent = marketingConsent;
    }

    public static Member newMember(String socialId, String socialEmail, MemberSocialType socialType, String nickname) {
        return Member.builder()
                .socialId(socialId)
                .socialEmail(socialEmail)
                .socialType(socialType)
                .nickname(nickname)
                .marketingConsent(MemberMarketingConsent.UNVERIFIED)
                .build();
    }
}
