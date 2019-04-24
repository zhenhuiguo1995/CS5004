/**
 * Represents the details of an email address, including login name and domain name
 *
 * @author Zhenhui
 */
public class Email {
    private String loginName;
    private String domain;

    /**
     * Creates an email given the login name and domain.
     *
     * @param loginName, the login name of the email address.
     * @param domain, the domain of the email address.
     */
    public Email(String loginName, String domain) {
        this.loginName = loginName;
        this.domain = domain;
    }

    /**
     * Returns the login name.
     * @return the login name.
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * Returns the domain name.
     * @return the domain name.
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the login name.
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * Sets the domain.
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }
}
