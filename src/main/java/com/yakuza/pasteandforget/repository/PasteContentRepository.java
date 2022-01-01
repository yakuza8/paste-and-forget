package com.yakuza.pasteandforget.repository;

import com.yakuza.pasteandforget.model.PasteContent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PasteContentRepository extends ReactiveMongoRepository<PasteContent, String> {
    Mono<PasteContent> findFirstByShortlink(String shortlink);
}
