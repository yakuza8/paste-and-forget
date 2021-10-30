package com.yakuza.pasteandforget.service;

import com.yakuza.pasteandforget.dto.PasteRequestDTO;
import com.yakuza.pasteandforget.dto.PasteResponseDTO;
import com.yakuza.pasteandforget.repository.PasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasteService {

    @Autowired
    private PasteRepository pasteRepository;

    public PasteResponseDTO savePaste(PasteRequestDTO pasteRequestDTO) {
        return null;
    }

    /**
     * Method that either applies the provided shortlink obtained from the request
     * or generates a new one which is expected to be unique and will be available
     * for referring the paste content over file document store
     *
     * @param providedShortlink Nullable field fetched over the request
     * @return Final tentative shortlink of the given paste content
     */
    public String applyOrAssignShortlink(String providedShortlink) {
        if (providedShortlink == null) {
            providedShortlink = generateRandomShortlink();
        }
        return providedShortlink;
    }

    private String generateRandomShortlink() {
        return null;
    }

    private boolean testRandomlyGeneratedShortlinkToBeUnique(String generatedShortlink) {
        return true;
    }

}
