package com.example.napoliniexpress;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.napoliniexpress.adapters.MenuAdapter;
import com.example.napoliniexpress.models.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class NapMenuFragment extends Fragment {

    RecyclerView recyclerView;
    List<MenuModel> menuModels;
    MenuAdapter menuAdapter;

    public NapMenuFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_nap_menu, container, false);

        recyclerView = root.findViewById(R.id.menu_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        menuModels = new ArrayList<>();

        menuModels.add(new MenuModel(R.drawable.appetizers, "Appetizers", "Appetizers"));
        menuModels.add(new MenuModel(R.drawable.salad, "Salads", "Salads"));
        menuModels.add(new MenuModel(R.drawable.soup, "Soups", "Soups"));
        menuModels.add(new MenuModel(R.drawable.pasta, "Pasta", "Pasta"));
        menuModels.add(new MenuModel(R.drawable.heros, "Heros & Dinners", "Heros & Dinners"));
        menuModels.add(new MenuModel(R.drawable.entrees, "Entrees", "Entrees"));
        menuModels.add(new MenuModel(R.drawable.wraps, "Panini & Wraps", "Panini & Wraps"));
        menuModels.add(new MenuModel(R.drawable.calzone, "Calzones & Rolls", "Calzones & Rolls"));
        menuModels.add(new MenuModel(R.drawable.glutenfree, "Gluten Free", "Gluten Free"));
        menuModels.add(new MenuModel(R.drawable.pizza, "Pizza", "Pizza"));
        menuModels.add(new MenuModel(R.drawable.barpie, "Bar Pie", "Bar Pie"));
        menuModels.add(new MenuModel(R.drawable.sideorder, "Side Orders", "Side Orders"));
        menuModels.add(new MenuModel(R.drawable.dessert, "Desserts", "Desserts"));

        menuAdapter= new MenuAdapter(getContext(), menuModels);
        recyclerView.setAdapter(menuAdapter);
        menuAdapter.notifyDataSetChanged();


        return root;
    }
}