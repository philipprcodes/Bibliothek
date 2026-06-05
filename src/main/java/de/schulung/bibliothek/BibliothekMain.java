package de.schulung.bibliothek;

import de.schulung.bibliothek.administration.Bibliothek;
import de.schulung.bibliothek.administration.Member;
import de.schulung.bibliothek.media.Book;
import de.schulung.bibliothek.media.Medium;
import de.schulung.bibliothek.utilities.MediumGenerator;
import de.schulung.bibliothek.utilities.MemberGenerator;

import java.time.LocalDate;


public class BibliothekMain {
    public static void main(String[] args) {
        Bibliothek bibliothek = new Bibliothek();

        Medium book = MediumGenerator.generateBook(bibliothek.getNextId());
        Medium book2 = MediumGenerator.generateBook(bibliothek.getNextId());
        Medium book3 = MediumGenerator.generateBook(bibliothek.getNextId());
        Medium dvd = MediumGenerator.generateDVD(bibliothek.getNextId());
        Medium dvd2 = MediumGenerator.generateDVD(bibliothek.getNextId());
        Medium dvd3 = MediumGenerator.generateDVD(bibliothek.getNextId());

        bibliothek.addToStock(book);
        bibliothek.addToStock(book2);
        bibliothek.addToStock(book3);
        bibliothek.addToStock(dvd);
        bibliothek.addToStock(dvd2);
        bibliothek.addToStock(dvd3);


        bibliothek.printStock();

        Member m1 = MemberGenerator.generateMember(bibliothek.getNextMemberID());
        bibliothek.addToMembers(m1);
        Member m2 = MemberGenerator.generateMember(bibliothek.getNextMemberID());
        bibliothek.addToMembers(m2);
        Member m3 = MemberGenerator.generateMember(bibliothek.getNextMemberID());
        bibliothek.addToMembers(m3);

        bibliothek.printMembers();

        bibliothek.lendMedium(m1, dvd, LocalDate.now());
        bibliothek.lendMedium(m2, dvd2, LocalDate.now());

        bibliothek.printLendings();

        bibliothek.returnMedium(dvd);

        bibliothek.printLendings();



    }
}
