package com.example.napoliniexpress;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.napoliniexpress.adapters.CartAdapter;
import com.example.napoliniexpress.models.CartModel;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    RecyclerView recyclerView;
    List<CartModel> list;
    CartAdapter cartAdapter;

    public CartFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        list.add(new CartModel(R.drawable.appetizers, "Mozzarella Sticks", "9.20"));
        list.add(new CartModel(R.drawable.salad, "Caesar Salad SM", "6.80"));
        list.add(new CartModel(R.drawable.heros, "Meatball Parmigiana", "15.25"));
        list.add(new CartModel(R.drawable.pizza, "Neopolitan Slice", "3.25"));
        list.add(new CartModel(R.drawable.dessert, "Cannoli", "4.95"));

        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);


        return view;
    }

}