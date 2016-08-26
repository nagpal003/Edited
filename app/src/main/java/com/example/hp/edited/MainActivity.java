package com.example.hp.edited;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tx1;
    private TextView tx2;
    private TextView tx3;
    private EditText ed;
    private  EditText score;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx1 = (TextView)findViewById(R.id.textView);//is this number
        tx2 = (TextView)findViewById(R.id.textView2);//prime

        ed = (EditText)findViewById(R.id.editText);//Random number inserted
        score = (EditText)findViewById(R.id.editText2);
        bt1 = (Button)findViewById(R.id.button);//Correct
        bt2 = (Button)findViewById(R.id.button2);//Incorrect
        bt3 = (Button)findViewById(R.id.button3);//Next
        bt4 = (Button)findViewById(R.id.button4);//Hint
        bt5 = (Button)findViewById(R.id.button5);//Cheat

        final Random myrandom = new Random();
        ed.setText(String.valueOf(myrandom.nextInt(1000)));
        bt3.setOnClickListener (new View.OnClickListener() {

            public void onClick(View v)
            {
//When next button is clicked then right and wrong will be disabled
                ed.setText(String.valueOf(myrandom.nextInt(1000)));
                bt1.setEnabled(true);
                bt2.setEnabled(true);
                bt3.setEnabled(false);
                bt4.setEnabled(true);
                bt5.setEnabled(true);


            }
        });
        bt1.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View view)
            {
                bt3.setEnabled(false);
                bt2.setEnabled(false);
                bt4.setEnabled(false);
                bt5.setEnabled(false);
                if(isPrime())
                {
                    Toast.makeText(getApplicationContext(),"You are correct",Toast.LENGTH_SHORT).show();

                    bt3.setEnabled(true);

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "You are incorrect", Toast.LENGTH_SHORT).show();//Gives a msg whether the
                    //user select right ot wrong button

                    bt3.setEnabled(true);

                }
                bt1.setEnabled(false);

            }

        });
        bt2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View vw)
            {
                bt3.setEnabled(false);
                bt1.setEnabled(false);
                bt4.setEnabled(false);
                bt5.setEnabled(false);
                if(!isPrime())
                {
                    Toast.makeText(getApplicationContext(),"You are correct",Toast.LENGTH_SHORT).show();
                    bt3.setEnabled(true);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"You are incorrect",Toast.LENGTH_SHORT).show();
                    bt3.setEnabled(true);
                }
                bt2.setEnabled(false);

            }

        });
        Change();
        Cheater();

    }
    public void display()
    {
        int sc = 0;
        if(bt1.isSelected())
        {

        }
    }
    public boolean isPrime()
    {
        //Generates the prime number
        String n = ed.getText().toString();
        int num;
        num = Integer.parseInt(n);
        for(int i=2;i<=num/2;i++)
        {
            if(num%i == 0)
                return false;
        }
        return true;
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        //This function is used when screen size changes
        super.onRestoreInstanceState(savedInstanceState);

        String savedState = savedInstanceState.getString("saved_state");//To save the screen state
        //so that when the user rotates when in situation of clicking the button the required no. doesn't gets lost
        if(savedState == null)
        {

        }
        else
        {

            ed.setText(savedState);
        }

    }

    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        String stateToSave = ed.getText().toString();

        outState.putString("savedState",stateToSave);


    }

public void Change()
    {
        bt3.setEnabled(false);
        bt4.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View vv)
           {
               Intent i = new Intent(MainActivity.this,SecondActivity.class);
               startActivity(i);

           }
        });
    }


    public void Cheater()
    {
        bt3.setEnabled(false);

        bt5.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View vv)
            {
                String r = ed.getText().toString();
                Intent ii = new Intent(MainActivity.this,ThirdActivity.class);
                ii.putExtra("edit",r);
                startActivity(ii);

            }
        });
    }
}
