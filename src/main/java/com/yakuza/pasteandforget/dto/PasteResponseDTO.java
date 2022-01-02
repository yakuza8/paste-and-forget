package com.yakuza.pasteandforget.dto;

import java.time.Instant;
import lombok.Data;
import lombok.ToString;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasteResponseDTO {
    private String shortlink;

    private Integer expirationInMinutes;

    private Instant createdAt;

    private Instant expiresAt;
}