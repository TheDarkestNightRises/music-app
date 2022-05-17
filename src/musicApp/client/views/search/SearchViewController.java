package musicApp.client.views.search;

import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

public class SearchViewController implements ViewController {
    private SearchViewModel searchViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
       this.viewHandler = vh;
       this.searchViewModel = vmf.getSearchViewModel();
    }
}
