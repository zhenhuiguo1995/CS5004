public class AccountHolder {
    private String firstName;
    private String lastName;

    /**
     * Creates an account holder given the first name and last name.
     *
     * @param firstName, the account holder's first name.
     * @param lastName, the account holder's last name.
     */
    public AccountHolder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the first name.
     * @return the frist name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name.
     * @return the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
