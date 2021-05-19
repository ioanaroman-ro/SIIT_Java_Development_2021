import java.util.List;
import java.util.Objects;

public class Hobby {
    public String nameOfHobby;
    public int frequency;
    List<Address> addressList;

    public Hobby(String nameOfHobby, int frequency, List<Address> addressList) {
        this.nameOfHobby = nameOfHobby;
        this.frequency = frequency;
        this.addressList = addressList;
    }

    public String getNameOfHobby() {
        return nameOfHobby;
    }

    public void setNameOfHobby(String nameOfHobby) {
        this.nameOfHobby = nameOfHobby;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobby hobby = (Hobby) o;
        return frequency == hobby.frequency && Objects.equals(nameOfHobby, hobby.nameOfHobby) && Objects.equals(addressList, hobby.addressList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfHobby, frequency, addressList);
    }

    @Override
    public String toString() {
        return "Hobby: " + nameOfHobby + '\'' +
                ", frequency=" + frequency +
                ", addressList=" + "\n" + addressList + "\n";
    }
}
