package com.example.capacitacion6.sergiosanchezreyes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by capacitacion6 on 16-03-18.
 */

public interface BreedService {



    //despues de la URL base está el path que definirá a una raza.
    //se da un path y @Query le concatena al final term=variable
    @GET("api/breed/{breed_name}/images")
    Call<ContainerData> findBreedByName(@Path("breed_name") String breed);


}
