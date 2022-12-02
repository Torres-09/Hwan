package hwan2da.SMDFA.domain.member.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSocialInfo {
    @Column(length = 100)
    private String socialEmail;

    @Enumerated(EnumType.STRING)
    private MemberSocialType memberSocialType;

    private MemberSocialInfo(@NotNull String socialEmail,@NotNull MemberSocialType memberSocialType) {
        this.socialEmail = socialEmail;
        this.memberSocialType = memberSocialType;
    }

    public static MemberSocialInfo of(String socialEmail, MemberSocialType memberSocialType) {
        return new MemberSocialInfo(socialEmail, memberSocialType);
    }
}
