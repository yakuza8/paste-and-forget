package com.yakuza.pasteandforget.dto;

import com.yakuza.pasteandforget.PasteConstants;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasteDTO {
    private String shortLink;

    private Integer expirationInMinutes;

    @NotNull
    @Size(max = PasteConstants.MAX_PASTE_SIZE)
    private String content;

    private Instant createdAt;

    private Instant expiresAt;
}
