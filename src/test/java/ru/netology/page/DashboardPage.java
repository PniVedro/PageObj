package ru.netology.page;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.Data;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    private SelenideElement head = $("[data-test-id=dashboard]");

    public DashboardPage() {

        head.shouldBe(visible);
    }

    public int getCardBalance(int index) {
        var text = cards.get(index).getText();
        return extractBalance(text);
    }

    public TransferPage transfer(Data.CardInfo cardInfo) {
        cards.findBy(attribute("data-test-id", cardInfo.getId())).$("button").click();
        return new TransferPage();
    }


    private int extractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}