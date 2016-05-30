package reader;

import util.DataReader;

import java.io.IOException;
import java.util.List;

/**
 * Created by a on 5/28/2016.
 */
public class ReadNewsData {

    DBConnect dbConnect=new DBConnect();

    DataReader dataReader=new DataReader();
    //public String[] getData() throws IOException{
    public String [] getDataFromExcelFile throws IOException{
        String path=System.getProperty("user.dir")+"/data/searchData.xls";

        String[] news=dataReader.fileReader(path);
        return news;
    }
    public List<String> getDataFromDB() throws IOException ,Exception{
        List<String> newsList=dbConnect.readDataBase();
        return newsList;
    }
}
