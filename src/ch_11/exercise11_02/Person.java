package ch_11.exercise11_02;

/**
 * A person has a name, address, phone number, and email address.
 * Override the toString method in each class to display the class name and the person’s
 * name.
 */
public class Person {

    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person() {}

    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }


    public Person setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Person setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Person setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    @Override
    public String toString() {
        return "Person.class: { " +
                "Name= " + name +
                " }";
    }


}
