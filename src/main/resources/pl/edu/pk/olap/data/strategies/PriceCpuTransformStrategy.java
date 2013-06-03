package pl.edu.pk.olap.data.strategies;

import pl.edu.pk.olap.data.dto.Computer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: suowik
 * Date: 30.05.13
 * Time: 14:27
 */
public class PriceCpuTransformStrategy implements TransformStrategy<Computer> {
    @Override
    public Computer transform(ResultSet resultSet) throws SQLException {
        Computer computer = new Computer();
        computer.setPrice(resultSet.getInt(1));
        computer.setCpu(resultSet.getString(2));
        computer.setSum(resultSet.getInt(3));
        return computer;
    }
}
