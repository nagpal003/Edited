package com.example.hp.edited;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private Button bt7;
    private TextView tx4;
    private TextView tx5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        bt7 = (Button)findViewById(R.id.button7);
        tx4 = (TextView)findViewById(R.id.textView4);
        tx5 = (TextView)findViewById(R.id.textView5);
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w)
            {
                //Intent ii = new Intent(ThirdActivity.this,MainActivity.class);
                //startActivity(ii);

                Toast.makeText(getApplicationContext(),"You have cheated",Toast.LENGTH_LONG).show();
                finish();
            }

        });


        /*Bundle tt = getIntent().getExtras();
        if(tt!=null)
        {
            String t = tt.getString("edit");
            int m;
            m = Integer.parseInt(t);
            ed2.setText(m);
            boolean ans = false;
            ans = isPrime(t);
            if(!ans)
            {

                tx4.setText("is not a prime number");
            }
            else if(ans)
            {
                tx4.setText("is a prime number");
            }
        }*/
        Intent i = getIntent();
        String s = i.getStringExtra("edit");
        tx5.setText(s);

        isPrime(s);


    }
    public void isPrime(String t)
    {
        int num;
        int flag = 0;
        num = Integer.parseInt(t);
        for(int j=0;j<=num/2;j++)
        {
            if(j%2==0)
            flag = 1;
        }
        if(flag == 1)
        {
            tx4.setText("is not a prime number");
        }
        else
        {
            tx4.setText("is a prime number");
        }


    }



}
