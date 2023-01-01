package hwan2da.SMDFA.config.client.kakao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
public class KakaoProfileResponse {
    private String id;
    private String connected_at;
    private KakaoAccount kakao_account;
}
