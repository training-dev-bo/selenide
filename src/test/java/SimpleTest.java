import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {

    @Test
    public void verifyForm() {
        open("https://todoist.com/users/showlogin");
        $("[name='email']").setValue("user");
        $("#password").setValue("password");
        $(".sel_login").click();
    }
}
