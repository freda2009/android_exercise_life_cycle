package com.example.ch11_03_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static String TAG="5App-LifeCycle";
    private Button btnGame,btnBmi,btnSuggest,btnFood,btnImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG,"MainActivity1 onCreate!");
        Toast.makeText(MainActivity.this,"MainActivity1 onCreate!",Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGame=findViewById(R.id.btnGame);
        btnBmi=findViewById(R.id.btnBmi);
        btnSuggest=findViewById(R.id.btnSuggest);
        btnFood=findViewById(R.id.btnFood);
        btnImageview=findViewById(R.id.btnImageview);


/*
        btnGame.setOnClickListener(btnGameOnClick);
        btnBmi.setOnClickListener(btnBmiOnClick);
        btnSuggest.setOnClickListener(btnSuggestOnClick);
        btnFood.setOnClickListener(btnFoodOnClick);
        btnImageview.setOnClickListener(btnImageviewOnClick);
*/

        btnGame.setOnClickListener(btnOnClick);
        btnBmi.setOnClickListener(btnOnClick);
        btnSuggest.setOnClickListener(btnOnClick);
        btnFood.setOnClickListener(btnOnClick);
        btnImageview.setOnClickListener(btnOnClick);
    }

    private  View.OnClickListener btnOnClick =new View.OnClickListener(){
        Intent it = new Intent();

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnGame:
                    it.setClass(MainActivity.this,GameActivity.class);
                    break;
                case R.id.btnBmi:
                    it.setClass(MainActivity.this,BmiActivity.class);
                    break;
                case R.id.btnSuggest:
                    it.setClass(MainActivity.this,SuggestActivity.class);
                    break;
                case R.id.btnFood:
                    it.setClass(MainActivity.this,FoodActivity.class);
                    break;
                case R.id.btnImageview:
                    it.setClass(MainActivity.this,ImageviewActivity.class);
                    break;

            }
            startActivity(it);
        }
    };


/*
    private View.OnClickListener btnGameOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(MainActivity.this,GameActivity.class);
            startActivity(it);
        }
    };

    private View.OnClickListener btnBmiOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(MainActivity.this,BmiActivity.class);
            startActivity(it);
        }
    };

    private View.OnClickListener btnFoodOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(MainActivity.this,FoodActivity.class);
            startActivity(it);
        }
    };

    private View.OnClickListener btnSuggestOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(MainActivity.this,SuggestActivity.class);
            startActivity(it);
        }
    };

    private View.OnClickListener btnImageviewOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(MainActivity.this,ImageviewActivity.class);
            startActivity(it);
        }
    };
*/

    @Override
    protected void onStart() {
        Log.v(TAG,"MainActivity1 onStart!");
        Toast.makeText(MainActivity.this,"MainActivity1 onStart!",Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v(TAG,"MainActivity1 onStop!");
        Toast.makeText(MainActivity.this,"MainActivity1 onStop!!",Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG,"MainActivity1 onDestroy!");
        Toast.makeText(MainActivity.this,"MainActivity1 onDestroy!!",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.v(TAG,"MainActivity1 onPause!");
        Toast.makeText(MainActivity.this,"MainActivity1 onPause!!",Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.v(TAG,"MainActivity1 onResume!");
        Toast.makeText(MainActivity.this,"MainActivity1 onResume!!",Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.v(TAG,"MainActivity1 onRestart!");
        Toast.makeText(MainActivity.this,"MainActivity1 onRestart!!",Toast.LENGTH_SHORT).show();
        super.onRestart();
    }
}//END OF class MainActivity