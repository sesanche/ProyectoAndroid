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

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //almacenar lista de images
    private String [] pictures;

    //lista de elementos en la vista
    private RecyclerView recyclerViewBreed;

    //adaptador de elementos
    private RecyclerView.Adapter adapterBreed;

    //permite personalizar vista y comportamiento de RecyclerView
    private RecyclerView.LayoutManager layautManagerBreed;

    //declaro un servicio
    private BreedService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //referencia para manipular recycler
        recyclerViewBreed = findViewById(R.id.recyclerViewBreed);
        //no reconstruya al renderrizar
        recyclerViewBreed.setHasFixedSize(true);

        //instancio un manager
        layautManagerBreed = new LinearLayoutManager(this);
        //asocio el manager con el recycler
        recyclerViewBreed.setLayoutManager(layautManagerBreed);

        //arranco retrofit
        initRetrofitBreed();

        //recupero fotos

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String j;
        if(b != null){
            j = (String) b.get("Nombre");
        }
        else{
            j = "akita";
        }
        service.findBreedByName(j).enqueue(new Callback<ContainerData>() {
            @Override
            public void onResponse(Call<ContainerData> call, Response<ContainerData> response) {

                pictures = response.body().getBreedArray();

                if(pictures.length == 0) return;

                //le paso el arreglo al adaptador
                adapterBreed = new ImageAdapter(Main2Activity.this, pictures);

                //asociar a recycler el adapter
                recyclerViewBreed.setAdapter(adapterBreed);
            }

            @Override
            public void onFailure(Call<ContainerData> call, Throwable t) {

            }
        });
    }




    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "URL: " + pictures[position], Toast.LENGTH_SHORT).show();

    }


    public void initRetrofitBreed(){

        //creamos el retrofit pasandole la URL base e indicandolé que sea interpretado como
        //un GSON

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        //Se le pasa está base al service ara que complete para cada artista
        service = retrofit.create(BreedService.class);

    }



}
