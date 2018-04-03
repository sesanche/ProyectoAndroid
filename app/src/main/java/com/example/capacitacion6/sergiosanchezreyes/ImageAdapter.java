package com.example.capacitacion6.sergiosanchezreyes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by capacitacion6 on 16-03-18.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder>{

    private String[] pictures;
    private AdapterView.OnItemClickListener onItemClickListener;


    //constructor de la clase y se le pasa un arreglo
    public ImageAdapter(AdapterView.OnItemClickListener onItemClickListener, String[] pictures){
        this.pictures = pictures;
        this.onItemClickListener = onItemClickListener;
    }


    //aca referenciamos los elementos de la vista y crea el viewholder
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //saca del contexto la vista (para cada celda)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_breed_image,parent,false);

        //declara un ViewHolder. esto se llamara una sola vez dado que ViewHolder se declara static
        return new ImageAdapter.ViewHolder(view);
    }

    //para cargar el string en cada celda
    @Override
    public void onBindViewHolder(ImageAdapter.ViewHolder holder, final int position) {
        Picasso.get().load(pictures[position]).into(holder.imageViewBreed);
    }





    //retorna la cantidad de elementos del arreglo
    @Override
    public int getItemCount() {
        return pictures.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageViewBreed;

        public ViewHolder(View itemView) {
            super(itemView);

            imageViewBreed = itemView.findViewById(R.id.imageViewBreed);
        }
    }



}
