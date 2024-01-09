package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AbstractPage {

    private final SelenideElement searchIcon = $("div>[class='quick-search__icon']");
    private final SelenideElement searchField = $("[class='quick-search__field']");
    private final SelenideElement searchSubmit = $("button>[class='quick-search__icon']");
    private final SelenideElement title = $("h1[class='header__title aos-init aos-animate']");

    public SelenideElement getSearchIcon() {
        return searchIcon;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    public SelenideElement getSearchSubmit() {
        return searchSubmit;
    }

    public SelenideElement getTitle() {
        return title;
    }

    public AbstractPage openMainPage(){
        Selenide.open("https://hire-tester.com");
        return this;
    }

    @Step("User fills Search field with search text")
    public SearchResultPage search(String searchText){
        getSearchIcon().shouldBe(Condition.visible).click();
        getSearchField().shouldBe(Condition.visible).sendKeys(searchText);
        getSearchSubmit().shouldBe(Condition.visible).click();
        return new SearchResultPage();
    }

    public void clickJS(SelenideElement se){
        Selenide.executeJavaScript("arguments[0].click();", se);
    }

    public void onHover(){
        String colorWithoutMouse = getTitle().getCssValue("color");
        System.out.println(colorWithoutMouse);
        Selenide.actions().moveToElement(getTitle()).perform();
        String colorAfterOnhover = getTitle().getCssValue("color");
        System.out.println(colorAfterOnhover);
    }

}
