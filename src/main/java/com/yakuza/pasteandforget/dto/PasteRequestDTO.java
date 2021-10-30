package com.yakuza.pasteandforget.dto;

import com.yakuza.pasteandforget.PasteConstants;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasteRequestDTO {
    private String shortLink = null;

    private Integer expirationInMinutes = 24 * 60;

    @NotNull
    @Size(max = PasteConstants.MAX_PASTE_SIZE)
    private String content;
}