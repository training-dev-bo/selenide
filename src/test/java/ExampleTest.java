import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import pages.LeftMenu;
import pages.Login;
import pages.Today;

import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;
public class ExampleTest {

    @Test
    public void verifyForm() throws Exception {
        FileInputStream credFile = new FileInputStream(".\\src\\test\\resources\\credentials.properties");
        Properties credentials = new Properties();
        credentials.load(credFile);
        Configuration.browser = "chrome";
        open("https://todoist.com/users/showlogin");
        new Login()
            .loginAs(credentials.getProperty("user"),credentials.getProperty("password"))
            .container.waitUntil(Condition.appear,5000);
        new Today().container.should(Condition.enabled);
        assertEquals("Hoy", new LeftMenu().selectedMenu().text());
        assertEquals("Hoy", new LeftMenu().selectedMenuStream().text());
    }
}
