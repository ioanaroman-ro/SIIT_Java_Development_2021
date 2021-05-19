package libraryCatalog;

import java.util.Objects;

public class Book {
    public String name;
    public int numberOfPages;
    public String author;
    public Boolean isAvailable;

    public Book(String name, int numberOfPages, String author, Boolean isAvailable) {
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(isAvailable, book.isAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfPages, author, isAvailable);
    }
}
