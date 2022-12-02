package hwan2da.SMDFA.domain.common;

import jakarta.validation.constraints.NotNull;

public interface EnumModel {
    @NotNull
    String getKey();

    @NotNull
    String getDescription();
}
