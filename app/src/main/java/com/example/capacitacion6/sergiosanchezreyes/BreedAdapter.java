package com.example.capacitacion6.sergiosanchezreyes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * Created by capacitacion6 on 16-03-18.
 */

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.ViewHolder>{

    private String[] breeds;
    private AdapterView.OnItemClickListener onItemClickListener;


    //constructor de la clase y se le pasa un arreglo de enteros para setear la propiedad cities
    public BreedAdapter(AdapterView.OnItemClickListener onItemClickListener, String[] breeds){
        this.breeds = breeds;
        this.onItemClickListener = onItemClickListener;
    }


    //aca referenciamos los elementos de la vista y crea el viewholder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //saca del contexto la vista (para cada celda)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_breed_name,parent,false);

        //declara un ViewHolder. esto se llamara una sola vez dado que ViewHolder se declara static
        return new ViewHolder(view);
    }

    //para cargar el string en cada celda
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.textViewBreed.setText(breeds[position]);


        holder.textViewBreed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(null, view, position, view.getId());

            }
        });
    }





    //retorna la cantidad de elementos del arreglo
    @Override
    public int getItemCount() {
        return breeds.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewBreed;

        public ViewHolder(View itemView) {
            super(itemView);

            //saca de la vista el textview que se declaró adentro
            textViewBreed = itemView.findViewById(R.id.textViewNameBreed);
        }
    }





}
