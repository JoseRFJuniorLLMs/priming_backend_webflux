package com.priming.reactive.controller.infra;

import com.priming.reactive.model.core.PrimeTargetFraseCollection;
import com.priming.reactive.model.core.PrimeTargetTextCollection;

public class AlunoTargetInfo {
    private final PrimeTargetFraseCollection fraseInfo;
    private final PrimeTargetTextCollection textInfo;

    public AlunoTargetInfo(PrimeTargetFraseCollection fraseInfo, PrimeTargetTextCollection textInfo) {
        this.fraseInfo = fraseInfo;
        this.textInfo = textInfo;
    }

    public PrimeTargetFraseCollection getFraseInfo() {
        return fraseInfo;
    }

    public PrimeTargetTextCollection getTextInfo() {
        return textInfo;
    }
}
