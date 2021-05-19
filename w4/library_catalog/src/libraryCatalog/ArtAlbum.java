package libraryCatalog;

import java.util.Objects;

public class ArtAlbum extends Book{
    public String paperQuality;

    public ArtAlbum(String name, int numberOfPages, String author, Boolean isAvailable, String paperQuality) {
        super(name, numberOfPages, author, isAvailable);
        this.paperQuality = paperQuality;
    }

    public String getPaperQuality() {
        return paperQuality;
    }

    public void setPaperQuality(String paperQuality) {
        this.paperQuality = paperQuality;
    }

    @Override
    public String toString() {
        return "ArtAlbum{" +
                "paperQuality='" + paperQuality + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtAlbum)) return false;
        ArtAlbum artAlbum = (ArtAlbum) o;
        return Objects.equals(paperQuality, artAlbum.paperQuality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperQuality);
    }
}

