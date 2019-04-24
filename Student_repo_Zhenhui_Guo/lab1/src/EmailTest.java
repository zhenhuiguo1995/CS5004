import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {
    private String loginName;
    private String domain;
    private Email email;

    @Before
    public void setUp() throws Exception {
        this.loginName = "guo.zhenhui";
        this.domain = "husky.neu.edu";
        this.email = new Email(loginName, domain);
    }

    @Test
    public void getLoginName() throws Exception {
        assertEquals(this.loginName, email.getLoginName());
    }

    @Test
    public void getDomain() throws Exception {
        assertEquals(this.domain, email.getDomain());
    }

    @Test
    public void setLoginName() throws Exception {
        String anotherLoginName = "njugzh";
        this.email.setLoginName(anotherLoginName);
        assertEquals(anotherLoginName, email.getLoginName());
    }

    @Test
    public void setDomain() throws Exception {
        String anotherDomain = "gmail";
        this.email.setDomain(anotherDomain);
        assertEquals(anotherDomain, this.email.getDomain());
    }


}