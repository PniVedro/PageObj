import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerifyPage {
    private SelenideElement code = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");
    public VerifyPage(){
        code.shouldBe(visible);
    }
    public DashboardPage verify(){
        code.setValue("12345");
        verifyButton.click();
        return new DashboardPage();
    }
}
