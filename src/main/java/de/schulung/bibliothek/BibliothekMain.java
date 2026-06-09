package de.schulung.bibliothek;

import de.schulung.bibliothek.administration.Bibliothek;
import de.schulung.bibliothek.administration.Member;
import de.schulung.bibliothek.exceptions.NotAMediumException;
import de.schulung.bibliothek.exceptions.NotAMemberException;
import de.schulung.bibliothek.media.Book;
import de.schulung.bibliothek.media.Medium;
import de.schulung.bibliothek.utilities.MediumGenerator;
import de.schulung.bibliothek.utilities.MemberGenerator;

import java.time.LocalDate;


public class BibliothekMain {
    public static void main(String[] args) throws NotAMediumException, NotAMemberException {
        Bibliothek bibliothek = new Bibliothek();

        Medium book = MediumGenerator.generateBook(bibliothek.getNextId());
        Medium book2 = MediumGenerator.generateBook(bibliothek.getNextId());
        Medium book3 = MediumGenerator.generateBook(bibliothek.getNextId());
        Medium dvd = MediumGenerator.generateDVD(bibliothek.getNextId());
        Medium dvd2 = MediumGenerator.generateDVD(bibliothek.getNextId());
        Medium dvd3 = MediumGenerator.generateDVD(bibliothek.getNextId());
        Medium dvd4 = MediumGenerator.generateDVD(bibliothek.getNextId());

        bibliothek.addToStock(book);
        bibliothek.addToStock(book2);
        bibliothek.addToStock(book3);
        bibliothek.addToStock(dvd);
        bibliothek.addToStock(dvd2);
        bibliothek.addToStock(dvd3);


//        bibliothek.printStock();

        Member admin = new Member( "CBM", "Dieter", "Mueller", LocalDate.of(1990, 5, 23), "admin@cbm.de");
        bibliothek.addToMembers(admin);
        Member m1 = MemberGenerator.generateMember(bibliothek.getNextMemberID());
        bibliothek.addToMembers(m1);
        Member m2 = MemberGenerator.generateMember(bibliothek.getNextMemberID());
        bibliothek.addToMembers(m2);
        Member m3 = MemberGenerator.generateMember(bibliothek.getNextMemberID());
        bibliothek.addToMembers(m3);



        BibliothekConsole repl = new BibliothekConsole(bibliothek);
        repl.start();





//        bibliothek.printMembers();

//        bibliothek.lendMedium(m1, dvd, LocalDate.now());
//        bibliothek.lendMedium(m2, dvd2, LocalDate.now());

//        bibliothek.printLendings();
//
//        try {
//            bibliothek.lendMedium(m3, book, LocalDate.now());
//        } catch (NotAMediumException e) {
//            System.out.println(e.getMessage());
//        } catch (NotAMemberException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            bibliothek.returnMedium(m1, dvd4);
//        } catch (NotAMediumException e) {
//        System.out.println(e.getMessage());
//        } catch (NotAMemberException e) {
//        System.out.println(e.getMessage());
//    }
//
//        bibliothek.printLendings();




    }
}
