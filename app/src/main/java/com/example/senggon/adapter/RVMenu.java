package com.example.senggon.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senggon.R;
import com.example.senggon.model.ModelMenu;

import java.util.ArrayList;


public class RVMenu extends RecyclerView.Adapter<RVMenu.ViewHolder> {
    ArrayList<ModelMenu> menus = new ArrayList<>();

    public RVMenu(ArrayList<ModelMenu> menus) {
        this.menus.addAll(menus);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(menus.get(position).getTitle());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = menus.get(position).getIntent();
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout cardView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardView);
            textView=itemView.findViewById(R.id.item_menu_title);
        }
    }
}
