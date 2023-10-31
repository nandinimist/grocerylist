package com.example.grocerylist.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerylist.MainActivity;
import com.example.grocerylist.Model.GroceryModel;
import com.example.grocerylist.R;

import java.util.List;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.ViewHolder> {
    private List<GroceryModel> groceryList;
    private MainActivity activity;

    public GroceryAdapter(MainActivity activity){
        this.activity = activity;

    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);

    }

    public void onBindViewHolder(ViewHolder holder, int position){
        GroceryModel item = groceryList.get(position);
        holder.task.setText(item.getTask());
        holder.task.setChecked(toBoolean(item.getStatus()));
    }

    public int getItemCount(){
        return groceryList.size();
    }

    private boolean toBoolean(int n){
        return n!=0;
    }

    public void setTasks(List<GroceryModel> groceryList){
        this.groceryList = groceryList;
        notifyDataSetChanged();
    }



    // defines ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox task;

        ViewHolder(View view){
            super(view);
            task = view.findViewById(R.id.todoCheckBox);
        }
    }
}
