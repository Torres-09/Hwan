package hwan2da.SMDFA.domain.member.model;

import hwan2da.SMDFA.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    @Embedded
    private MemberSocialInfo memberSocialInfo;

    @Column(length = 50)
    private String nickname;
}
