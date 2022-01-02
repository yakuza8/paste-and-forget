package com.yakuza.pasteandforget.model;

import lombok.ToString;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

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
    private String shortlink;

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
    private Instant createdAt;

    /**
     * The tentative removal time of the paste which is calculated current time + expiration minutes amount
     */
    @Column("expires_at")
    private Instant expiresAt;

}
