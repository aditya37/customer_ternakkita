package com.ternakkita.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ternakkita.R;
import com.ternakkita.adapter.AdapterProduct;
import com.ternakkita.adapter.AdapterTransaction;
import com.ternakkita.model.transaction.Transaksi;
import com.ternakkita.presenter.presenterLoadProduct;
import com.ternakkita.presenter.presenterTransaction;
import com.ternakkita.sharedPreferences.spLogin;
import com.ternakkita.view.interfaceTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;

public class FragmentTransaksi extends Fragment implements interfaceTransaction {

    // Widget handler
    Toolbar toolbar;
    RecyclerView recyclerView;

    //presenter handler
    presenterTransaction presenterTransaction;
    List <Transaksi> transaksiList = new ArrayList<>();
    // adapter
    AdapterTransaction adapterTransaction;

    // Shared preference
    spLogin spLogin;


    // constractor
    public FragmentTransaksi(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frg_transaksi, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // toolbar
        toolbar = (Toolbar) getView().findViewById(R.id.toolbar_land);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        //SharedPreference
        spLogin = new spLogin(getContext());

        // recyclerview
        recyclerView = (RecyclerView) getView().findViewById(R.id.recylerTransaction);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);


        //presenter
        presenterTransaction = new presenterTransaction(this);
        presenterTransaction.getTransaction(spLogin.getIdCustomer());

        // mengisi data ke dalam variable transaksiList
        getTransaction(transaksiList);
    }

    @Override
    public void getTransaction(List<Transaksi> transaksis) {
        adapterTransaction = new AdapterTransaction(getContext(),transaksis);
        adapterTransaction.notifyDataSetChanged();
        recyclerView.setAdapter(adapterTransaction);
        transaksiList = transaksis;
    }


    @Override
    public void emptyData(String message) {

    }
}
