package com.example.napoliniexpress.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.napoliniexpress.R;
import com.example.napoliniexpress.models.DetailMenuModel;

import java.util.List;

public class DetailMenuAdapter extends RecyclerView.Adapter<DetailMenuAdapter.ViewHolder>{

    List<DetailMenuModel> list;

    public DetailMenuAdapter(List<DetailMenuModel> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new DetailMenuAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getPrice());
        holder.description.setText(list.get(position).getDescription());

        holder.btnCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, price, description;
        Button btnCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.detail_img);
            name = itemView.findViewById(R.id.detail_name);
            price = itemView.findViewById(R.id.detail_price);
            description = itemView.findViewById(R.id.detail_des);
            btnCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }
}
