package hwan.demo.domain.member.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import hwan.demo.domain.common.EnumModel;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MemberSocialType implements EnumModel {

    NAVER("네이버"),
    GOOGLE("구글"),
    KAKAO("카카오톡"),
    GITHUB("깃허브");

    private final String description;

    @NotNull
    @Override
    public String getKey() {
        return name();
    }

    @JsonCreator
    public static MemberSocialType from(String text) {
        for(MemberSocialType type : MemberSocialType.values()){
            if(type.getDescription().equals(text))
                return type;
        }
        throw new IllegalArgumentException();
    }
}
