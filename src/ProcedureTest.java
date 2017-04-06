
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ivan Zhu <ivanzhujunwei@gmail.com>
 */
public class ProcedureTest
{

    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148B";
    private static final String DB_USER = "S27118347";
    private static final String DB_PASSWORD = "student";

    public static void main(String[] argv)
    {
        try {
            callOracleStoredProc();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void callOracleStoredProc() throws
            SQLException
    {
        Connection dbConnection = null;
        CallableStatement callableStatement = null;
        String UPDATEEmailRecord = "{call updateCustomerEmail(?,?)}";
        try {
            dbConnection = getDBConnection();
            callableStatement = dbConnection.prepareCall(UPDATEEmailRecord);
            callableStatement.setInt(1, 10001);
            callableStatement.setString(2, "liuzhuohan@qq.com");
            callableStatement.executeUpdate();
            dbConnection.commit();
            System.out.println("Update Sucessfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (callableStatement != null) {
                callableStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static Connection getDBConnection()
    {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

}
