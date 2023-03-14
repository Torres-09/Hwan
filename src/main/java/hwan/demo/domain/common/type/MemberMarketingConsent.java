package hwan.demo.domain.common.type;

import hwan.demo.domain.common.EnumModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public enum MemberMarketingConsent implements EnumModel {

    APPROVE("마케팅 활용 동의"),
    DENY("마케팅 활용 거부"),
    UNVERIFIED("알 수 없음(하위 버전의 유저)"),
    ;

    private final String description;

    @NotNull
    @Override
    public String getKey() {
        return name();
    }

}