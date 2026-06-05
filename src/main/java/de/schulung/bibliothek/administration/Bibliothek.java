package de.schulung.bibliothek.administration;

import de.schulung.bibliothek.media.Medium;

import java.time.LocalDate;
import java.util.*;

public class Bibliothek {

    private final Set<Medium> mediums = new HashSet<>();
    private final Set<Member> members = new HashSet<>();
    private final Map<Member, List<Lending>> lendings = new HashMap<>();
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

    public void printLendings() {
        for (Member i : lendings.keySet()){
            System.out.println(i + " " + lendings.get(i));
        }
    }

    public boolean lendMedium (Member member, Medium medium, LocalDate lendingDate) {

        if (members.contains(member) && mediums.contains(medium) && medium.isAvailable()) {
            if (!lendings.containsKey(member)) {
                lendings.put(member, new ArrayList<>());
            }

            Lending lending = new Lending(lendingDate, medium);
            lendings.get(member).add(lending);
            medium.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnMedium(Medium medium) {
        Member member = lendings.entrySet().stream().filter(entry -> Objects.equals(entry.getKey(), medium)).map(Map.Entry::getKey).findFirst().orElse(null);
        if (member != null) {
            lendings.remove(member);
            return true;
        }
        return false;

    }



}
