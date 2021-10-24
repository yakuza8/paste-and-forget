package com.yakuza.pasteandforget.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * Data model for representation of a paste as metadata
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "paste")
public class Paste {

    /**
     * Unique generated short link to reach and represent the paste
     */
    @Id
    @Column("shortlink")
    private String shortLink;

    /**
     * The path to react actual content of paste over the document store
     */
    @Column("content_path")
    private String contentPath;

    /**
     * Minutes amount of the paste that will live for
     */
    @Column("expiration_in_minutes")
    private Integer expirationInMinutes;

    /**
     * Auto generated field for the traceability
     */
    @Column("created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    /**
     * The tentative removal time of the paste which is calculated current time + expiration minutes amount
     */
    @Column("expires_at")
    private LocalDateTime expiresAt;

}
