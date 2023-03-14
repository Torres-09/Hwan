package hwan.demo.domain.member.model;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSocialInfo {
    private String socialId;

    @Column(length = 100)
    private String socialEmail;

    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private MemberSocialType socialType;

    private MemberSocialInfo(String socialId, String socialEmail, MemberSocialType socialType) {
        this.socialId = socialId;
        this.socialEmail = socialEmail;
        this.socialType = socialType;
    }

    public static MemberSocialInfo of(String socialId, String socialEmail, MemberSocialType socialType) {
        return new MemberSocialInfo(socialId, socialEmail, socialType);
    }
}
