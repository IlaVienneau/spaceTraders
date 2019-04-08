package com.example.spacetrader.model;

import java.util.HashMap;
import java.util.Map;

public class Model {
    private Repository myRepository;
    private Map<String, Object> interactorMap;

    private static Model instance = new Model();

    public static Model getInstance() { return instance; }

    private Model() {
        myRepository = new Repository();
        interactorMap = new HashMap<>();
        registerInteractors();
    }

    /**
     * This method registers interactor classes in the interactor map.
     */
    private void registerInteractors() {
        interactorMap.put("Player", new PlayerInteractor(myRepository));
    }

    /**
     * This method returns the player interactor.
     *
     * @return the player interactor.
     */
    public PlayerInteractor getPlayerInteractor() {
        return (PlayerInteractor) interactorMap.get("Student");
    }
}
