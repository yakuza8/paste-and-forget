package com.yakuza.pasteandforget.repository;

import com.yakuza.pasteandforget.model.PasteContent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasteContentRepository extends ReactiveMongoRepository<PasteContent, String> {
}
