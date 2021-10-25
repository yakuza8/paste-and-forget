package com.yakuza.pasteandforget.service;

import com.yakuza.pasteandforget.dto.PasteDTO;
import com.yakuza.pasteandforget.model.Paste;
import com.yakuza.pasteandforget.repository.PasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasteService {

    @Autowired
    private PasteRepository pasteRepository;

    public PasteDTO savePaste(PasteDTO pasteDTO) {
        return null;
    }

    private Paste convertDtoTOModel(PasteDTO pasteDTO) {
        return Paste.builder()
                .shortLink(pasteDTO.getShortLink())
                .expirationInMinutes(pasteDTO.getExpirationInMinutes())
                .build();
    }

    private PasteDTO convertModelToDto(Paste paste) {
        return PasteDTO.builder()
                .shortLink(paste.getShortLink())
                .expirationInMinutes(paste.getExpirationInMinutes())
                .createdAt(paste.getCreatedAt())
                .expiresAt(paste.getExpiresAt())
                .build();
    }
}
