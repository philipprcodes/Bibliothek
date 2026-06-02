package de.schulung.bibliothek;

import de.schulung.bibliothek.administration.Bibliothek;
import de.schulung.bibliothek.enums.Language;
import de.schulung.bibliothek.media.Book;
import net.datafaker.Faker;

public class BibliothekMain {
    public static void main(String[] args) {
        Bibliothek bibliothek = new Bibliothek();


        Faker faker = new Faker();

        String title = faker.book().title();
        String author = faker.book().author();




        Book book = new Book(1,faker.book().title(), Language.GERMAN, "2026", "999", faker.book().author(), 100);

        bibliothek.addToStock(book);

        System.out.println(book);



    }
}
