package com.example.grocerylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.grocerylist.Adapter.GroceryAdapter;
import com.example.grocerylist.Model.GroceryModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView tasksRecyclerView;
    private GroceryAdapter tasksAdapter;

    //will store all the items
    private List<GroceryModel> taskList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        taskList = new ArrayList<>();

        tasksRecyclerView = findViewById(R.id.RecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new GroceryAdapter(this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        //placeholder data:
        GroceryModel task = new GroceryModel();
        task.setTask("testing...");
        task.setStatus(0);
        task.setId(1);
        taskList.add(task);
        taskList.add(task);
        taskList.add(task);

        tasksAdapter.setTasks(taskList);

    }

}