package pl.edu.pk.olap.data.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * User: suowik
 * Date: 25.05.13
 * Time: 15:16
 */
public class ConnectionResolver {
    private static final String DATASOURCE_LOCATION = "java:comp/env/jdbc/olap";
    public static Connection getConnection() {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(DATASOURCE_LOCATION);
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        } catch (NamingException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
