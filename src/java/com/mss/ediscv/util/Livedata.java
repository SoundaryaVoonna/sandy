package com.mss.ediscv.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author janardhan
 */
public class Livedata {

    private Connection connection;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;
    private static ConnectionProvider _instance;

    public static void main(String[] args) throws ServiceLocatorException, SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count=0;
       
        try{
        
            connection = ConnectionProvider.getInstance().getConnection();
        
       
            
       
            statement = (PreparedStatement) connection.createStatement();
             ResultSet rs=statement.executeQuery("SELECT * FROM MSCVP_COKE.DBO.FILES WHERE DATE_TIME_RECEIVED >= DATEADD(day, -30, getdate())");
       
            
        
            System.out.println(rs);
        }
       catch (SQLException se) {
                throw new ServiceLocatorException(se);
            }
        
    }
   
    
}
    


