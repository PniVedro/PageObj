import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    DashboardPage dashboardPage;

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
        var authInfo = Data.getAuthInfo();
        var loginPage = new LoginPage();
        var verifyPage = loginPage.loginValid(authInfo);
        dashboardPage = verifyPage.verify(Data.getVerificationCodeFor(authInfo));
    }

    @Test

    public void shouldTransferToFirstCard() {
        var firstCardBalance = dashboardPage.getCardBalance(0);
        var secondCardBalance = dashboardPage.getCardBalance(1);
        var amount = Data.getValidAmount(secondCardBalance);
        var expectedFirstCardBalance = firstCardBalance + amount;
        var expectedSecondCardBalance = secondCardBalance - amount;
        var transferPage = dashboardPage.transfer(Data.getFirstCard());
        transferPage.topUp(String.valueOf(amount), Data.getSecondCard());
        var actualFirstCardBalance = dashboardPage.getCardBalance(0);
        var actualSecondCardBalance = dashboardPage.getCardBalance(1);
        assertEquals(expectedFirstCardBalance, actualFirstCardBalance);
        assertEquals(expectedSecondCardBalance, actualSecondCardBalance);
    }

    @Test

    public void shouldShowError() {
        var firstCardBalance = dashboardPage.getCardBalance(0);
        var secondCardBalance = dashboardPage.getCardBalance(1);
        var amount = Data.getInvalidAmount(secondCardBalance);
        var transferPage = dashboardPage.transfer(Data.getFirstCard());
        transferPage.topUpMethod(String.valueOf(amount), Data.getSecondCard());
        transferPage.errorMessage("Недостаточно денег для перевода");
        var actualFirstCardBalance = dashboardPage.getCardBalance(0);
        var actualSecondCardBalance = dashboardPage.getCardBalance(1);
        assertEquals(firstCardBalance, actualFirstCardBalance);
        assertEquals(secondCardBalance, actualSecondCardBalance);
    }
}
