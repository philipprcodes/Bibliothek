package de.schulung.bibliothek.administration;

import de.schulung.bibliothek.media.Medium;

import java.util.ArrayList;
import java.util.List;

public class Bibliothek {

    private final List<Medium> mediums = new ArrayList<>();
    private int currentMaxId     = 0;

    public Bibliothek() {}

    public boolean addToStock(Medium medium) {
       if (!mediums.contains(medium)) {
           mediums.add(medium);

           this.currentMaxId = Math.max(this.currentMaxId, medium.getId());
           return true;
       }
       return false;
    }

    public boolean removeFromStock(Medium medium) {
        return mediums.remove(medium);
    }


    public int getNextId() {
        currentMaxId++;
        return currentMaxId;
    }

    public void printStock() {
        for (Medium medium : mediums) {


            System.out.println(medium);
        }
    }
}
