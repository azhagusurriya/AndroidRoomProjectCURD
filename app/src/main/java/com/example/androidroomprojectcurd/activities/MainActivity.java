package com.example.androidroomprojectcurd.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidroomprojectcurd.R;
import com.example.androidroomprojectcurd.adapter.MemberAdapter;
import com.example.androidroomprojectcurd.database.model.Member;
import com.example.androidroomprojectcurd.viewmodel.MemberViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private MemberAdapter adapter;
    private String LOG = "Member";
    private RecyclerView recyclerView;
    private Button btnAddMember;
    private MemberViewModel model;
    private ArrayList<Member> memberItems = new ArrayList<>();
    private ItemTouchHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new MemberViewModel(getApplication());
        helper = new ItemTouchHelper(simpleCallback);

        recyclerView = findViewById(R.id.recyclerview);
        btnAddMember = findViewById(R.id.btnAddMember);


        btnAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, MemberFormActivity.class));
            }
        });

        Log.i(LOG, "Members added are " + model.getItems());
        Log.i(LOG, "Members added in livedata are " + model.getAllMemberItems());

       /* if(model.getAllMemberItems() != null) {
            model.getAllMemberItems().observe(this, members -> {
                memberItems.removeAll(memberItems);
                memberItems.addAll(model.getAllMemberItems().getValue());
                adapter.notifyDataSetChanged();
            });
        }*/



        if(model.getAllMemberItems() != null) {
            memberItems.addAll(model.getItems());
            adapter = new MemberAdapter(this, memberItems, model);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            helper.attachToRecyclerView(recyclerView);
        }




    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            model.deleteMemberItem(memberItems.get(viewHolder.getAdapterPosition()));
            if(model.getAllMemberItems() != null) {
                memberItems.removeAll(memberItems);
                memberItems.addAll(model.getItems());
                adapter = new MemberAdapter(getApplicationContext(), memberItems, model);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
                helper.attachToRecyclerView(recyclerView);
            }
        }
    };
}