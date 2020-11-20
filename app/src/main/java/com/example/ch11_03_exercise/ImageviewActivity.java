package com.example.ch11_03_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import android.widget.Toast;
import android.util.Log;
public class ImageviewActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {
    private static String TAG="5App-LifeCycle";
    private ImageSwitcher imgSwitcher;
    private GridView gridView;

    private Integer[] imgArr = {
            R.drawable.img01, R.drawable.img02, R.drawable.img03,
            R.drawable.img04, R.drawable.img05, R.drawable.img06,
            R.drawable.img07, R.drawable.img08};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG,"ImageviewActivity onCreate!");
        Toast.makeText(ImageviewActivity.this,"ImageviewActivity onCreate!",Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);

        ImageAdapter  imgAdap = new ImageAdapter(getApplicationContext(), imgArr );

        gridView = findViewById(R.id.GridView);
        gridView.setAdapter(imgAdap);

        imgSwitcher = findViewById(R.id.imgSwitcher);
        imgSwitcher.setFactory(this);

        gridView.setOnItemClickListener(gridViewOnItemClick);
    }

    private AdapterView.OnItemClickListener gridViewOnItemClick = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View v, int i, long id) {
            int iComPlay=(int)(Math.random()*4+1);

            imgSwitcher.setImageResource(imgArr[i]);



            AlphaAnimation alphaAnimation =new AlphaAnimation(0,1);
            alphaAnimation.setInterpolator(new OvershootInterpolator());// 匿名寫法
            alphaAnimation.setDuration(2000);

            ScaleAnimation scaleAnimation =new ScaleAnimation(0.5f,1,0.5f,1);
            scaleAnimation.setInterpolator(new BounceInterpolator());// 匿名寫法
            scaleAnimation.setDuration(2000);

            TranslateAnimation translateAnimation =new TranslateAnimation(0,0,-600,0);
            //translateAnimation.setInterpolator(new AccelerateInterpolator());  // 匿名寫法
            translateAnimation.setInterpolator(new AnticipateInterpolator());// 匿名寫法
            translateAnimation.setFillAfter(true);
            translateAnimation.setStartOffset(1000);
            translateAnimation.setDuration(2000);

            RotateAnimation rotateAnimation=new RotateAnimation(0,360);
            rotateAnimation.setInterpolator(new DecelerateInterpolator());// 匿名寫法
            rotateAnimation.setDuration(2000);

            switch(iComPlay){
                case 1:
                    imgSwitcher.setAnimation(alphaAnimation);
                    break;
                case 2:
                    imgSwitcher.setAnimation(scaleAnimation);
                    break;
                case 3:
                    imgSwitcher.setAnimation(translateAnimation);
                    break;
                case 4:
                    imgSwitcher.setAnimation(rotateAnimation);
                    break;
            }

        }
    };


    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return v;
    }



    @Override
    protected void onStart() {
        Log.v(TAG,"ImageviewActivity onStart!");
        Toast.makeText(ImageviewActivity.this,"ImageviewActivity onStart!",Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v(TAG,"ImageviewActivity onStop!");
        Toast.makeText(ImageviewActivity.this,"ImageviewActivity onStop!",Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG,"ImageviewActivity onDestroy!");
        Toast.makeText(ImageviewActivity.this,"ImageviewActivity onDestroy!",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.v(TAG,"ImageviewActivity onPause!");
        Toast.makeText(ImageviewActivity.this,"ImageviewActivity onPause!",Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.v(TAG,"ImageviewActivity onResume!");
        Toast.makeText(ImageviewActivity.this,"ImageviewActivity onResume!",Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.v(TAG,"ImageviewActivity onRestart!");
        Toast.makeText(ImageviewActivity.this,"ImageviewActivity onRestart!",Toast.LENGTH_SHORT).show();
        super.onRestart();
    }
}

//使用GridView 必須繼承抽象類別 BaseAdapter
class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private Integer[] miImgArr;

    //建構子 初始化
    public ImageAdapter(Context context,Integer[] imgArr){
        mContext=context;
        miImgArr=imgArr;
    }

    @Override
    public int getCount() {
        return miImgArr.length;
    }

    //getItem 與 getItemId 本例用不到
    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    //顯示GridView的縮圖
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView v = new ImageView(mContext);

        v.setScaleType(ImageView.ScaleType.CENTER_INSIDE);//縮圖的對齊方式
        v.setPadding(0,20,0,0); //縮圖的間距
        v.setLayoutParams(new GridView.LayoutParams(160,160));//縮圖的尺寸
        v.setImageResource(miImgArr[position]);
        return v;
    }
}