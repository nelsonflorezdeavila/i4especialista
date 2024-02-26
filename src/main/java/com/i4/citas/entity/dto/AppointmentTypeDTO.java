package com.i4.citas.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.*;
import lombok.Builder;

@JsonPropertyOrder({
        "id",
        "name",
        "description",
        "duration",
        "colorHexCode"
})
@Builder
public record AppointmentTypeDTO(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Integer id,

        @NotNull
        @NotEmpty
        @Size(max = 60)
        String name,

        @Size(max = 255)
        String description,

        @Min(value = 5)
        short duration,

        @NotNull
        @NotEmpty
        @Size(max = 10)
        String color
) {
}
