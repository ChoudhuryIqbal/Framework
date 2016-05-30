import java.util.List;

/**
 * Created by a on 5/30/2016.
 */
public class TestDBConnection {
    public static void main(String[]args)throws Exception{
        DBConnect dbConnect=new DBConnect();
        List<String> newsList=dbConnect.readDataBase();

    }





}
