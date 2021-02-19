package com.example.androidroomprojectcurd.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidroomprojectcurd.R;
import com.example.androidroomprojectcurd.database.model.Member;
import com.example.androidroomprojectcurd.viewmodel.MemberViewModel;

public class MemberFormActivity extends AppCompatActivity {


    private EditText edtEmail,edtName,edtAge;
    private Button btnSubmit;
    private MemberViewModel model;
    private String LOG = "Member_Added";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_form);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtEmail = findViewById(R.id.edtEmail);
        btnSubmit = findViewById(R.id.btnSubmit);

        model = new MemberViewModel(getApplication());


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Member m = new Member();
                m.Age = edtAge.getText().toString();
                m.Email = edtEmail.getText().toString();
                m.Name = edtName.getText().toString();

                model.insertMemberItem(m);
                Log.i(LOG, "Added the member." + m);

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });






    }
}