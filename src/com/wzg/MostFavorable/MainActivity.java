package com.wzg.MostFavorable;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

public class MainActivity extends Activity implements GestureDetector.OnGestureListener {
    /**
     * Called when the activity is first created.
     */
    private final String TAG = "wawawawa";
    private int[] imgIds;
    private ViewFlipper viewFlipper;
    private GestureDetector gestureDetector;
    private ImageButton btHome;
    private ImageButton btFavourable;
    private ImageButton btNearby;
    private ImageButton btUser;
    private ImageButton btMore;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        gestureDetector = new GestureDetector(this);
        //这里的数据 后期必改 从接口接来数据再改
        imgIds = new int[]{R.drawable.btn_weight_press, R.drawable.bg_todo, R.drawable.categories_cell_bg_normal};
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlipper.addView(addTextView(getResources().getDrawable(R.drawable.back_button)));
        viewFlipper.addView(addTextView(getResources().getDrawable(R.drawable.bg_todo)));
        viewFlipper.addView(addTextView(getResources().getDrawable(R.drawable.btn_weight_press)));
        viewFlipper.addView(addTextView(getResources().getDrawable(R.drawable.categories_cell_bg_normal)));
        viewFlipper.addView(addTextView(getResources().getDrawable(R.drawable.categories_cell_bg_selected)));
        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG,event.getX()+"");
                return true;
            }
        });
        init();
    }

    public void init() {
        btFavourable = (ImageButton) findViewById(R.id.favourable);
        btFavourable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btFavourableClick(v);
            }
        });
        btHome = (ImageButton) findViewById(R.id.home);
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btHomeClick(v);
            }
        });
        btMore = (ImageButton) findViewById(R.id.more);
        btMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btMoreClick(v);
            }
        });
        btNearby = (ImageButton) findViewById(R.id.nearby);
        btNearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btNearbyClick(v);
            }
        });
        btUser = (ImageButton) findViewById(R.id.user);
        btUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btUserClick(v);
            }
        });
        listView = (ListView) findViewById(R.id.listView);
    }

    private void btFavourableClick(View v){
        btMore.setSelected(false);
        btFavourable.setSelected(true);
        btNearby.setSelected(false);
        btUser.setSelected(false);
        btHome.setSelected(false);
    }
    private void btHomeClick(View v){
        btMore.setSelected(false);
        btFavourable.setSelected(false);
        btNearby.setSelected(false);
        btUser.setSelected(false);
        btHome.setSelected(true);
    }
    private void btMoreClick(View v){
        btMore.setSelected(true);
        btFavourable.setSelected(false);
        btNearby.setSelected(false);
        btUser.setSelected(false);
        btHome.setSelected(false);
    }
    private void btNearbyClick(View v){
        btMore.setSelected(false);
        btFavourable.setSelected(false);
        btNearby.setSelected(true);
        btUser.setSelected(false);
        btHome.setSelected(false);
    }
    private void btUserClick(View v){
        btMore.setSelected(false);
        btFavourable.setSelected(false);
        btNearby.setSelected(false);
        btUser.setSelected(true);
        btHome.setSelected(false);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        return this.gestureDetector.onTouchEvent(event);
    }

    private TextView addTextView(Drawable d) {
        TextView textView = new TextView(this);
        textView.setBackground(d);
        return textView;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d(TAG,e1.getX()+"this");
        if (e1.getX() - e2.getX() > 100) {
            Log.d(TAG,e1.getX()+"this");
            this.viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.right_in));
            this.viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.lift_out));
            this.viewFlipper.showPrevious();
            return true;
        } else if ((e1.getX() - e2.getX()) < -100) {
            this.viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.left_in));
            this.viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.right_out));
            this.viewFlipper.showNext();
            return true;

        }
        return false;

    }
}

