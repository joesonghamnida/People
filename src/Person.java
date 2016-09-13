/**
 * Created by joe on 9/12/16.
 */
public class Person implements Comparable {

    int id;
    String firstName;
    String lastName;
    String email;
    String country;
    String ipAddress;

    public Person(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format(" Introducing the redoubtable %s %s from %s\n",firstName,lastName,country);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //for sorting
    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return lastName.compareTo(p.lastName);
    }
}
