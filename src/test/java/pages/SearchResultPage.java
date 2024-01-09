package pages;

import com.codeborne.selenide.ElementsCollection;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage extends AbstractPage{

    private final ElementsCollection searchResultLinks = $$("h3>a");
    private final ElementsCollection searchResultDescriptions = $$("[class='search-item']>p:not([class='search-date'])");

    public ElementsCollection getSearchResultLinks() {
        return searchResultLinks;
    }

    public ElementsCollection getSearchResultDescriptions() {
        return searchResultDescriptions;
    }

    public boolean searchContains(ElementsCollection searchResultLinks, ElementsCollection searchResultDescriptions){
        List<String> searchResultText =searchResultLinks.asFixedIterable().stream().map(searchResultLink -> searchResultLink.getText()).toList();
        List<String> searchResultDescText = searchResultDescriptions.asFixedIterable().stream().map(searchResultDescription -> searchResultDescription.getText()).toList();

        List<String> concatinated = new ArrayList<>();
        for (int i = 0; i < searchResultText.size();){
            for (int j = 0; j < searchResultDescText.size();){
                concatinated.add(searchResultText.get(i) + searchResultDescText.get(j));
                i++;
                j++;
            }
        }
        return concatinated.stream().allMatch(element -> element.contains("test"));
    }

}
