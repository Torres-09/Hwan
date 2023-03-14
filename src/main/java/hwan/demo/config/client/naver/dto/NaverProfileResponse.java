package hwan.demo.config.client.naver.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverProfileResponse {
    // 수정필요
    private String email;
}
