package com.yakuza.pasteandforget.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PasteContent {
    @Id
    private String shortlink;
    private String content;
}
