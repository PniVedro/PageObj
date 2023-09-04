package ru.netology.page;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.Data;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement login = $("[data-test-id=login] input");
    private SelenideElement password = $("[data-test-id=password] input");
    private SelenideElement buttonLogin = $("[data-test-id=action-login]");

    public VerifyPage loginValid(Data.AuthInfo info) {
        login.setValue(Data.getAuthInfo().getLogin());
        password.setValue(Data.getAuthInfo().getPassword());
        buttonLogin.click();
        return new VerifyPage();

    }
}
