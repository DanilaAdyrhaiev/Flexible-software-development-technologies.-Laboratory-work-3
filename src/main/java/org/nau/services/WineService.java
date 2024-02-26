package org.nau.services;

import org.nau.entities.Wine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WineService {
    private List<Wine> wines = new ArrayList<>();
    private long nextId = 1;

    public void add(String name, String brand, String country, LocalDate bottlingDate, String note) {
        Wine wine = new Wine(name, brand, country, bottlingDate, note);
        wine.setId(nextId);
        wines.add(wine);
        nextId++;
    }

    public List<Wine> getAllWines() {
        return wines;
    }

    public Wine getWineById(long id) {
        for (Wine wine : wines) {
            if (wine.getId() == id) {
                return wine;
            }
        }
        return null;
    }

    public void updateWine(long id, String name, String brand, String country, LocalDate bottlingDate, String note) {
        Wine wineToUpdate = getWineById(id);
        if (wineToUpdate != null) {
            wineToUpdate.setName(name);
            wineToUpdate.setBrand(brand);
            wineToUpdate.setCountry(country);
            wineToUpdate.setBottlingDate(bottlingDate);
            wineToUpdate.setNote(note);
        }
    }

    public void deleteWine(long id) {
        wines.removeIf(wine -> wine.getId() == id);
    }
}
