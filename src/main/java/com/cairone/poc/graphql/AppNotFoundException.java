package com.cairone.poc.graphql;

public class AppNotFoundException extends RuntimeException {

    public AppNotFoundException(String message) {
        super(message);
    }
}
