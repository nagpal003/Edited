package com.example.hp.edited;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private Button bt6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        bt6 = (Button)findViewById(R.id.button6);
        bt6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                //Intent i = new Intent(SecondActivity.this,MainActivity.class);
                //startActivity(i);
                finish();
            }

        });

    }
}
