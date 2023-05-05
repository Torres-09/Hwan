package hwan.demo.config.client.google.dto;

import lombok.Data;

@Data
public class GoogleProfileResponse {
    private String sub;
    private String name;
    private String picture;
    private String email;
}
