package com.example.androidroomprojectcurd.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidroomprojectcurd.R;
import com.example.androidroomprojectcurd.activities.MemberItemActivity;
import com.example.androidroomprojectcurd.database.model.Member;
import com.example.androidroomprojectcurd.viewmodel.MemberViewModel;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<Member> memberArrayList;
    private MemberViewModel model;
    private String LOG = "Member_Intend";

    public MemberAdapter(Context context, ArrayList<Member> memberArrayList, MemberViewModel model) {
        this.context = context;
        this.memberArrayList = memberArrayList;
        this.model = model;
    }

    @NonNull
    @Override
    public MemberAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Member memberItem = memberArrayList.get(position);
        holder.name.setText(memberItem.Name);
        holder.email.setText(memberItem.Email);
        holder.age.setText(memberItem.Age);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MemberItemActivity.class);
                i.putExtra("Member", memberItem.Email);
                Log.i(LOG, "sending the member." + memberItem.Email);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return memberArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name,  email, age;
        private RelativeLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            age = itemView.findViewById(R.id.tvAge);
            layout = itemView.findViewById(R.id.layout);




        }
    }
}
