package com.example.androidroomprojectcurd.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidroomprojectcurd.R;
import com.example.androidroomprojectcurd.database.model.Member;
import com.example.androidroomprojectcurd.viewmodel.MemberViewModel;

public class MemberItemActivity extends AppCompatActivity {

    private String LOG = "MemberUpdate";
    private EditText name,email,age;
    private Button btnUpdateMember;
    private MemberViewModel model;
    private Member m;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_form);

        Intent i = getIntent();
        String emailID = i.getStringExtra("Member");
        Log.i(LOG, "The passed object is "+emailID);

        model = new MemberViewModel(getApplication());

     name = findViewById(R.id.edtName);
     age = findViewById(R.id.edtAge);
     email = findViewById(R.id.edtEmail);
     btnUpdateMember = findViewById(R.id.btnSubmit);

    Member member = model.getMemberItem(emailID);

        name.setText(member.getName());
        age.setText(member.getAge());
        email.setText(member.getEmail());

        btnUpdateMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                member.setName(name.getText().toString());
                member.setAge(age.getText().toString());
                member.setEmail(email.getText().toString());
                model.updateMemberItem(member);
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });






    }
}