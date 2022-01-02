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

import static com.yakuza.pasteandforget.PasteConstants.MAX_PASTE_SIZE;
import static com.yakuza.pasteandforget.PasteConstants.MAX_EXPIRATION_IN_MINUTES;
import static com.yakuza.pasteandforget.PasteConstants.MAX_SHORTLINK_LENGTH;
import static com.yakuza.pasteandforget.PasteConstants.DEFAULT_EXPIRATION_IN_MINUTES;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasteRequestDTO {
    @Size(max = MAX_SHORTLINK_LENGTH, message = "Custom shortlink cannot exceed of size 12")
    private String shortLink;

    @PositiveOrZero(message = "Expiration should be positive value")
    @Max(value = MAX_EXPIRATION_IN_MINUTES, message = "Required max expiration in minutes is 1440")
    private Integer expirationInMinutes = DEFAULT_EXPIRATION_IN_MINUTES;

    @NotBlank(message = "A payload for the content is expected and cannot be blank")
    @Size(max = MAX_PASTE_SIZE, message = "Required max content size is 2048")
    private String content;
}
