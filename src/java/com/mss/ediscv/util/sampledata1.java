 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mss.ediscv.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author janardhan
 */
public class sampledata1 {

    private Connection connection;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    public static void main(String[] args) throws ServiceLocatorException, SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count=0;
        String s1="SELECT * FROM MSCVP_COKE.DBO.FILES WHERE DATE_TIME_RECEIVED >= DATEADD(day, -90, getdate())";
        
            connection = ConnectionProvider.getInstance().getConnection();
            statement = connection.prepareStatement(s1);
            resultSet = statement.executeQuery();
            System.out.println(resultSet);
    }
}
    