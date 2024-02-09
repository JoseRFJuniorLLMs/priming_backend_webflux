package com.priming.reactive.model.infra;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "PrimeCoinCollection")
public class PrimeCoin {

    @Id
    private String id;

    private Double primecoinValue;
    private Double bitcoinValue;
    private LocalDateTime lastUpdated;
    private String ownerId;

    // Transaction history
    private List<Transaction> transactionHistory;
    private Double initialBalance;

    // Security
    private String publicKey;
    private String privateKey;

    // Other information
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private String issuer;


}


