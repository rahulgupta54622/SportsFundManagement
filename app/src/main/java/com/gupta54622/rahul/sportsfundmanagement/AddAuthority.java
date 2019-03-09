package com.gupta54622.rahul.sportsfundmanagement;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddAuthority extends AppCompatActivity {

    Button btn_add_authority;
    EditText edit_text_authority_name;
    EditText edit_text_authority_email;
    EditText edit_text_authority_pass;
    EditText edit_text_authority_mob;


    DatabaseReference authorityReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_authority);

        // Initializing firebase app (This line of code is compulsory)
        FirebaseApp.initializeApp(this);

        btn_add_authority = findViewById(R.id.btn_add_authority);
        edit_text_authority_name = findViewById(R.id.edit_text_authority_name);
        edit_text_authority_email = findViewById(R.id.edit_text_authority_email);
        edit_text_authority_pass = findViewById(R.id.edit_text_authority_pass);
        edit_text_authority_mob = findViewById(R.id.edit_text_authority_mob_no);


        btn_add_authority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    authorityReference = FirebaseDatabase.getInstance().getReference("Authority");

                    final String authorityName = edit_text_authority_name.getText().toString().trim();
                    final String authorityEmail = edit_text_authority_email.getText().toString().trim();
                    final String authorityPassword = edit_text_authority_pass.getText().toString().trim();
                    final String authorityMob = edit_text_authority_mob.getText().toString().trim();
                    final List<Request> requestList = new ArrayList<>();
                    final List<Complain> complainList = new ArrayList<>();


                    if (authorityName.equals("")) {
                        giveErrorMessage("Name field can not be empty!!");

                        // Focus to authority name edit text
                        edit_text_authority_name.requestFocus();
                    } else if (authorityEmail.equals("")) {
                        giveErrorMessage("email field can not be empty!!");

                        // Focus to authority name edit text
                        edit_text_authority_email.requestFocus();
                    } else if (authorityPassword.equals("")) {
                        giveErrorMessage("Password field can not be empty!!");

                        // Focus to authority name edit text
                        edit_text_authority_pass.requestFocus();
                    } else if (authorityMob.equals("")) {
                        giveErrorMessage("Mob field can not be empty!!");

                        // Focus to authority name edit text
                        edit_text_authority_mob.requestFocus();
                    } else {

                        // Writing query to check whether an authority already exists
                        Query query = authorityReference.orderByChild("userName").equalTo(authorityName);

                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                // This dataSnapShot is the Authority node with all children with userName = authorityName

                                if (dataSnapshot.exists()) {

                                    giveErrorMessage("Authority: " + authorityName + " already exists");
//                                    for(DataSnapshot authoritySnapShot : dataSnapshot.getChildren()){
//                                        Authority authority = authoritySnapShot.getValue(Authority.class);
//                                        giveErrorMessage(authority.email);
//                                    }

                                } else {
                                    // Create unique id(key) (using push() ) for authority inside "Authority" and get the key(id) using getKey
                                    String authorityId = authorityReference.push().getKey();
                                    Authority authority = new Authority(authorityId, authorityName, authorityPassword, authorityEmail, authorityMob, requestList, complainList);

                                    try {
                                        authorityReference.child(authorityId).setValue(authority);
                                        giveErrorMessage("authority added successfully");
                                    } catch (NullPointerException e) {
                                        giveErrorMessage("authorityId is null");
                                    }
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }

                } catch (Exception e) {
                    Log.i("Error.. ", e.toString());
                }
            }
        });


    }


    void giveErrorMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
