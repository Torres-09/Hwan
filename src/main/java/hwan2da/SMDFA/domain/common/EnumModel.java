package hwan2da.SMDFA.domain.common;

import javax.validation.constraints.NotNull;

public interface EnumModel {
    @NotNull
    String getKey();

    @NotNull
    String getDescription();
}
