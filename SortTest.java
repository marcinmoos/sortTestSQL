package sorttest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SortTest {
    
    static List<sortTestCalss> dataList = new LinkedList();
    static long time, selectTime;
    static ResultSet result;
        
    public static void main(String[] args) {
        try {
            Polaczenie con = Polaczenie.inst();
            result = con.polaczenie.createStatement().executeQuery("SELECT COUNT(*)FROM SORT_TEST");
            result.next();
            System.out.println("Tabela zawiera " + result.getString(1) + " wierszy (ID, DATA)");
            time = System.nanoTime();
            result = con.polaczenie.createStatement().executeQuery("SELECT ID, DATA FROM SORT_TEST");
            selectTime = System.nanoTime() - time;
            while(result.next()){
                dataList.add(new sortTestCalss(result.getLong(1),result.getLong(2)));
            }
            time = System.nanoTime();
            Collections.sort(dataList);
            System.out.println("Czas sortowania kolekcji: " + (System.nanoTime() - time)+"ns");
            
            time = System.nanoTime();
            result = con.polaczenie.createStatement().executeQuery("SELECT ID, DATA FROM SORT_TEST ORDER BY DATA");
            System.out.println("Czas sortowania ORDER BY: " + ((System.nanoTime() - time)-selectTime)+"ns");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SortTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
