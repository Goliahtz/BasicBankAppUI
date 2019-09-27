package com.example.bankappuidesign;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BankActivity extends AppCompatActivity {
    TextView titlepage, subtitlepage, completeName, userName,bankone,expired;

    Button btnEdit;

    String SHARED_PREFS = "sharedPrefs";
    String SHARED_PREFS2 = "sharedPrefs2";
    String userCompleteName = "";
    String getUserCompleteName;
    String userUserName = "";
    String getUserUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);
        completeName = findViewById(R.id.completeName);
        userName = findViewById(R.id.userName);
        bankone =findViewById(R.id.bankone);
        expired = findViewById(R.id.expired);
        btnEdit = findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BankActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        loadData();
        updateData();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREFS2, MODE_PRIVATE);
        getUserCompleteName = sharedPreferences.getString(userCompleteName, "");
        getUserUserName= sharedPreferences2.getString(userUserName,"");
    }

    public void updateData() {
        completeName.setText(getUserCompleteName);
        userName.setText(getUserUserName);
    }
}
