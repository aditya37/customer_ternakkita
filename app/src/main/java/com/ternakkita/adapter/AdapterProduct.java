package com.ternakkita.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ternakkita.R;
import com.ternakkita.activity.cls_detailProduk;
import com.ternakkita.model.getAllproduct.product;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.RecyclerViewAdapter> {

   private Context context;
   private List<product> products;
   //private ItemClickListener itemClickListener;
   Intent intent = new Intent();

    public AdapterProduct(Context context, List<product> products) {
        this.context = context;
        this.products = products;
     //   this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_gridview,parent,false);
        return new RecyclerViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter holder, int i) {
        final product getproduk = products.get(i);


        holder.txtPrice.setText("Rp "+ getproduk.getHarga());
        holder.txtJudul.setText(getproduk.getJudul());
        holder.txtProvinsi.setText(getproduk.getProvinsi());


        // load image from database into imageview
        Glide.with(holder.imgProduk.getContext())
                .load(getproduk.getThumbnail())
                .into(holder.imgProduk);
        holder.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, cls_detailProduk.class);
                intent.putExtra("key_id_barang",getproduk.getIdProduct());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
       return products.size();
    }

    class RecyclerViewAdapter extends RecyclerView.ViewHolder{

        TextView txtPrice,txtJudul,txtProvinsi;
        ImageView imgProduk;
        CardView cardItem;
        //ItemClickListener itemClickListener;

         RecyclerViewAdapter(View itemView) {
            super(itemView);

            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtJudul = itemView.findViewById(R.id.txtNameProduct);
            txtProvinsi = itemView.findViewById(R.id.txtVendorLok);
            imgProduk = itemView.findViewById(R.id.imgProduk);
            cardItem = itemView.findViewById(R.id.productCard);

             //this.itemClickListener = itemClickListener;

        }
    }

}