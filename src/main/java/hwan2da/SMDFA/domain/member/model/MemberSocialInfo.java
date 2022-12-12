package hwan2da.SMDFA.domain.member.model;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSocialInfo {
    @Column(length = 100)
    private String socialEmail;

    @Enumerated(EnumType.STRING)
    private MemberSocialType memberSocialType;

    private MemberSocialInfo(@NotNull String socialEmail, @NotNull MemberSocialType memberSocialType) {
        this.socialEmail = socialEmail;
        this.memberSocialType = memberSocialType;
    }

    public static MemberSocialInfo of(String socialEmail, MemberSocialType memberSocialType) {
        return new MemberSocialInfo(socialEmail, memberSocialType);
    }
}
