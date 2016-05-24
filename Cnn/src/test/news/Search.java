package news;

import base.CommonAPI;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

/**
 * Created by a on 5/23/2016.
 */
public class Search extends CommonAPI {

    @Test
    public void searchNews() throws InterruptedException{
        clickByCss("#search-button");
        Thread.sleep(1000);
        typeByCss("#search-input-field","Politics");
        takeEnterKeys("#search-input-field");
        Thread.sleep(3000);


    }
}
