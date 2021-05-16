package com.example.senggon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senggon.R;
import com.example.senggon.model.ModelDiagnosa;

import java.util.ArrayList;

public class RVDiagnosa extends RecyclerView.Adapter<RVDiagnosa.ViewHolder> {

    public static ArrayList<ModelDiagnosa> diagnosas = new ArrayList<>();

    public RVDiagnosa(ArrayList<ModelDiagnosa> diagnosas) {
        RVDiagnosa.diagnosas.clear();
        RVDiagnosa.diagnosas.addAll(diagnosas);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.checkBox.setChecked(diagnosas.get(position).isChecked());
        holder.textView.setText(diagnosas.get(position).getDescription());

        holder.checkBox.setTag(position);
        holder.checkBox.setOnClickListener(view -> {
            Integer pos = (Integer) holder.checkBox.getTag();
            if (diagnosas.get(pos).isChecked()){
                diagnosas.get(pos).setChecked(false);
            }else {
                diagnosas.get(pos).setChecked(true);
            }

        });
        holder.relativeLayout.setOnClickListener(view -> {
            Integer pos = (Integer) holder.checkBox.getTag();
            if (diagnosas.get(pos).isChecked()){
                holder.checkBox.setChecked(false);
                diagnosas.get(pos).setChecked(false);
            }else {
                holder.checkBox.setChecked(true);
                diagnosas.get(pos).setChecked(true);
            }

        });
    }

    @Override
    public int getItemCount() {
        return diagnosas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        private CheckBox checkBox;
        private RelativeLayout relativeLayout;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.rv_title);
            imageView=itemView.findViewById(R.id.rv_img);
            checkBox=itemView.findViewById(R.id.rv_check);
            relativeLayout=itemView.findViewById(R.id.rv_relative);
        }
    }
}

