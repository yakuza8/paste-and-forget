package com.yakuza.pasteandforget.controller;

import com.yakuza.pasteandforget.dto.PasteDTO;
import com.yakuza.pasteandforget.service.PasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasteController {

    @Autowired
    private PasteService pasteService;

    @PostMapping("/paste")
    @ResponseStatus
    public PasteDTO createProduct(@RequestBody PasteDTO pasteDTO) {
        return pasteService.savePaste(pasteDTO);
    }

}
