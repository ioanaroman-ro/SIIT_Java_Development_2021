package libraryCatalog;

import java.util.Objects;

public class Novel extends Book {
    public String type;

    public Novel(String name, int numberOfPages, String author, Boolean isAvailable, String type) {
        super(name, numberOfPages, author, isAvailable);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Novel)) return false;
        Novel novel = (Novel) o;
        return Objects.equals(type, novel.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
