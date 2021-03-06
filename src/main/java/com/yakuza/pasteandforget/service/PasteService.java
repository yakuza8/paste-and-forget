package com.yakuza.pasteandforget.service;

import com.yakuza.pasteandforget.common.ShortlinkGenerator;
import com.yakuza.pasteandforget.dto.PasteRequestDTO;
import com.yakuza.pasteandforget.dto.PasteResponseDTO;
import com.yakuza.pasteandforget.model.Paste;
import com.yakuza.pasteandforget.model.PasteContent;
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

    public Mono<PasteResponseDTO> savePaste(PasteRequestDTO pasteRequestDTO) {
        String shortlink = applyOrAssignShortlink(pasteRequestDTO.getShortlink());
        pasteRequestDTO.setShortlink(shortlink);

        return savePasteContent(pasteRequestDTO).flatMap(
                pasteContent -> savePasteInformation(pasteRequestDTO, pasteContent).flatMap(
                        paste -> Mono.just(
                                new PasteResponseDTO(
                                        shortlink,
                                        pasteRequestDTO.getExpirationInMinutes(),
                                        paste.getCreatedAt(),
                                        paste.getExpiresAt()
                                )
                        )
                )
        );
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
        // TODO User defined shortlink can already exist
        if (providedShortlink == null) {
            providedShortlink = generateRandomShortlink();
        }
        return providedShortlink;
    }

    private String generateRandomShortlink() {
        // TODO Add retry logic over here if any record exists
        return ShortlinkGenerator.generateShortlink();
    }

    /**
     * @param generatedShortlink
     * @return Whether there is a record with the given generated shortlink
     */
    private Mono<PasteContent> testRandomlyGeneratedShortlinkToBeUnique(String generatedShortlink) {
        return pasteContentRepository.findFirstByShortlink(generatedShortlink);
    }

    private Mono<PasteContent> savePasteContent(PasteRequestDTO pasteRequestDTO) {
        PasteContent content = new PasteContent(null, pasteRequestDTO.getShortlink(), pasteRequestDTO.getContent());
        return pasteContentRepository.save(content);
    }

    private Mono<Paste> savePasteInformation(PasteRequestDTO pasteRequestDTO, PasteContent pasteContent) {
        Paste paste = new Paste(
                pasteRequestDTO.getShortlink(),
                pasteContent.getId(),
                pasteRequestDTO.getExpirationInMinutes(),
                null,
                null
        );
        return pasteRepository.save(paste);
    }

}
