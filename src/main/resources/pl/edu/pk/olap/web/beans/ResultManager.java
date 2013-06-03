package pl.edu.pk.olap.web.beans;

import pl.edu.pk.olap.async.DataCrawler;
import pl.edu.pk.olap.data.dao.ComputerDAO;
import pl.edu.pk.olap.data.dao.ComputerDAOFactory;
import pl.edu.pk.olap.data.dto.Computer;
import pl.edu.pk.olap.data.dto.GroupingSetsResult;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: suowik
 * Date: 25.05.13
 * Time: 15:28
 */
@ManagedBean(name = "resultManager")
@ViewScoped
public class ResultManager implements Serializable {
    private static final String ROLLUP = "rollup";
    private static final String CUBE = "cube";
    private static final String GROUPING_SETS = "grouping_sets";

    private List<Computer> computers = new ArrayList<Computer>();
    private List<GroupingSetsResult> groupingSetsResults = new ArrayList<GroupingSetsResult>();
    private ComputerDAO computerDAO = ComputerDAOFactory.create();


    public void executeQuery(ActionEvent event) {
        computers = new ArrayList<Computer>();
        groupingSetsResults = new ArrayList<GroupingSetsResult>();
        Object type = event.getComponent().getAttributes().get("query");
        if(ROLLUP.equals(type)){
            computers = computerDAO.rollupCpuPrice();
        } else if(CUBE.equals(type)){
            computers = computerDAO.cubeCpuPrice();
        } else if(GROUPING_SETS.equals(type)){
            groupingSetsResults = computerDAO.groupingSets();
        }
    }

    public void crawl(ActionEvent event){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Rozpoczęto pobieranie danych"));
        new DataCrawler().run();
    }


    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    public List<GroupingSetsResult> getGroupingSetsResults() {
        return groupingSetsResults;
    }

    public void setGroupingSetsResults(List<GroupingSetsResult> groupingSetsResults) {
        this.groupingSetsResults = groupingSetsResults;
    }
}
