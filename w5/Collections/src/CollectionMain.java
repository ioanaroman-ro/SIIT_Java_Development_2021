import java.util.*;

public class CollectionMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* Use a HashMap<Student, List<Hobby>>. */

        HashMap<Student, List<Hobby>> hmap = new HashMap<>();

        Address address1 = new Address("Bucuresti", "Florilor", 20);
        Address address2 = new Address("Iasi", "Soarelui", 15);
        Address address3 = new Address("Cluj", "Al. I. Cuza", 125);
        Address address4 = new Address("Timisoara", "Ghioceilor", 5);
        Address address5 = new Address("Iasi", "Teilor", 10);

        Hobby hobby1 = new Hobby("Cycling", 2, Arrays.asList(address1, address5));
        Hobby hobby2 = new Hobby("Photography", 3, Arrays.asList(address1, address2, address3));
        Hobby hobby3 = new Hobby("Paragliding", 1, Arrays.asList(address2, address4));
        Hobby hobby4 = new Hobby("Fishing", 5, Arrays.asList(address3, address4, address5));
        Hobby hobby5 = new Hobby("Tennis", 1, Arrays.asList(address1, address5));

        List<Hobby> hobbyList1 = new ArrayList<>(Arrays.asList(hobby1, hobby3, hobby5));
        List<Hobby> hobbyList2 = new ArrayList<>(Arrays.asList(hobby2, hobby4));
        List<Hobby> hobbyList3 = new ArrayList<>(Arrays.asList(hobby1, hobby2, hobby3));
        List<Hobby> allHobbies = new ArrayList<>(Arrays.asList(hobby1, hobby2, hobby3, hobby4, hobby5));


        Student student1 = new Student("Ana Popa", 1);
        Student student2 = new Student("Mihai Toma", 2);
        Student student3 = new Student("Gabi Luca", 3);
        List<Student> studentList = new ArrayList<>(Arrays.asList(student1, student2, student3));

        /* Add some information to this map */

        hmap.put(student1, hobbyList1);
        hmap.put(student2, hobbyList2);
        hmap.put(student3, hobbyList3);

        /* For a certain Student , print the names of the hobbies
        and the cities where it can be practiced */

        System.out.println("Enter student ID to get the hobby:(1,2,3) ");

        int s = scanner.nextInt();
        for (Student student : studentList) {
            if (student.getID() == s) {
                List<Hobby> list;
                list = hmap.get(student);
                System.out.println(student.getName() + " has hobbies: ");
                for (Hobby hobby : list) {
                    List<Address> addresses = new ArrayList<>(hobby.addressList);
                    System.out.println();
                    System.out.print(hobby.nameOfHobby + " in ");
                    for (Address address : addresses) {
                        System.out.print(address.getCity() + " ");
                    }
                }
            }
        }
        System.out.println();

        /* Implement an algorithm to determine the collection of students
        that share a particular hobby */

        HashMap<Hobby, List<Student>> studentsWithSameHobbyMap = new HashMap<>();
        System.out.println("Students with same hobbies: ");
        for (Hobby hobby : allHobbies) {
            List<Student> studentsWithSameHobby = findStudentsWithHobby(hobby, hmap);
            studentsWithSameHobbyMap.put(hobby, studentsWithSameHobby);
            System.out.println("Hobby " + hobby.getNameOfHobby() + " : " + studentsWithSameHobbyMap.get(hobby));
        }
        System.out.println();

        /* Implement an algorithm to determine which students exist
        in two of the above collections */

        System.out.print("All hobbies:");
        for (Hobby hobby : allHobbies) {
            System.out.print(hobby.getNameOfHobby() + " ");
        }
        System.out.println();
        scanner.nextLine();
        System.out.println("Enter first hobby to intersect: ");
        String h1 = scanner.nextLine().toLowerCase();
        System.out.println("Enter second hobby to intersect: ");
        String h2 = scanner.nextLine().toLowerCase();

        Hobby hob1 = null;
        Hobby hob2 = null;
        for (Hobby hobby : allHobbies) {
            if (hobby.getNameOfHobby().toLowerCase().equals(h1)) {
                hob1 = hobby;
            } else {
                if (hobby.getNameOfHobby().toLowerCase().equals(h2)) {
                    hob2 = hobby;
                }
            }
        }

        if ((hob1 != null) && (hob2 != null)) {
            Collection<Student> intersection = findIntersection(new HashSet<>(), studentsWithSameHobbyMap.get(hob1), studentsWithSameHobbyMap.get(hob2));
            if (intersection.size() > 0) {
                System.out.println("This students are found in both collections: " + intersection);
            } else {
                System.out.println("No common students.");
            }

        } else {
            System.out.println("No hobby.");
        }
    }

    public static Collection<Student> findIntersection(Collection<Student> newCollection,
                                                       Collection<Student>... collections) {
        boolean first = true;
        for (Collection<Student> collection : collections) {
            if (first) {
                newCollection.addAll(collection);
                first = false;
            } else {
                newCollection.retainAll(collection);
            }
        }
        return newCollection;
    }

    private static List<Student> findStudentsWithHobby(Hobby hobby, HashMap<Student, List<Hobby>> hmap) {
        List<Student> studentsWithSameHobby = new ArrayList<>();
        List<Student> studentsWithHobby = new ArrayList<>(hmap.keySet());
        for (Student student : studentsWithHobby) {
            if (hmap.get(student).contains(hobby)) {
                studentsWithSameHobby.add(student);
            }
        }
        return studentsWithSameHobby;
    }


}
