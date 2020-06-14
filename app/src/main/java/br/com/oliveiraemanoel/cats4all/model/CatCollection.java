package br.com.oliveiraemanoel.cats4all.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatCollection {

    @SerializedName("data")
    private List<Data> data;

    @SerializedName("success")
    private boolean success;

    @SerializedName("status")
    private int status;

    public List<Data> getData(){
        return this.data;
    }

    public void CatCollection(List<Data> data, boolean success, int status) {
        this.data = data;
        this.success = success;
        this.status = status;
    }





}

