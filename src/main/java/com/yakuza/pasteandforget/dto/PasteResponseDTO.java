package com.yakuza.pasteandforget.dto;

import lombok.Data;
import lombok.ToString;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.Instant;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasteResponseDTO {
    private String shortLink;

    private Integer expirationInMinutes;

    private Instant createdAt;

    private Instant expiresAt;
}