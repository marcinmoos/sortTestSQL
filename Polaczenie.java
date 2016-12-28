package sorttest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Polaczenie {
    
        private static Polaczenie inst;
        Connection polaczenie;
    
        public static Polaczenie inst() throws ClassNotFoundException, SQLException{
        if(inst == null){
            inst = new Polaczenie();
        }
        return inst;
        }
        
        private Polaczenie() throws ClassNotFoundException, SQLException{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            polaczenie = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "addressbook", "12345678");
        }
        
        /*
        void insertTestData(long size){
            Random randomGenerator = new Random();
            try (PreparedStatement statement = polaczenie.prepareStatement("INSERT INTO SORT_TEST VALUES(TEST_SEQUENCE.nextval,?)")){
                polaczenie.setAutoCommit(false); 
                for(long i = 0; i<=size;i++){
                    statement.setLong(1, randomGenerator.nextLong());
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Polaczenie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        */

}