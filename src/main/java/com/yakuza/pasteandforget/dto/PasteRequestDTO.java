package com.yakuza.pasteandforget.dto;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import lombok.ToString;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import static com.yakuza.pasteandforget.PasteConstants.DEFAULT_EXPIRATION_IN_MINUTES;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasteRequestDTO {
    @Size(max = 12, message = "Custom shortlink cannot exceed of size 12")
    private String shortlink;

    @PositiveOrZero(message = "Expiration should be positive value")
    @Max(value = 1440, message = "Required max expiration in minutes is 1440")
    private Integer expirationInMinutes = DEFAULT_EXPIRATION_IN_MINUTES;

    @NotBlank(message = "A payload for the content is expected and cannot be blank")
    @Size(max = 2048, message = "Required max content size is 2048 characters")
    private String content;
}
