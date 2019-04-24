package assignment1;

/**
 * Represents a Person with details, including first name and last name
 *
 * @author Zhenhui
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * Creats a person given the first name and last name.
     *
     * @param firstName, the first name of the person.
     * @param lastName, the last name of the person.
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the first name.
     * @return the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name.
     * @return the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
