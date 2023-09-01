import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement login = $("[data-test-id=login] input");
    private SelenideElement password = $("[data-test-id=password] input");
    private SelenideElement buttonLogin = $("[data-test-id=action-login]");

    public VerifyPage loginValid(){
        login.setValue("vasya");
        password.setValue("qwerty123");
        buttonLogin.click();
        return new VerifyPage();

    }
}
