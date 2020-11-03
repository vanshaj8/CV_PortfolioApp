package com.example.portfolioapp.sidemenu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolioapp.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>
{
    List<MenuItem> mdata;
    Callback listner;

    public MenuAdapter(List<MenuItem> mdata,Callback listener) {
        this.mdata = mdata;
        this.listner=listener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu,parent,false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position)
    {
        holder.icon.setImageResource(mdata.get(position).getIcon());
        if (mdata.get(position).isSelected(true))
        {
            holder.isSelected.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.isSelected.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public  class MenuViewHolder extends  RecyclerView.ViewHolder
    {
        ImageView icon,isSelected;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            icon=itemView.findViewById(R.id.item_menu_icon);
            isSelected=itemView.findViewById(R.id.item_menu_selected);

            // menu Item Click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onSideMenuItem(getAdapterPosition());
                }
            });
        }
    }
}
