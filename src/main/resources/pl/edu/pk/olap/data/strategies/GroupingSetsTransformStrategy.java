package pl.edu.pk.olap.data.strategies;

import pl.edu.pk.olap.data.dto.GroupingSetsResult;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: suowik
 * Date: 30.05.13
 * Time: 14:50
 */
public class GroupingSetsTransformStrategy implements TransformStrategy<GroupingSetsResult> {
    @Override
    public GroupingSetsResult transform(ResultSet resultSet) throws SQLException {
        GroupingSetsResult result = new GroupingSetsResult();
        result.setPrice(resultSet.getInt(1));
        result.setSource(resultSet.getString(2));
        result.setSum(resultSet.getInt(3));
        result.setCount(resultSet.getInt(4));
        return result;
    }
}
