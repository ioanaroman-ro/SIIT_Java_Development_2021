package libraryCatalog;

import java.util.*;

public class Catalog {
    public String CatalogName;
    public static List<Book> books = new ArrayList<>();

    public Catalog(String catalogName, List<Book> books) {
        CatalogName = catalogName;
        Catalog.books = books;
    }


    public static void searchByAuthor(String author, List<Book> books) {
        boolean found = false;
        for (Book book : books) {
            if (book instanceof Novel) {
                Novel novel = (Novel) book;
                if (author.equals(novel.author.toLowerCase())) {
                    System.out.println("We have these novels written by " + novel.author + ": " + novel.name);
                    found = true;
                }
            } else {
                if (book instanceof ArtAlbum) {
                    ArtAlbum artAlbum = (ArtAlbum) book;
                    if (author.equals(artAlbum.author.toLowerCase())) {
                        System.out.println("We have these art albums by " + artAlbum.author + ": " + artAlbum.name);
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            System.err.println("Sorry, we do not have what you asked for. Please try again soon.");
        }
    }


    public static void searchByName(String name, List<Book> books) {
        boolean found = false;
        for (Book book : books) {
            if (book instanceof Novel) {
                Novel novel = (Novel) book;
                if (name.equals(novel.name.toLowerCase())) {
                    if (novel.isAvailable) {
                        System.out.println("We found novel " + novel.name + ", and it is available.");
                    } else {
                        System.out.println("We found novel " + novel.name + ", but you have to wait for it.");
                    }
                    found = true;
                }
            } else {
                if (book instanceof ArtAlbum) {
                    ArtAlbum artAlbum = (ArtAlbum) book;
                    if (name.equals(artAlbum.name.toLowerCase())) {
                        if (artAlbum.isAvailable) {
                            System.out.println("We found art album " + artAlbum.name + ", and it is available.");
                        } else {
                            System.out.println("We found art album " + artAlbum.name + ", but you have to wait for it.");
                        }
                        found = true;
                    }
                }

            }
        }
        if (!found) {
            System.err.println("Sorry, we do not have what you asked for. Please try again soon.");
        }
    }

    public static void searchByNovelType(String type, List<Book> books) {
        boolean found = false;
        for (Book book : books) {
            if (book instanceof Novel) {
                Novel novel = (Novel) book;
                if (type.equals(novel.type.toLowerCase())) {
                    if (novel.isAvailable) {
                        System.out.println("We found " + novel.name + " by " + novel.author + " and it is available.");
                    } else {
                        System.out.println("We found " + novel.name + " by " + novel.author + ", but you have to wait for it.");
                    }
                    found = true;
                }
            }

        }
        if (!found) {
            System.err.println("Sorry, we do not have what you asked for. Please try again soon.");
        }
    }


    public static void loadExistingBooks() {
        Book artAlbum1 = new ArtAlbum("Art Album 1", 50, "Marius Bercea", true, "Matt coated");
        Book artAlbum2 = new ArtAlbum("Art Album 2", 70, "Alexandra Croitoru", true, "Gloss coated");
        Book artAlbum3 = new ArtAlbum("Art Album 3", 20, "Victor Man", true, "Silk coated ");
        Book artAlbum4 = new ArtAlbum("Art Album 4", 100, "Alexandra Croitoru", false, "Matt coated");
        Book artAlbum5 = new ArtAlbum("Art Album 5", 50, "Serban Savu", true, "Gloss coated");
        Book novel1 = new Novel("Twenty Thousand Leagues Under the Sea", 250, "Jules Verne", false, "Fiction");
        Book novel2 = new Novel("David Copperfield", 500, "Charles Dickens", true, "Autobiografic");
        Book novel3 = new Novel("The Shining", 400, "Stephen King", true, "Horror");
        Book novel4 = new Novel("Huckleberry Finn", 250, "Mark Twain", true, "Comedy");
        Book novel5 = new Novel("Dracula", 300, "Bram Stoker", false, "Horror");
        List<Book> novels = Arrays.asList(novel1, novel2, novel3, novel4, novel5);
        List<Book> artAlbums = Arrays.asList(artAlbum1, artAlbum2, artAlbum3, artAlbum4, artAlbum5);
        books.addAll(artAlbums);
        books.addAll(novels);
    }

    public static void checkAvailability(int c, List<Book> books) {
        Scanner scanner = new Scanner(System.in);
        switch (c) {
            case 1 -> {
                System.out.println("Please enter an author to search by:");
                String author = scanner.nextLine().toLowerCase();
                Catalog.searchByAuthor(author, books);
            }
            case 2 -> {
                System.out.println("Please enter a name to search by:");
                String name = scanner.nextLine().toLowerCase();
                Catalog.searchByName(name, books);
            }
            case 3 -> {
                System.out.println("Please enter a novel type to search by:");
                String type = scanner.nextLine().toLowerCase();
                Catalog.searchByNovelType(type, books);
            }
            case 4 -> System.out.println("EXIT");
            default -> {
                System.out.println("An Invalid Choice!");
                System.out.println("Repeat your Choice!");
                c = scanner.nextInt();
                checkAvailability(c, books);
            }
        }
    }

    public static void clientChoice(int c, List<Book> books) {
        Scanner scanner = new Scanner(System.in);
        switch (c) {
            case 1 -> printNovels(books);
            case 2 -> printArtAlbums(books);
            case 3 -> printAllBooks(books);
            default -> {
                System.err.println("This is not a valid choice. Please 1. Choose again or 2. Exit.");
                Scanner sc = new Scanner(System.in);
                c = sc.nextInt();
                if (c == 1) {
                    c = scanner.nextInt();
                    clientChoice(c, books);
                } else {
                    System.out.println("Thank you!");
                }
            }
        }
    }

    private static void printArtAlbums(List<Book> books) {
        String a = "ArtAlbum";
        System.out.println("We have these art albums in our library:");
        availableBooks(a, books);
        System.out.println("You still have to wait for:");
        notAvailableBooks(a, books);
    }

    private static void printNovels(List<Book> books) {
        String n = "Novel";
        System.out.println("We have these novels in our library:");
        availableBooks(n, books);
        System.out.println("You still have to wait for:");
        notAvailableBooks(n, books);
    }

    private static void notAvailableBooks(String b, List<Book> books) {
        for (Book book : books) {
            if ((book instanceof Novel) && (b == "Novel")) {
                Novel novel = (Novel) book;
                if (!novel.isAvailable) {
                    System.out.println(novel.name + " by " + novel.author);
                }
            } else {
                if ((book instanceof ArtAlbum) && (b == "ArtAlbum")) {
                    ArtAlbum artAlbum = (ArtAlbum) book;
                    if (!artAlbum.isAvailable) {
                        System.out.println(artAlbum.name + " by " + artAlbum.author);
                    }
                }
            }
        }
    }

    private static void availableBooks(String b, List<Book> books) {
        for (Book book : books) {
            if ((book instanceof Novel) && (b == "Novel")) {
                Novel novel = (Novel) book;
                if (novel.isAvailable) {
                    System.out.println(novel.name + " by " + novel.author);
                }
            } else {
                if ((book instanceof ArtAlbum) && (b == "ArtAlbum")) {
                    ArtAlbum artAlbum = (ArtAlbum) book;
                    if (artAlbum.isAvailable) {
                        System.out.println(artAlbum.name + " by " + artAlbum.author);
                    }
                }
            }
        }
    }


    public static void addNewBook() {
        System.out.println("Please enter what would you like to add (novel / artalbum): ");
        Scanner sc = new Scanner(System.in);
        String ChosenType = sc.nextLine();
        if (ChosenType.equalsIgnoreCase("novel")) {
            System.out.println("Name:");
            String name = sc.nextLine();
            System.out.println("Author:");
            String author = sc.nextLine();
            System.out.println("Number of pages:");
            int numberOfPages = Integer.parseInt(sc.nextLine());
            System.out.println("Type");
            String type = sc.nextLine();
            System.out.println("Is it available for borrowing?");
            boolean isAvailable = Boolean.parseBoolean(sc.nextLine());
            Book novel = new Novel(name, numberOfPages, author, isAvailable, type);
            books.add(novel);
        } else if (ChosenType.equalsIgnoreCase("artalbum")) {
            System.out.println("Name:");
            String name = sc.nextLine();
            System.out.println("Author:");
            String author = sc.nextLine();
            System.out.println("Paper quality:");
            String paperQuality = sc.nextLine();
            System.out.println("Number of pages:");
            int numberOfPages = Integer.parseInt(sc.nextLine());
            System.out.println("Is it available for borrowing?");
            boolean isAvailable = Boolean.parseBoolean(sc.nextLine());
            Book artAlbum = new ArtAlbum(name, numberOfPages, author, isAvailable, paperQuality);
            books.add(artAlbum);
        }
    }

    public static void printAllBooks(List<Book> books) {
        printNovels(books);
        printArtAlbums(books);
    }

}



