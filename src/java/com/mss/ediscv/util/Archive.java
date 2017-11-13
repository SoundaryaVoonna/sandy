/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author janardhan
 */
public class   Archive {

    static String password = "Change@13";
    static Connection connection = null;
    static Statement stmt = null;
    static PreparedStatement pstmt = null;
    static PreparedStatement pstmt1 = null;
    static PreparedStatement pstmt2 = null;
    static PreparedStatement pstmt3 = null;
    static CallableStatement ctst = null;
    static ResultSet resultSet = null;
    static String queryString_transaction = null;
    static String delete_QueryString_transaction = null;
    static String url = "jdbc:sqlserver://nt000935;DatabaseName=MSCVP_COKE";
    static String userName = "MSCVP_SQL";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// TODO code application logic here

        List archiveList = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, userName, password);
            String queryString = "select Id, Transaction_Type,FILE_ID,DATE_TIME_RECEIVED from FILES where DATEDIFF(day,DATE_TIME_RECEIVED,getdate()) > 30 AND DATEDIFF(day,DATE_TIME_RECEIVED,getdate()) < 90";
            pstmt = connection.prepareStatement(queryString);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ArchiveBean arc = new ArchiveBean();
                arc.setId(resultSet.getInt("Id"));
                arc.setFileId(resultSet.getString("FILE_ID"));
                arc.setTransactionType(resultSet.getString("Transaction_Type"));
                arc.setDateTimeReceived(resultSet.getTimestamp("DATE_TIME_RECEIVED"));
//                System.out.println("transaction type is " + arc.getTransactionType());
                archiveList.add(arc);
            }
            System.out.println("" + archiveList.toString());
            System.out.println("list size is " + archiveList.size());
            resultSet.close();
            pstmt.close();
            //   storedProcedure(archiveList);
            archiveProcess(archiveList);
            //purgeProcess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void archiveProcess(List archiveList) throws SQLException {
        System.out.println("list size is " + archiveList.size());

        for (int i = 0; i < archiveList.size(); i++) {
            ArchiveBean arc = (ArchiveBean) archiveList.get(i);
            String queryString = "INSERT INTO ARCHIVE_FILES SELECT * FROM FILES WHERE FILE_ID=" + arc.getFileId()
                    + " AND TRANSACTION_TYPE=" + arc.getTransactionType();

            try {
                stmt = connection.createStatement();
                stmt.addBatch(queryString);
                String delQuery = "DELETE FROM FILES WHERE DATEDIFF(day,DATE_TIME_RECEIVED,getdate()) > 30";
                stmt.addBatch(delQuery);

                if (arc.getTransactionType().equals("204")) {
                    System.out.println("in 204");
                    queryString_transaction = "INSERT INTO ARCHIVE_TRANSPORT_LOADTENDER"
                            + "  SELECT * FROM TRANSPORT_LOADTENDER WHERE FILE_ID=" + arc.getFileId()
                            + " ";
                    delete_QueryString_transaction = "DELETE FROM TRANSPORT_LOADTENDER WHERE FILE_ID=" + arc.getFileId();
                } else if (arc.getTransactionType().equals("990")) {
                    System.out.println("in 990");
                    queryString_transaction = "INSERT INTO ARCHIVE_TRANSPORT_LT_RESPONSE"
                            + " SELECT * "
                            + "FROM TRANSPORT_LT_RESPONSE WHERE FILE_ID=" + arc.getFileId()
                            + " ";
                    delete_QueryString_transaction = "DELETE FROM TRANSPORT_LT_RESPONSE WHERE FILE_ID=" + arc.getFileId();
                } else if (arc.getTransactionType().equals("214")) {
                    System.out.println("in 214");
                    queryString_transaction = "INSERT INTO ARCHIVE_TRANSPORT_SHIPMENT"
                            + " SELECT * FROM TRANSPORT_SHIPMENT"
                            + " WHERE FILE_ID =" + arc.getFileId();
                    delete_QueryString_transaction = "DELETE FROM TRANSPORT_SHIPMENT WHERE FILE_ID=" + arc.getFileId();
                } else if (arc.getTransactionType().equals("210")) {
                    System.out.println("in 210");
                    queryString_transaction = "INSERT INTO ARCHIVE_TRANSPORT_INVOICE"
                            + " SELECT *"
                            + " FROM TRANSPORT_INVOICE WHERE FILE_ID=" + arc.getFileId()
                            + "";
                    delete_QueryString_transaction = "DELETE FROM TRANSPORT_INVOICE WHERE FILE_ID=" + arc.getFileId();
                }

                stmt.addBatch(queryString_transaction);
                stmt.addBatch(delete_QueryString_transaction);
                int n[] = stmt.executeBatch();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                stmt.close();

            }
        }

    }

    public static void purgeProcess() throws SQLException {
        System.out.println("in purge process");
        String queryString = "SELECT FILE_ID,TRANSACTION_TYPE FROM ARCHIVE_FILES WHERE DATEDIFF(day,DATE_TIME_RECEIVED,getdate()) > 90";
        try {
            pstmt = connection.prepareStatement(queryString);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String file_id = resultSet.getString("FILE_ID");
                String transaction_type = resultSet.getString("TRANSACTION_TYPE");
                String purgeQuery = "DELETE FROM ARCHIVE_FILES WHERE FILE_ID=" + file_id + " AND TRANSACTION_TYPE=" + transaction_type;
                String purgeTransQuery = null;
                if (transaction_type.equals("204")) {
                    System.out.println("in 204");

                    purgeTransQuery = "DELETE FROM TRANSPORT_LOADTENDER WHERE FILE_ID=" + file_id;
                } else if (transaction_type.equals("990")) {
                    System.out.println("in 990");
                    purgeTransQuery = "DELETE FROM TRANSPORT_LT_RESPONSE WHERE FILE_ID=" + file_id;
                } else if (transaction_type.equals("214")) {
                    System.out.println("in 214");
                    purgeTransQuery = "DELETE FROM TRANSPORT_SHIPMENT WHERE FILE_ID=" + file_id;
                } else if (transaction_type.equals("210")) {
                    System.out.println("in 210");
                    purgeTransQuery = "DELETE FROM TRANSPORT_INVOICE WHERE FILE_ID=" + file_id;
                }
                PreparedStatement delStatement = connection.prepareStatement(purgeQuery);
                PreparedStatement delTransStatement = connection.prepareStatement(purgeTransQuery);
                delTransStatement.setString(1, file_id);
                int n = delStatement.executeUpdate();
                int n1 = delTransStatement.executeUpdate();
                if (n > 0 && n1 > 0) {
                    System.out.println("Purge Successfull");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
    }

}
