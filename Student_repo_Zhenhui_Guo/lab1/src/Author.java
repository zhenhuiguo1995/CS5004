/**
 * Represents an Author with their details--name, email and phyysical address
 *
 * @author Zhenhui
 */

public class Author {
    private Person person;
    private Email email;
    private Address address;

    /**
     * Creates a new author given the author's name, email and address as strings
     *
     * @param person the author's name
     * @param email the author's email address
     * @param address the author's physical address
     */
    public Author(Person person, Email email, Address address) {
        this.person = person;
        this.email = email;
        this.address = address;
    }

    /**
     * Returns the person.
     * @return the Person.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Returns the email.
     * @return the Email.
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Returns the address.
     * @return the address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the person.
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Sets the email.
     */
    public void setEmail(Email email) {
        this.email = email;
    }

    /**
     * Sets the address.
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
