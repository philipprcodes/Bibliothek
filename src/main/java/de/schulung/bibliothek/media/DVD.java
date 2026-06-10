package de.schulung.bibliothek.media;

import de.schulung.bibliothek.enums.Language;

public class DVD extends Medium {

    private final String director;
    private final int length;

    public DVD(int id, String title, Language language, int year, String director, int length) {
        super(id, title, language, year);
        this.director = director;
        this.length = length;
    }
    public int getLength() {
            return length;
        }

    public String getDirector() {
            return director;
        }


        @Override
        public String generateInfoString(){
            return super.generateInfoString() + "Director: " + director + ", Length: " + length;
        }

    @Override
    public String toString() {
        return "DVD{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", language=" + language +
                ", year=" + year +
                ", length='" + length + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
