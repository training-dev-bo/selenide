package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Login {
    public SelenideElement container = $(".standalone_page");
    private SelenideElement user = $("[name='email']");
    private SelenideElement password = $("#password");
    private SelenideElement login = $(".sel_login");

    public Today loginAs(String userValue, String pwdValue) {
        user.setValue(userValue);
        password.setValue(pwdValue);
        login.click();
        return new Today();
    }
}
