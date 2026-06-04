package de.schulung.bibliothek.administration;

import de.schulung.bibliothek.media.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bibliothek {

    private final List<Medium> mediums = new ArrayList<>();
    private final Set<Member> members = new HashSet<>();
    private int currentMaxId     = 0;
    private int currentMaxMemberId = 0;

    public Bibliothek() {}

    public boolean addToStock(Medium medium) {
       if (!mediums.contains(medium)) {
           mediums.add(medium);

           this.currentMaxId = Math.max(this.currentMaxId, medium.getId());
           return true;
       }
       return false;
    }


    public boolean addToMembers(Member member) {

       return members.add(member);


    }

    public boolean removeFromMembers(Member member) {
        return members.remove(member);
    }


    public boolean removeFromStock(Medium medium) {
        return mediums.remove(medium);
    }


    public int getNextId() {
        currentMaxId++;
        return currentMaxId;
    }

    public int getNextMemberID() {
        currentMaxMemberId++;
        return currentMaxMemberId;
    }

    public void printStock() {
        for (Medium medium : mediums) {
             System.out.println(medium);
        }
    }

    public void printMembers() {
        for (Member member : members) {
            System.out.println(member);
        }
    }
}
