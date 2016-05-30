package news;

import org.testng.annotations.Test;
import reader.ReadNewsData;

import java.io.IOException;
import java.util.List;
import util.DBConnect;
/**
 * Created by a on 5/30/2016.
 */
public class SearchNewsFromDB extends base.CommonAPI {

    ReadNewsData readNewsData=new ReadNewsData();
    @Test
    public void searchNews() throws InterruptedException,IOException,Exception{
        List<String>  data=readNewsData.getDataFromDB();
        clickByCss("#search-button");
        Thread.sleep(1000);
        int counter=0;
        for(String st: data){
            if (counter==0){
                typeByCss("#search-input-field",st);
                takeEnterKeys("#search-input-field");
                clearInputField("#searchInputTop");
                Thread.sleep(1000);
                counter++;
            }
            else{

                typeByCss("#searchInputTop",st);
                takeEnterKeys("#searchInputTop");
                Thread.sleep(1000);
                clearInputField("#searchInputTop");
            }

        }



    }

}
