package hwan2da.SMDFA.domain.member.model;

import hwan2da.SMDFA.domain.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    @Embedded
    private MemberSocialInfo memberSocialInfo;

    @Column(length = 50)
    private String nickname;
}
