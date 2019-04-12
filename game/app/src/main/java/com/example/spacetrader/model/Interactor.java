package com.example.spacetrader.model;

/**
 * Interface for our concrete interactors
 */
abstract class Interactor {

    private Repository myRepository;

    Interactor(Repository repo) {
        myRepository = repo;
    }

    Repository getRepository() {
        return myRepository;
    }
}