package hwan.demo.domain.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document
public class RefreshToken {
    @Id
    private String refreshToken;
    private Long memberId;
    private LocalDateTime expiryDate;
}