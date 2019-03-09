package com.gupta54622.rahul.sportsfundmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {

    Button btn_add_an_authority;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        btn_add_an_authority = findViewById(R.id.btn_add_authority);

        final Intent intent_add_authority = new Intent(this, AddAuthority.class);

        btn_add_an_authority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent_add_authority);
            }
        });
    }
}
