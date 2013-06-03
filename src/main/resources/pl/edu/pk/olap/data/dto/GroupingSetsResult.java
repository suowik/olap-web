package pl.edu.pk.olap.data.dto;

import java.io.Serializable;

/**
 * User: suowik
 * Date: 30.05.13
 * Time: 14:48
 */
public class GroupingSetsResult implements Serializable{
    private Integer price;
    private Integer count;
    private Integer sum;
    private String source;

    public GroupingSetsResult(Integer price, Integer count, Integer sum, String source) {
        this.price = price;
        this.count = count;
        this.sum = sum;
        this.source = source;
    }

    public GroupingSetsResult() {
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
