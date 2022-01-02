package com.yakuza.pasteandforget.dto;

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
    @Size(max = MAX_SHORTLINK_LENGTH)
    private String shortLink;

    @Max(value = MAX_EXPIRATION_IN_MINUTES)
    private Integer expirationInMinutes = DEFAULT_EXPIRATION_IN_MINUTES;

    @NotBlank
    @Size(max = MAX_PASTE_SIZE)
    private String content;
}
