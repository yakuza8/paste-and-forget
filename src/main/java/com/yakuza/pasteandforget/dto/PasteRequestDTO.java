package com.yakuza.pasteandforget.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasteRequestDTO {
    private String shortLink;

    private Integer expirationInMinutes = 24 * 60;

    @NotNull
    @Size(max = 1024)
    private String content;
}
