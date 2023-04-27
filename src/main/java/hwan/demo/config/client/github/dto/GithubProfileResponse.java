package hwan.demo.config.client.github.dto;

import lombok.Data;

@Data
public class GithubProfileResponse {
    private String login;
    private String id;
    private String avatar_url;
    private String html_url;
    private String name;
    private String email;
}
