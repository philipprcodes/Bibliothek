package de.schulung.bibliothek.administration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.schulung.bibliothek.exceptions.NotAMediumException;
import de.schulung.bibliothek.exceptions.NotAMemberException;
import de.schulung.bibliothek.media.Medium;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class Bibliothek {

    private final Set<Medium> mediums = new HashSet<>();
    private final Set<Member> members = new HashSet<>();
    private final Map<Member, List<Lending>> lendings = new HashMap<>();
    private int currentMaxId = 0;
    private int currentMaxMemberId = 0;


    public Set<Medium> getMediums() {
        return mediums;
    }

    public Bibliothek() {
    }

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
        for (Member i : lendings.keySet()) {
            System.out.println(i + " " + lendings.get(i));
        }
    }

    public List<Lending> getLendings(Member member) {
        return lendings.get(member);
    }

    public Member findMemberById(String id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }





    public boolean lendMedium (Member member, Medium medium, LocalDate lendingDate) throws NotAMemberException, NotAMediumException {

        if (!members.contains(member)) {
            throw new NotAMemberException("Person is not a member of this library!");
        }
        if (!mediums.contains(medium)) {
            throw new NotAMediumException("Library stack does not contain medium!");
        }
        if (medium.isAvailable()) {
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


    public boolean returnMedium (Member member, Medium medium) throws NotAMemberException, NotAMediumException {

        if (!members.contains(member)) {
            throw new NotAMemberException("Person is not a member of this library!");
        }
        if (!mediums.contains(medium)) {
            throw new NotAMediumException("Library stack does not contain medium!");
        }
        if (lendings.containsKey(member)) {
            boolean found = lendings.get(member).removeIf(lending -> lending.getMedium().equals(medium));
            if (found) {
                medium.setAvailable(true);
            }
            if (lendings.get(member).isEmpty()) {
                lendings.remove(member);
            }
            return found;
        }
        return false;
    }


//  public boolean returnMedium(Medium medium) {
//        Member member = lendings.entrySet().stream()
//                .filter(entry -> entry.getValue().stream()
//                        .anyMatch(lending -> lending.getMedium().equals(medium)))
//                .map(Map.Entry::getKey)
//                .findFirst()
//                .orElse(null);
//
//        if (member != null) {
//            lendings.get(member).removeIf(lending -> lending.getMedium().equals(medium));
//            medium.setAvailable(true);
//            return true;
//        }
//        return false;
//    }

}