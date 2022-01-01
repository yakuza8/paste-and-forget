package com.yakuza.pasteandforget.service;

import com.yakuza.pasteandforget.common.ShortlinkGenerator;
import com.yakuza.pasteandforget.dto.PasteRequestDTO;
import com.yakuza.pasteandforget.dto.PasteResponseDTO;
import com.yakuza.pasteandforget.repository.PasteContentRepository;
import com.yakuza.pasteandforget.repository.PasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PasteService {

    @Autowired
    private PasteRepository pasteRepository;

    @Autowired
    private PasteContentRepository pasteContentRepository;

    public PasteResponseDTO savePaste(PasteRequestDTO pasteRequestDTO) {
        String shortlink = applyOrAssignShortlink(pasteRequestDTO.getShortLink());
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
        String shortlink = ShortlinkGenerator.generateShortlink();
        while (Boolean.TRUE.equals(testRandomlyGeneratedShortlinkToBeUnique(shortlink).block())) {
            shortlink = ShortlinkGenerator.generateShortlink();
        }
        return shortlink;
    }

    /**
     * @param generatedShortlink
     * @return Whether there is a record with the given generated shortlink
     */
    private Mono<Boolean> testRandomlyGeneratedShortlinkToBeUnique(String generatedShortlink) {
        return pasteContentRepository.findFirstByShortlink(generatedShortlink).hasElement();
    }

}
