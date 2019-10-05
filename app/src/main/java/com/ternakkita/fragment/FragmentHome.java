package com.ternakkita.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ternakkita.R;
import com.ternakkita.adapter.AdapterProduct;
import com.ternakkita.model.getAllproduct.product;
import com.ternakkita.presenter.presenterLoadProduct;
import com.ternakkita.view.interfaceProduct;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment implements interfaceProduct {
    // constractor
    public FragmentHome(){

    }

    // progress dialog
    ProgressDialog loading;

    //context
    Context mContext;

    //widget
    Toolbar toolbar;
    RecyclerView recyclerView;

    //presenter handler
    presenterLoadProduct presenterLoadProduct;
    AdapterProduct adapterProduct;
    List<product> productList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frg_home, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        // toolbar
        toolbar = (Toolbar) getView().findViewById(R.id.toolbar_land);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        // recyclerview
        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerProduct);
        // merubah tampilan recyclerview menjadi gridview
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mGridLayoutManager);
        recyclerView.setHasFixedSize(true);

        //presenter
        presenterLoadProduct = new presenterLoadProduct(this);
        presenterLoadProduct.getData();

        // mengisi data ke dalam variable produklist
        getProduct(productList);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.toolbar_menu, menu);

    }

    @Override
    public void showLoading() {
        loading = ProgressDialog.show(getContext(), null, "Harap Tunggu...", true, false);
    }

    @Override
    public void hideLoading() {
       loading.dismiss();
    }

    @Override
    public void getProduct(List<product> dataList) {
        // set adapter untuk recyclerview
        adapterProduct = new AdapterProduct(getContext(),dataList);
        adapterProduct.notifyDataSetChanged();
        recyclerView.setAdapter(adapterProduct);
        // menampung data dari List<product> dataList ke dalam List<product> productList = new ArrayList<>();
        productList = dataList;

    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }
}
