package com.priming.reactive.model.infra;

import com.priming.reactive.model.core.PrimeTargetPhraseCollection;
import com.priming.reactive.model.core.PrimeTargetTextCollection;
import com.priming.reactive.model.core.PrimeTargetYoutubeCollection;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "TestCollection")
public class TestCollection {
    @Id
    private String id;

    private List<PrimeTargetTextCollection> textCollections;

    private List<PrimeTargetPhraseCollection> phraseCollections;

    private List<PrimeTargetYoutubeCollection> youtubeCollections;

    // Construtores, getters e setters
}
