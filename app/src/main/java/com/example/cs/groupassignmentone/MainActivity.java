package com.example.cs.groupassignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Go_OnClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}

/*
Information
1. Name
2. Phone
3. email
4. University
5. Gender
*/
/*
Search

 */