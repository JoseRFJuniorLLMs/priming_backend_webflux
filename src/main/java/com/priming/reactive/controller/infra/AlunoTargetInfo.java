package com.priming.reactive.controller.infra;

import com.priming.reactive.model.core.PrimeTargetCollection;
import com.priming.reactive.model.core.PrimeTargetFraseCollection;
import com.priming.reactive.model.core.PrimeTargetTextCollection;
import com.priming.reactive.model.core.PrimeTargetYoutubeCollection;

public class AlunoTargetInfo {
    private final PrimeTargetFraseCollection fraseInfo;
    private final PrimeTargetTextCollection textInfo;
    private final PrimeTargetCollection primingInfo;
    private final PrimeTargetYoutubeCollection youtubeInfo;

    public AlunoTargetInfo(PrimeTargetFraseCollection fraseInfo, PrimeTargetTextCollection textInfo, PrimeTargetCollection primingInfo, PrimeTargetYoutubeCollection youtubeInfo) {
        this.fraseInfo = fraseInfo;
        this.textInfo = textInfo;
        this.primingInfo = primingInfo;
        this.youtubeInfo = youtubeInfo;
    }

    public PrimeTargetFraseCollection getFraseInfo() {
        return fraseInfo;
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
