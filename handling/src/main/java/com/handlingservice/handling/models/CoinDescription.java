package com.handlingservice.handling.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CoinDescription {

    private String id;//	"btc-bitcoin"
    private String name;//	"Bitcoin"
    private String symbol;//	"BTC"
    private int rank;//	1
    @JsonProperty("is_new")
    private boolean isNew;//	false
    @JsonProperty("is_active")
    private boolean isActive;//	true
    private String type;//	"coin"
    private String logo;//	"https://static.coinpaprika.com/coin/btc-bitcoin/logo.png"
    private List<Tag> tags;
    private List<Team> teams;
    private String description;//	"Bitcoin is a cryptocurre…r single administrator."
    private String message;//	""
    @JsonProperty("open_source")
    private boolean openSource;//	true
    @JsonProperty("started_at")
    private String startedAt;//	"2009-01-03T00:00:00Z"
    @JsonProperty("development_status")
    private String developmentStatus;//	"Working product"
    @JsonProperty("hardware_wallet")
    private boolean hardwareWallet;//	true
    @JsonProperty("proof_type")
    private String proofType;//	"Proof of Work"
    @JsonProperty("org_structure")
    private String orgStructure;//	"Decentralized"
    @JsonProperty("hash_algorithm")
    private String hashAlgorithm;//	"SHA256"
    private Links links;

}
