package hwan2da.SMDFA.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpHeaderUtils {

    private static final String BEARER_TOKEN = "Bearer ";

    @NotNull
    public static String withBearerToken(@NotNull String token) {
        return BEARER_TOKEN + token;
    }

}
