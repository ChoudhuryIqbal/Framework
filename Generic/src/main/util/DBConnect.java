import com.mysql.cj.mysqlx.protobuf.MysqlxConnection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by a on 5/30/2016.
 */
public class DBConnect {
    private Connection connect=null;
    private Statement statement=null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;
    List< String> list=new ArrayList<String>();
    public static Properties loadPropertiesFile() throws Exception{

        Properties prop=new Properties();
        InputStream ism=new FileInputStream("C:\\Users\\a\\IdeaProjects\\FrameWork\\Generic\\lib\\MYSQL.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }

    //connect to Database
    public void connectToDataBase() throws  Exception{

        Properties prop=loadPropertiesFile();
        String driverClass =prop.getProperty("MYSQLJDBC.driver");
        String url=prop.getProperty("MYSQLJDBC.url");
        String userName=prop.getProperty("MYSQLJDBC.userName");
        String password=prop.getProperty("MYSQKJDBC.password");
        //this will load sql driver
        Class.forName(driverClass);
        System.out.println("Database Connected");

    }

    public List<String>readDataBase() throws Exception{
        try{
            connectToDataBase();
            //statement allows to issue SQL Queries to the database
            statement=connect.createStatement();
            resultSet=statement.executeQuery("select * from CnnNewsVertical");
            getResultSetData(resultSet)
        }catch (Exception e){
            throw e;
        }

        finally {
            close();
        }
        return list;
    }
    //uncomplete
    public void queryDatabase(){

    }

    private List<String > getResultSetData(ResultSet resultSet) throws SQLException{
        while(resultSet.next()){
            String itemName=resultSet.getString("NewsTitle");
            list.add(itemName);

        }
        return list;
    }

    private void writeResultSetToConsole(ResultSet resultSet) throws SQLException{
        while(resultSet.next()){
            String itemName=resultSet.getString("NewsTitle");

            System.out.println("News Title: "+itemName);
        }
        }
    private void close(){
        try{
            if (resultSet !=null){
                resultSet.close();

            }
            if(statement !=null){
                statement.close();
            }
            if(connect !=null){
                connect.close();
            }
        }catch (Exception e){

        }
    }
}
