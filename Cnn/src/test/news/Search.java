package news;

import base.CommonAPI;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import reader.ReadNewsData;

import java.io.IOException;

/**
 * Created by a on 5/23/2016.
 */
public class Search extends CommonAPI {

    ReadNewsData readNewsData=new ReadNewsData();


    @Test
    public void searchNews() throws InterruptedException,IOException{
        clickByCss("#search-button");
        Thread.sleep(1000);



        typeByCss("#search-input-field",readNewsData.getData());

        takeEnterKeys("#search-input-field");
        Thread.sleep(3000);


    }
}
