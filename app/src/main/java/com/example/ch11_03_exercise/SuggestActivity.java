package com.example.ch11_03_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import android.widget.Toast;
import android.util.Log;
public class SuggestActivity extends AppCompatActivity {
    private static String TAG="5App-LifeCycle";
    private TextView mTxtResult;
    private Button mBtnDo;
    private RadioGroup mRadGrpGender,mRadGrpAge;
    private RadioButton mRadBtnAge1,mRadBtnAge2,mRadBtnAge3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG,"SuggestActivity onCreate!");
        Toast.makeText(SuggestActivity.this,"SuggestActivity onCreate!",Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);

        mRadGrpGender=findViewById(R.id.radGrpGender);
        mRadGrpAge=findViewById(R.id.radGrpAge);
        mRadBtnAge1=findViewById(R.id.radBtn01);
        mRadBtnAge2=findViewById(R.id.radBtn02);
        mRadBtnAge3=findViewById(R.id.radBtn03);

        mTxtResult=findViewById(R.id.txtResult);
        mBtnDo=findViewById(R.id.btnDo);

        mRadGrpGender.setOnCheckedChangeListener(radGrpGenderOnCheckedChange);
        mBtnDo.setOnClickListener(btnDoOnClick);
    }
    private RadioGroup.OnCheckedChangeListener radGrpGenderOnCheckedChange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int i) {
            switch (mRadGrpGender.getCheckedRadioButtonId()){
                case R.id.rdbMale:
                    mRadBtnAge1.setText(getString(R.string.radbtn_male_age1));
                    mRadBtnAge2.setText(getString(R.string.radbtn_male_age2));
                    mRadBtnAge3.setText(getString(R.string.radbtn_male_age3));
                    break;
                case R.id.rdbFemale:
                    mRadBtnAge1.setText(getString(R.string.radbtn_female_age1));
                    mRadBtnAge2.setText(getString(R.string.radbtn_female_age2));
                    mRadBtnAge3.setText(getString(R.string.radbtn_female_age3));
                    break;

            }

        }
    };


    private View.OnClickListener btnDoOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String strSug=getString(R.string.suggestion);

            switch(mRadGrpAge.getCheckedRadioButtonId()){
                case R.id.radBtn01:
                    strSug+=getString(R.string.not_hurry);
                    break;
                case R.id.radBtn02:
                    strSug+=getString(R.string.find_couple);
                    break;
                case R.id.radBtn03:
                    strSug+=getString(R.string.get_married);
                    break;
            }

            mTxtResult.setText(strSug);
        }
    };


    @Override
    protected void onStart() {
        Log.v(TAG,"SuggestActivity onStart!");
        Toast.makeText(SuggestActivity.this,"SuggestActivity onStart!",Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v(TAG,"SuggestActivity onStop!");
        Toast.makeText(SuggestActivity.this,"SuggestActivity onStop!",Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG,"SuggestActivity onDestroy!");
        Toast.makeText(SuggestActivity.this,"SuggestActivity onDestroy!",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.v(TAG,"SuggestActivity onPause!");
        Toast.makeText(SuggestActivity.this,"SuggestActivity onPause!",Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.v(TAG,"SuggestActivity onResume!");
        Toast.makeText(SuggestActivity.this,"SuggestActivity onResume!",Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.v(TAG,"SuggestActivity onRestart!");
        Toast.makeText(SuggestActivity.this,"SuggestActivity onRestart!",Toast.LENGTH_SHORT).show();
        super.onRestart();
    }
}