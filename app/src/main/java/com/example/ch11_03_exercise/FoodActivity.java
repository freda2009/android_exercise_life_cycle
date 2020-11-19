package com.example.ch11_03_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
public class FoodActivity extends AppCompatActivity {
    private static String TAG="5App-LifeCycle";
    private NumberPicker numPicker;
    private Spinner sprMain;
    private CheckBox chkShrimp,chkTofu;
    private RadioGroup rdgDessert;
    private Button btnCheck;
    private TextView txtResult;
    private String mainMeal="",secondMeal="",dessert="",str="";
    private int table=0,mainMoney=0,secondMoney=0,total=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG,"FoodActivity onCreate!");
        Toast.makeText(FoodActivity.this,"FoodActivity onCreate!",Toast.LENGTH_SHORT).show();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        numPicker=findViewById(R.id.numPicker);
        sprMain=findViewById(R.id.sprMain);
        chkShrimp=findViewById(R.id.chkShrimp);
        chkTofu=findViewById(R.id.chkTofu);
        rdgDessert=findViewById(R.id.rdgDessert);
        btnCheck=findViewById(R.id.btnCheck);
        txtResult=findViewById(R.id.txtResult);

        numPicker.setMinValue(1);
        numPicker.setMaxValue(10);
        numPicker.setValue(1);

        sprMain.setOnItemSelectedListener(sprMainOnItemSelected);

        chkShrimp.setOnCheckedChangeListener(chkListener);
        chkTofu.setOnCheckedChangeListener(chkListener);

        btnCheck.setOnClickListener(btnCheckClick);
    }
    private AdapterView.OnItemSelectedListener sprMainOnItemSelected =new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            switch(i){
                case 0:
                    mainMeal="鮮烤魚排(200元)";
                    mainMoney=200;
                    break;
                case 1:
                    mainMeal="焗烤明蝦(250元)";
                    mainMoney=250;
                    break;
                case 2:
                    mainMeal="法式烤雞(300元)";
                    mainMoney=300;
                    break;
                case 3:
                    mainMeal="嫩煎牛排(350元)";
                    mainMoney=350;
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    //核取方塊 CheckBox.OnCheckedChangeListener
    private CheckBox.OnCheckedChangeListener chkListener = new CheckBox.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String secondMealShrimp="",secondMealTofu="";
            int moneyShrimp=0,moneyTofu=0;

            if(chkShrimp.isChecked()){
                secondMealShrimp="鮮蝦蘆筍(80元)";
                moneyShrimp=80;
            }else{
                secondMealShrimp="";
                moneyShrimp=0;
            }

            if(chkShrimp.isChecked()){
                secondMealShrimp="香炸豆腐(50元)";
                moneyShrimp=50;
            }else{
                secondMealShrimp="";
                moneyShrimp=0;
            }

            secondMeal=secondMealShrimp+secondMealTofu;
            secondMoney=moneyShrimp+moneyTofu;
        }
    };

    private View.OnClickListener btnCheckClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int table = numPicker.getValue();

            switch(rdgDessert.getCheckedRadioButtonId()){
                case R.id.rdbIcecream:
                    dessert="冰淇淋";
                    break;
                case R.id.rdbJelly:
                    dessert= "果凍";
                    break;
            }

            if(secondMeal=="")
                secondMeal="無";

            total=mainMoney+secondMoney;
            str="桌次:"+table+"\n主餐:"+mainMeal+"\n副餐:"+secondMeal+"\n甜點:"+dessert+"\n合計:"+total+"元";
            //txtResult.setText(str);

            new AlertDialog.Builder(FoodActivity.this)
                    .setTitle("點餐結果:")
                    .setMessage(str)
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setCancelable(false)
                    .setPositiveButton("確定",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(FoodActivity.this,
                                            "點餐完成",Toast.LENGTH_SHORT).show();
                                    FoodActivity.this.finish();
                                }
                            })

                    .setNeutralButton("取消",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(FoodActivity.this,
                                            "取消點餐",Toast.LENGTH_SHORT).show();

                                }
                            })
                    .show();
        }
    };
/*
    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }
*/
    @Override
    protected void onStart() {
        Log.v(TAG,"FoodActivity onStart!");
        Toast.makeText(FoodActivity.this,"FoodActivity onStart!",Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v(TAG,"FoodActivity onStop!");
        Toast.makeText(FoodActivity.this,"FoodActivity onStop!",Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG,"FoodActivity onDestroy!");
        Toast.makeText(FoodActivity.this,"FoodActivity onDestroy!",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.v(TAG,"FoodActivity onPause!");
        Toast.makeText(FoodActivity.this,"FoodActivity onPause!",Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.v(TAG,"FoodActivity onResume!");
        Toast.makeText(FoodActivity.this,"FoodActivity onResume!",Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.v(TAG,"FoodActivity onRestart!");
        Toast.makeText(FoodActivity.this,"FoodActivity onRestart!",Toast.LENGTH_SHORT).show();
        super.onRestart();
    }
}