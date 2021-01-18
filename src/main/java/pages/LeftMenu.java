package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LeftMenu {
    public SelenideElement container = $("#left_menu");
    private String labelSelector = ".item_content";

    public ElementsCollection getFilters() {
        return container.$$("#top_filters li");
    }

    public SelenideElement selectedMenu() {
        return getFilters()
                .filter(Condition.attributeMatching("class",".*current"))
                .first().$(labelSelector);
    }

    public SelenideElement selectedMenuStream() {
        return getFilters()
                .stream()
                .filter(se -> se.has(Condition.cssClass("current")))
                .findFirst()
                .get()
                .$(labelSelector);
    }
}
