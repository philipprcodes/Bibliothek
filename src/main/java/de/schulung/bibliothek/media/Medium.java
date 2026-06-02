package de.schulung.bibliothek.media;

import de.schulung.bibliothek.enums.Language;

public abstract class Medium {
    protected final int id;
    protected final String title;
    protected final Language language;
    protected final String year;


    protected boolean isAvailable;

    public Medium(int id, String title, Language language, String year) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.year = year;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Language getLanguage() {
        return language;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getYear() {
        return year;
    }
}
