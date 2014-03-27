package com.wzg.MostFavorable.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.wzg.MostFavorable.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private final String TAG = "wawawawa";
    private int[] imgIds;
    private ViewFlipper viewFlipper;
    private GestureDetector gestureDetector;
    private ListView listView;
    private ArrayList<Map<String,Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home);
        gestureDetector = new GestureDetector(new MyOnGestureListener());
        //这里的数据 后期必改 从接口接来数据再改
        imgIds = new int[]{R.drawable.btn_weight_press, R.drawable.bg_todo, R.drawable.categories_cell_bg_normal};
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlipper.addView(addTextView(getResources().getDrawable(R.drawable.bg_todo)));
        viewFlipper.addView(addTextView(getResources().getDrawable(R.drawable.btn_weight_press)));
        viewFlipper.addView(addTextView(getResources().getDrawable(R.drawable.categories_cell_bg_normal)));
        viewFlipper.addView(addTextView(getResources().getDrawable(R.drawable.categories_cell_bg_selected)));
        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "onTouch " + event.getAction());
                viewFlipper.stopFlipping();             // 点击事件后，停止自动播放
                viewFlipper.setAutoStart(false);
                return gestureDetector.onTouchEvent(event);
            }
        });
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(3000);
        if (viewFlipper.isAutoStart() && !viewFlipper.isFlipping()) {
            viewFlipper.startFlipping();
        }
        init();
    }

    public void init() {
        listView = (ListView)findViewById(R.id.listView);
        list = new ArrayList<Map<String, Object>>();
        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("servers","丽人");
        list.add(map);
        map.put("servers","关于我们");
        list.add(map);
        map.put("servers","休闲娱乐");
        list.add(map);
        final ListViewAdapter adapter = new ListViewAdapter(
                this, list, R.layout.index_list, new String[]{"servers"},
                new int[]{R.id.textView});
        listView.setAdapter(adapter);
        listView = (ListView) findViewById(R.id.listView);
    }


    private TextView addTextView(Drawable d) {
        TextView textView = new TextView(this);
        textView.setBackground(d);
        return textView;
    }

    class MyOnGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d(TAG, "onDown");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d(TAG, "onScroll");
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d(TAG, "onFling");
            if (e1.getX() - e2.getX() > 100) {
                Log.d(TAG, e1.getX() + "this");
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(HomeActivity.this, R.anim.right_in));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(HomeActivity.this, R.anim.lift_out));
                viewFlipper.showPrevious();
                return true;
            } else if ((e1.getX() - e2.getX()) < -100) {
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(HomeActivity.this, R.anim.left_in));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(HomeActivity.this, R.anim.right_out));
                viewFlipper.showNext();
                return true;
            }
            return true;
        }
    }

    class ListViewAdapter extends SimpleAdapter{

        public ListViewAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }
    }

}
