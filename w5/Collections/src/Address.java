import java.util.Objects;

public class Address {
    public String city;
    public String street;
    public int no;

    public Address(String city, String street, int no) {
        this.city = city;
        this.street = street;
        this.no = no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return no == address.no && Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, no);
    }

    @Override
    public String toString() {
        return "Address: " +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", no=" + no + "\n";
    }
}
