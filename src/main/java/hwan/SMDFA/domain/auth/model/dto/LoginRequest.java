package hwan.SMDFA.domain.auth.model.dto;

import hwan.SMDFA.domain.member.model.MemberSocialType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginRequest {
    private String token;
    private MemberSocialType socialType;
}
