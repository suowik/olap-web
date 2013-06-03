package pl.edu.pk.olap.data.dao;

/**
 * User: suowik
 * Date: 25.05.13
 * Time: 15:27
 */
public class ComputerDAOFactory {
    public static final ComputerDAO create(){
        return new ComputerDAOImpl();
    }
}
