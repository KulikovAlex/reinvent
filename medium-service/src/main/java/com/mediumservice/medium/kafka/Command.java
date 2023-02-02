package com.mediumservice.medium.kafka;

public enum Command {

    COIN_BY_ID("coinById");

    private final String command;
    Command(String command) {
        this.command = command;
    }
}
