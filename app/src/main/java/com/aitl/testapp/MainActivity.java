package com.aitl.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    Button myButton, sumButton;
    CheckBox myCheckBox;
    EditText namePerson;
    EditText ebNumber1,ebNumber2;
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myButton = (Button)findViewById(R.id.button);
        myCheckBox = (CheckBox)findViewById(R.id.checkBox);
        namePerson = (EditText) findViewById(R.id.editText);
        ebNumber1 = (EditText) findViewById(R.id.editText3);
        ebNumber2 = (EditText) findViewById(R.id.editText4);
        tvOutput = (TextView) findViewById(R.id.output);
        sumButton = (Button) findViewById(R.id.buttonsum);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        myButton.setOnClickListener(buttonClickListner);
        myCheckBox.setOnCheckedChangeListener(mycbListner); //mycbListner //buttonSumClickListner
        sumButton.setOnClickListener(buttonSumClickListner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    public void ButtonOncLick(View view) {
        Toast.makeText(getApplicationContext(),"Button Clicked!",Toast.LENGTH_SHORT).show();
    }


    public void ButtonOncLick(View view) {

    }
    */

    Button.OnClickListener buttonClickListner = new Button.OnClickListener(){

        @Override
        public void onClick(View view) {

            String name = namePerson.getText().toString();

            int n1 = Integer.valueOf(ebNumber1.getText().toString());
            int n2 = Integer.valueOf(ebNumber2.getText().toString());

            int sum =  n1 + n2;

            tvOutput.setText("Sum Vale:"+sum);

            Toast.makeText(getApplicationContext(),"Button Clicked By: "+name,Toast.LENGTH_SHORT).show();

            Intent myIntent = new Intent(MainActivity.this,Main2Activity.class);

            startActivity(myIntent);
        }
    };


    Button.OnClickListener buttonSumClickListner = new Button.OnClickListener(){

        @Override
        public void onClick(View view) {

            Toast.makeText(getApplicationContext(),"Button Clicked By: ",Toast.LENGTH_SHORT).show();
        }
    };

    public void MyCBOnClick(View view) {

    }



    CheckBox.OnCheckedChangeListener mycbListner = new CheckBox.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            Log.d(TAG,"Check Box Checked Status: "+b);
            Toast.makeText(getApplicationContext(),"Check Box Checked Status: "+b,Toast.LENGTH_SHORT).show();
        }
    };
}
