package com.example.napoliniexpress.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.napoliniexpress.R;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SettingsAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_settings, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        EditText firstName, lastName, email, phone, address, city, state, zipCode;
        Button btnUpdate, btnLogout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.profile_img);
            firstName = itemView.findViewById(R.id.profileFirstName);
            lastName = itemView.findViewById(R.id.profileLastName);
            email = itemView.findViewById(R.id.profileEmail);
            phone = itemView.findViewById(R.id.profilePhoneNumber);
            address = itemView.findViewById(R.id.profileAddress);
            city = itemView.findViewById(R.id.profileCity);
            state = itemView.findViewById(R.id.profileState);
            zipCode = itemView.findViewById(R.id.profileZip);
            btnUpdate = itemView.findViewById(R.id.btnUpdate);
            btnLogout = itemView.findViewById(R.id.btnLogout);
        }
    }
}
