package com.yakuza.pasteandforget.repository;

import com.yakuza.pasteandforget.model.Paste;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasteRepository extends ReactiveCrudRepository<Paste, String> {
}
