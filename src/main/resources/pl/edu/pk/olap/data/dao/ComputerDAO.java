package pl.edu.pk.olap.data.dao;

import pl.edu.pk.olap.data.dto.Computer;
import pl.edu.pk.olap.data.dto.GroupingSetsResult;

import java.util.List;

/**
 * User: suowik
 * Date: 25.05.13
 * Time: 15:18
 */
public interface ComputerDAO {
    List<Computer> cubeCpuPrice();
    List<Computer> rollupCpuPrice();
    List<GroupingSetsResult> groupingSets();
}
