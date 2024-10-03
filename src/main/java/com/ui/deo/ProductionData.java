package com.ui.deo;

public class ProductionData {
    private String location;
    private int chairs2021;
    private int tables2021;
    private int chairs2022;
    private int tables2022;

    public ProductionData(String location, int chairs2021, int tables2021, int chairs2022, int tables2022) {
        this.location = location;
        this.chairs2021 = chairs2021;
        this.tables2021 = tables2021;
        this.chairs2022 = chairs2022;
        this.tables2022 = tables2022;
    }

    // Getters
    public String getLocation() {
        return location;
    }

    public int getChairs2021() {
        return chairs2021;
    }

    public int getTables2021() {
        return tables2021;
    }

    public int getChairs2022() {
        return chairs2022;
    }

    public int getTables2022() {
        return tables2022;
    }

    // Setters
    public void setLocation(String location) {
        this.location = location;
    }

    public void setChairs2021(int chairs2021) {
        this.chairs2021 = chairs2021;
    }

    public void setTables2021(int tables2021) {
        this.tables2021 = tables2021;
    }

    public void setChairs2022(int chairs2022) {
        this.chairs2022 = chairs2022;
    }

    public void setTables2022(int tables2022) {
        this.tables2022 = tables2022;
    }
}
