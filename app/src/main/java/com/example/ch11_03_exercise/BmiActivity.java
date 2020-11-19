package com.example.ch11_03_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import android.widget.Toast;
import android.util.Log;


public class BmiActivity extends AppCompatActivity {
    private static String TAG="5App-LifeCycle";
    protected Button btnDo;
    private NumberPicker nbpkHeight,nbpkWeight;
    private Dialog DlgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG,"BmiActivity onCreate!");
        Toast.makeText(BmiActivity.this,"BmiActivity onCreate!",Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        nbpkHeight=findViewById(R.id.nbpHeight);
        nbpkWeight=findViewById(R.id.nbpWeight);

        nbpkHeight.setMinValue(120);
        nbpkHeight.setMaxValue(220);
        nbpkHeight.setValue(160);
        nbpkWeight.setMinValue(40);
        nbpkWeight.setMaxValue(120);
        nbpkWeight.setValue(60);
        btnDo=findViewById(R.id.btnDo);

        btnDo.setOnClickListener(btnDoOnClick);

    }
    private View.OnClickListener btnDoOnClick =new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            int iHeight=nbpkHeight.getValue();
            int iWeight=nbpkWeight.getValue();

            float cHeight=(float) iHeight/100;
            float cBMI=iWeight/(cHeight*cHeight);
            String strResult;

            if(cBMI < 18.5)
                strResult = getString(R.string.light);
            else if(cBMI > 24)
                strResult = getString(R.string.heavy);
            else
                strResult = getString(R.string.normal);

            DlgBtn=new Dialog(BmiActivity.this);
            DlgBtn.setContentView(R.layout.dlg);
            TextView txtResult=DlgBtn.findViewById(R.id.txtResult);
            txtResult.setText("BMI :"+cBMI+";"+strResult);
            DlgBtn.show();
        }
    };


    @Override
    protected void onStart() {
        Log.v(TAG,"BmiActivity onStart!");
        Toast.makeText(BmiActivity.this,"BmiActivity onStart!",Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v(TAG,"BmiActivity onStop!");
        Toast.makeText(BmiActivity.this,"BmiActivity onStop!",Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG,"BmiActivity onDestroy!");
        Toast.makeText(BmiActivity.this,"BmiActivity onDestroy!",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.v(TAG,"BmiActivity onPause!");
        Toast.makeText(BmiActivity.this,"BmiActivity onPause!",Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.v(TAG,"BmiActivity onResume!");
        Toast.makeText(BmiActivity.this,"BmiActivity onResume!",Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.v(TAG,"BmiActivity onRestart!");
        Toast.makeText(BmiActivity.this,"BmiActivity onRestart!",Toast.LENGTH_SHORT).show();
        super.onRestart();
    }
}