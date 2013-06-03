package pl.edu.pk.olap.data.dao;

import pl.edu.pk.olap.data.db.ConnectionResolver;
import pl.edu.pk.olap.data.dto.Computer;
import pl.edu.pk.olap.data.dto.GroupingSetsResult;
import pl.edu.pk.olap.data.strategies.GroupingSetsTransformStrategy;
import pl.edu.pk.olap.data.strategies.TransformStrategy;
import pl.edu.pk.olap.data.strategies.PriceCpuTransformStrategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: suowik
 * Date: 25.05.13
 * Time: 15:27
 */
class ComputerDAOImpl implements ComputerDAO {
    private static final String PRICE_CPU_CUBE_QUERY = "SELECT [price], [ram], sum(cast(price as int)) as suma FROM [dbo].[Computers] GROUP BY cube(ram,price);";
    private static final String PRICE_CPU_ROLLUP_QUERY = "SELECT [price], [hdd], sum(cast(price as int)) as suma FROM [dbo].[Computers] GROUP BY rollup(hdd,price);";
    private static final String GROUPING_SETS_QUERY = "SELECT [price],[source_name],sum(cast(price as int)),count(price) FROM [dbo].[Computers] JOIN [sources] ON (source_id_fk = source_id) GROUP BY grouping sets((price,source_name),source_name);";
    private static final PriceCpuTransformStrategy PRICE_CPU_TRANSFORM_STRATEGY = new PriceCpuTransformStrategy();
    private static final GroupingSetsTransformStrategy GROUPING_SETS_TRANSFORM_STRATEGY = new GroupingSetsTransformStrategy();

    @Override
    public List<Computer> cubeCpuPrice() {
        return get(PRICE_CPU_CUBE_QUERY, PRICE_CPU_TRANSFORM_STRATEGY);
    }

    @Override
    public List<Computer> rollupCpuPrice() {
        return get(PRICE_CPU_ROLLUP_QUERY, PRICE_CPU_TRANSFORM_STRATEGY);
    }

    @Override
    public List<GroupingSetsResult> groupingSets() {
        return get(GROUPING_SETS_QUERY, GROUPING_SETS_TRANSFORM_STRATEGY);
    }

    private <T> List<T> get(String query, TransformStrategy<T> strategy) {
        List<T> result = new ArrayList<T>();
        Connection connection = ConnectionResolver.getConnection();
        try {
            populateResultList(result, forResultSet(connection, query), strategy);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            gentlyClose(connection);
        }
        return result;
    }

    private void gentlyClose(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private <T> void populateResultList(List<T> result, ResultSet resultSet, TransformStrategy<T> strategy) throws SQLException {
        while (resultSet.next()) {
            result.add(strategy.transform(resultSet));
        }
    }

    private ResultSet forResultSet(Connection connection, String query) throws SQLException {
        PreparedStatement statement = getStatement(connection, query);
        return statement.executeQuery();
    }

    private PreparedStatement getStatement(Connection connection, String query) throws SQLException {
        return connection.prepareStatement(query);
    }

}
