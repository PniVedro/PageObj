import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    public TransferPage() {
        amount.shouldBe(visible);
    }

    private SelenideElement amount = $("[data-test-id=amount] input");
    private SelenideElement from = $("[data-test-id=from] input");
    private SelenideElement buttonTopUp = $("[data-test-id=action-transfer]");
    private SelenideElement error = $("[data-test-id=error-notification]");

    public DashboardPage topUp(String amountToTransfer, Data.CardInfo cardInfo) {
        topUpMethod(amountToTransfer, cardInfo);
        return new DashboardPage();
    }

    public void topUpMethod(String amountToTransfer, Data.CardInfo cardInfo) {
        amount.setValue(amountToTransfer);
        from.setValue(cardInfo.getNumber());
        buttonTopUp.click();


    }

    public void errorMessage(String text) {
        error.shouldHave(text(text));
    }
}
