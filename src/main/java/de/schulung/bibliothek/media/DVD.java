package de.schulung.bibliothek.media;

import de.schulung.bibliothek.enums.Language;

public class DVD extends Medium {

    private final String director;
    private final String length;

    public DVD(int id, String title, Language language, String year, String director, String length) {
        super(id, title, language, year);
        this.director = director;
        this.length = length;
    }
    public String getLength() {
            return length;
        }

    public String getDirector() {
            return director;
        }
}
