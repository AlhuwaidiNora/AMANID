package com.example.amanid;

public class HistoryModel {
    private String id;
    private String name;
    private String amount;
    private String idnum;

    public HistoryModel() {
    }

    public HistoryModel(String id, String name, String amount, String idnum) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.idnum = idnum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }
}
