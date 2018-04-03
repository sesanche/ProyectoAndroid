package com.example.capacitacion6.sergiosanchezreyes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //almacenar lista de breeds
    private String [] breeds;

    //lista de elementos en la vista
    private RecyclerView recyclerViewBreeds;

    //adaptador de elementos
    private RecyclerView.Adapter adapterBreeds;

    //permite personalizar vista y comportamiento de RecyclerView
    private RecyclerView.LayoutManager layautManagerBreeds;

    //declaro un servicio
    private BreedsService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencia para manipular recycler
        recyclerViewBreeds = findViewById(R.id.recyclerViewBreeds);
        //no reconstruya al renderrizar
        recyclerViewBreeds.setHasFixedSize(true);

        //instancio un manager
        layautManagerBreeds = new LinearLayoutManager(this);
        //asocio el manager con el recycler
        recyclerViewBreeds.setLayoutManager(layautManagerBreeds);

        //arranco retrofit
        initRetrofitBreeds();

        //recupero lista de razas
        service.findBreeds().enqueue(new Callback<ContainerData>() {
            @Override
            public void onResponse(Call<ContainerData> call, Response<ContainerData> response) {

                breeds = response.body().getBreedArray();

                if(breeds.length == 0) return;

                //le paso el arreglo al adaptador
                adapterBreeds = new BreedAdapter(MainActivity.this, breeds);

                //asociar a recycler el adapter
                recyclerViewBreeds.setAdapter(adapterBreeds);


            }

            @Override
            public void onFailure(Call<ContainerData> call, Throwable t) {

            }
        });

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "Cargando info de la raza " + breeds[position], Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        i.putExtra("Nombre", breeds[position]);
        startActivity(i);
    }


    public void initRetrofitBreeds(){

        //creamos el retrofit pasandole la URL base e indicandolé que sea interpretado como
        //un GSON

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        //Se le pasa está base al service ara que complete para cada artista
        service = retrofit.create(BreedsService.class);

    }



}
