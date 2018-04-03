package com.example.capacitacion6.sergiosanchezreyes;

/**
 * Created by capacitacion6 on 16-03-18.
 */

import com.google.gson.annotations.SerializedName;

public class ContainerData {

    private String status;

    //Se serializa el nombre del Gson para que lo pueda recuprar bien. se declaran parametros más
    //intuitivos dentro de la clase
    @SerializedName("message") private String[] breedArray;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getBreedArray() {
        return breedArray;
    }

    public void setBreedArray(String[] breedArray) {
        this.breedArray = breedArray;
    }
}
