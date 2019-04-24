/**
 * Represents the owner information of a vehicle
 */
public class Owner {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    /**
     * Creates an owner given the first name, last name and phone number.
     *
     * @param firstName, the first name of the owner.
     * @param lastName, the last name of the owner.
     * @param phoneNumber, the phone number of the owner.
     */
    public Owner(String firstName, String lastName,
                 String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (phoneNumber.length() != 10) {
            System.out.println("Invalid phone number " + phoneNumber);
            return;
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    /**
     * Return the first name of the owner.
     * @return the first name of the owner.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the owner.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return the last name of the owner.
     * @return the last name of the owner.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the owner.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Return the phone number of the owner.
     * @return the phone number of the owner.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the owner.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
