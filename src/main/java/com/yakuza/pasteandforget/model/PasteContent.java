package com.yakuza.pasteandforget.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class PasteContent {
    @Id
    private String id;
    private String shortlink;
    private String content;
}
