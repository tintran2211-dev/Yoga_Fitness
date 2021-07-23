package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Adapter.Adapter;
import My_Interface.Interface;
import Object.User;

public class Exerc_menu extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exerc_menu);
        recyclerView = findViewById(R.id.recycleView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(getListUser(), new Interface() {
            @Override
            public void onclick(User user) {
                onClick(user);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.boat_pose,"Bài thực hành số 1"));
        list.add(new User(R.drawable.bow_pose,"Bài thực hành số 2"));
        list.add(new User(R.drawable.cobra_pose,"Bài thực hành số 3"));
        list.add(new User(R.drawable.crescent_lunge,"Bài thực hành số 4"));
        list.add(new User(R.drawable.downward_facing_dog,"Bài thực hành số 5"));
        list.add(new User(R.drawable.half_pigeon,"Bài thực hành số 6"));
        list.add(new User(R.drawable.easy_pose,"Bài thực hành số 7"));
        list.add(new User(R.drawable.downward_facing_dog,"Bài thực hành số 8"));
        list.add(new User(R.drawable.low_lunge,"Bài thực hành số 9"));
        list.add(new User(R.drawable.upward_bow,"Bài thực hành số 11"));
        list.add(new User(R.drawable.warrior_pose,"Bài thực hành số 12"));
        list.add(new User(R.drawable.warrior_pose_2,"Bài thực hành số 13"));
        return list;
    }

    private void onClick(User user){
        Intent intent = new Intent(this,Detail.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user",user);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}