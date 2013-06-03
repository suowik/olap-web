package pl.edu.pk.olap.data.dto;

import java.io.Serializable;


public class Computer implements Serializable {
    private Integer price;
    private String model;
    private String os = "Brak";
    private String cpu;
    private String ram;
    private String hdd = "SSD";
    private String screen;
    private String graphics = "zintegrowana";
    private Long timestamp;
    private Integer sum;
    private String source;


    public Computer(int price, String model, String os, String cpu, String ram, String hdd, String screen, String graphics, String source) {
        this.price = price;
        this.model = model;
        this.os = os;
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.screen = screen;
        this.graphics = graphics;
        this.source = source;
    }

    public Computer() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
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

    public void setPrice(Integer price) {
        this.price = price;
    }
}

