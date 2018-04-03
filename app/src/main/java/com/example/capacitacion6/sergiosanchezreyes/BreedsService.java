package com.example.capacitacion6.sergiosanchezreyes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by capacitacion6 on 16-03-18.
 */

public interface BreedsService {

    //despues de la URL base está el path que definirá a una raza.
    //se da un path y @Query le concatena al final term=variable
    @GET("api/breeds/list")
    Call<ContainerData> findBreeds();


}
