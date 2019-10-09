package com.ternakkita.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ternakkita.R;
import com.ternakkita.model.transaction.Transaksi;

import java.util.List;

public class AdapterTransaction extends RecyclerView.Adapter<AdapterTransaction.RecyclerViewTransaction> {

    private Context mContext;
    private List<Transaksi> transaksiList;

    public AdapterTransaction(Context mContext, List<Transaksi> transaksiList) {
        this.mContext = mContext;
        this.transaksiList = transaksiList;
    }

    @NonNull
    @Override
    public RecyclerViewTransaction onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_gridtransaction,parent,false);
        return new RecyclerViewTransaction(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewTransaction holder, int i) {
        final Transaksi getTransaksi = transaksiList.get(i);
        holder.txtTrakNomor.setText(getTransaksi.getNomorTransaction());
        holder.txtTrakproduk.setText(getTransaksi.getJudulProduk());
        holder.txtTrakStatus.setText(getTransaksi.getStatusTransaction());
        holder.txtTrakharga.setText(getTransaksi.getHargaProduk());

        // load image from database into imageview
        Glide.with(holder.imgTrakProduk.getContext())
                .load(getTransaksi.getThumbnailProduct())
                .into(holder.imgTrakProduk);
    }

    @Override
    public int getItemCount() {
        return transaksiList.size();
    }

    class RecyclerViewTransaction extends RecyclerView.ViewHolder{

        ImageView imgTrakProduk;
        TextView txtTrakNomor,txtTrakproduk,txtTrakharga,txtTrakStatus;
        public RecyclerViewTransaction(View itemView) {
            super(itemView);
            imgTrakProduk = itemView.findViewById(R.id.imgTrakProduk);
            txtTrakNomor = itemView.findViewById(R.id.txtTrakNomor);
            txtTrakproduk = itemView.findViewById(R.id.txtTrakproduk);
            txtTrakharga = itemView.findViewById(R.id.txtTrakharga);
            txtTrakStatus = itemView.findViewById(R.id.txtTrakStatus);
        }

    }
}
