package tests;

import com.codeborne.selenide.ElementsCollection;
import listeners.HTListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AbstractPage;
import pages.SearchResultPage;

//@Listeners(HTListener.class)
public class SearchResultTest extends AbstractTest{

    @Test
    public void searchTest(){
        ElementsCollection searchResultLinks = new AbstractPage().openMainPage()
                .search("test")
                .getSearchResultLinks();
        SearchResultPage searchResultPage = new SearchResultPage();

        ElementsCollection searchResultDescriptions = searchResultPage
                .getSearchResultDescriptions();

        Assert.assertTrue(searchResultPage.searchContains(searchResultLinks, searchResultDescriptions), "search result doesn't contain search text");

    }
}
