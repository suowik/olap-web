package pl.edu.pk.olap.data.strategies;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: suowik
 * Date: 30.05.13
 * Time: 14:26
 */
public interface TransformStrategy<T> {
    T transform(ResultSet resultSet) throws SQLException;
}
