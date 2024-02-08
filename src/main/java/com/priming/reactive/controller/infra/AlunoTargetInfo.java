package com.priming.reactive.controller.infra;

import com.priming.reactive.model.core.PrimeTargetCollection;
import com.priming.reactive.model.core.PrimeTargetPhraseCollection;
import com.priming.reactive.model.core.PrimeTargetTextCollection;
import com.priming.reactive.model.core.PrimeTargetYoutubeCollection;

public class AlunoTargetInfo {
    private final PrimeTargetPhraseCollection phraseInfo;
    private final PrimeTargetTextCollection textInfo;
    private final PrimeTargetCollection primingInfo;
    private final PrimeTargetYoutubeCollection youtubeInfo;

    public AlunoTargetInfo(PrimeTargetPhraseCollection phraseInfo, PrimeTargetTextCollection textInfo, PrimeTargetCollection primingInfo, PrimeTargetYoutubeCollection youtubeInfo) {
        this.phraseInfo = phraseInfo;
        this.textInfo = textInfo;
        this.primingInfo = primingInfo;
        this.youtubeInfo = youtubeInfo;
    }

    public PrimeTargetPhraseCollection getPhraseInfo() {
        return phraseInfo;
    }

    public PrimeTargetTextCollection getTextInfo() {
        return textInfo;
    }

    public PrimeTargetCollection getPrimingInfo() {
        return primingInfo;
    }

    public PrimeTargetYoutubeCollection getYoutubeInfo() {
        return youtubeInfo;
    }
}
