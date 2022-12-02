package hwan2da.SMDFA.domain.member.model;

import hwan2da.SMDFA.domain.common.EnumModel;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MemberSocialType implements EnumModel {

    NAVER("네이버"),
    GOOGLE("구글"),
    KAKAO("카카오톡"),
    ;

    private final String description;

    @NotNull
    @Override
    public String getKey() {
        return name();
    }
}
