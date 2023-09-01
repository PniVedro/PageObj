import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;

public class BankTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test

    public void authTest(){
        var loginPage = new LoginPage();
        var verificationPage = loginPage.loginValid();
        var dashboardPage = verificationPage.verify();
        dashboardPage.getCardBalance(0);



    }
}
