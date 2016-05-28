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
        String[] data=readNewsData.getData();
        clickByCss("#search-button");
        Thread.sleep(1000);
        int counter=0;
        for (String st: data){
            if(counter==0){
                typeByCss("#Search-input-field",st);
                takeEnterKeys("#search-input-field");

                clearInputField("#search-input-field");
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
