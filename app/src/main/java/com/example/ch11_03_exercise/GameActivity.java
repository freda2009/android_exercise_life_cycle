package com.example.ch11_03_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.util.Log;

public class GameActivity extends AppCompatActivity {
    private static String TAG="5App-LifeCycle";
    private ImageView imgViewCom;
    private ImageButton mBtnScissors,mBtnStone,mBtnPaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG,"GameActivity onCreate!");
        Toast.makeText(GameActivity.this,"GameActivity onCreate!",Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mBtnScissors=findViewById(R.id.btnScissors);
        mBtnStone=findViewById(R.id.btnStone);
        mBtnPaper=findViewById(R.id.btnaper);
        imgViewCom=findViewById(R.id.imgViewCom);

        mBtnScissors.setOnClickListener(btnScissorsOnClick);
        mBtnStone.setOnClickListener(btnStoneOnClick);
        mBtnPaper.setOnClickListener(btnPaperOnClick);
    }
    ///玩家出Scissor
    private View.OnClickListener btnScissorsOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            int iComPlay=(int)(Math.random()*3+1);
            String str="";
            switch(iComPlay){
                case 1:
                    imgViewCom.setImageResource(R.drawable.scissors);
                    str=getString(R.string.draw);
                    break;
                case 2:
                    imgViewCom.setImageResource(R.drawable.stone);
                    str=getString(R.string.lose);
                    break;
                case 3:
                    imgViewCom.setImageResource(R.drawable.paper);
                    str=getString(R.string.win);
                    break;
            }
            Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
        }
    };
    ////玩家出Stone
    private View.OnClickListener btnStoneOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            int iComPlay=(int)(Math.random()*3+1);

            switch(iComPlay){
                case 1:
                    imgViewCom.setImageResource(R.drawable.scissors);
                    Toast.makeText(GameActivity.this,R.string.win,Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    imgViewCom.setImageResource(R.drawable.stone);
                    Toast.makeText(GameActivity.this,R.string.draw,Toast.LENGTH_LONG).show();
                    break;
                case 3:
                    imgViewCom.setImageResource(R.drawable.paper);
                    Toast.makeText(GameActivity.this,R.string.lose,Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };
    ///玩家出paper
    private View.OnClickListener btnPaperOnClick = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            int iComPlay=(int)(Math.random()*3+1);

            switch(iComPlay){
                case 1:
                    imgViewCom.setImageResource(R.drawable.scissors);
                    //mTxtResult.setText(getString(R.string.lose));
                    Toast.makeText(GameActivity.this,R.string.lose,Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    imgViewCom.setImageResource(R.drawable.stone);
                    //mTxtResult.setText(getString(R.string.win));
                    Toast.makeText(GameActivity.this,R.string.win,Toast.LENGTH_LONG).show();
                    break;
                case 3:
                    imgViewCom.setImageResource(R.drawable.paper);
                    // mTxtResult.setText(getString(R.string.draw));
                    Toast.makeText(GameActivity.this,R.string.draw,Toast.LENGTH_LONG).show();
                    break;
            }
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
        Log.v(TAG,"GameActivity onStart!");
        Toast.makeText(GameActivity.this,"GameActivity onStart!",Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v(TAG,"GameActivity onStop!");
        Toast.makeText(GameActivity.this,"GameActivity onStop!",Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG,"GameActivity onDestroy!");
        Toast.makeText(GameActivity.this,"GameActivity onDestroy!",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.v(TAG,"GameActivity onPause!");
        Toast.makeText(GameActivity.this,"GameActivity onPause!",Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.v(TAG,"GameActivity onResume!");
        Toast.makeText(GameActivity.this,"GameActivity onPause!",Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.v(TAG,"GameActivity onRestart!");
        Toast.makeText(GameActivity.this,"GameActivity onRestart!",Toast.LENGTH_SHORT).show();
        super.onRestart();
    }
}