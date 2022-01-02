package com.yakuza.pasteandforget.model;

import lombok.ToString;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
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
