package hwan.demo.domain.model;

import hwan.demo.domain.member.model.MemberSocialType;
import org.junit.jupiter.api.Test;

public class MemberSocialTypeTest {
    @Test
    void 이름_확인(){
        System.out.println(MemberSocialType.KAKAO);
        MemberSocialType[] values = MemberSocialType.values();
        for (MemberSocialType type : values) {
            System.out.println(type.getDescription());
        }
    }
}
