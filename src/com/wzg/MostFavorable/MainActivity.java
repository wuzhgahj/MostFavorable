package com.wzg.MostFavorable;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.wzg.MostFavorable.view.*;

public class MainActivity extends TabActivity {
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
    private TabHost tabs;

    TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
//        init();
        test();
    }

    public void test() {
        mTabHost = getTabHost();
        Intent intent1 = new Intent(this, HomeActivity.class);
        View view = LayoutInflater.from(this).inflate(R.layout.homestate, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_tab);
        tv.setText("");
        mTabHost.addTab(mTabHost.newTabSpec("")
                .setIndicator(view)
                .setContent(intent1));

        Intent intent2 = new Intent(this, FavorableActivity.class);
        view = LayoutInflater.from(this).inflate(R.layout.favorablestate, null);
        TextView tv1 = (TextView) view.findViewById(R.id.tv_tab);
        tv1.setText("");
        mTabHost.addTab(mTabHost.newTabSpec("")
                .setIndicator(view)
                .setContent(intent2));

        Intent intent3 = new Intent(this, NearbyActivity.class);
        view = LayoutInflater.from(this).inflate(R.layout.nearbystate, null);
        TextView tv3 = (TextView) view.findViewById(R.id.tv_tab);
        tv3.setText("");
        mTabHost.addTab(mTabHost.newTabSpec("")
                .setIndicator(view)
                .setContent(intent3));

        Intent intent4 = new Intent(this,LoginActivity.class);
        view = LayoutInflater.from(this).inflate(R.layout.loginstate, null);
        TextView tv4 = (TextView) view.findViewById(R.id.tv_tab);
        tv4.setText("");
        mTabHost.addTab(mTabHost.newTabSpec("")
                .setIndicator(view)
                .setContent(intent4));

        Intent intent5 = new Intent(this,MoreInfoActivity.class);
        view = LayoutInflater.from(this).inflate(R.layout.morestate, null);
        TextView tv5 = (TextView) view.findViewById(R.id.tv_tab);
        tv5.setText("");
        mTabHost.addTab(mTabHost.newTabSpec("")
                .setIndicator(view)
                .setContent(intent5));
        mTabHost.setCurrentTab(0);
    }

//    private void createTab(String text, Intent intent) {
//        mTabHost.addTab(mTabHost.newTabSpec(text)
//                .setIndicator(createTabView(text))
//                .setContent(intent));
//    }

//    private View createTabView(String text) {
//        View view = LayoutInflater.from(this).inflate(R.layout.homestate, null);
//        TextView tv = (TextView) view.findViewById(R.id.tv_tab);
//        tv.setText(text);
//        return view;
//    }

    public void init() {
        final Resources res = getResources();
        final TabHost tabHost = getTabHost();

        TabHost.TabSpec page1 = tabHost.newTabSpec("tab1")
                .setIndicator("", res.getDrawable(R.drawable.state1))
                .setContent(new Intent(this, HomeActivity.class));
        tabHost.addTab(page1);

        TabHost.TabSpec page2 = tabHost.newTabSpec("tab2")
                .setIndicator("", res.getDrawable(R.drawable.state2))
                .setContent(new Intent(this, FavorableActivity.class));
        tabHost.addTab(page2);

        TabHost.TabSpec page3 = tabHost.newTabSpec("tab3")
                .setIndicator("", res.getDrawable(R.drawable.state3))
                .setContent(new Intent(this, NearbyActivity.class));
        tabHost.addTab(page3);

        TabHost.TabSpec page4 = tabHost.newTabSpec("tab4")
                .setIndicator("", res.getDrawable(R.drawable.state4))
                .setContent(new Intent(this, LoginActivity.class));
        tabHost.addTab(page4);

        TabHost.TabSpec page5 = tabHost.newTabSpec("tab5")
                .setIndicator("", res.getDrawable(R.drawable.state5))
                .setContent(new Intent(this, MoreInfoActivity.class));
        tabHost.addTab(page5);

        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            TextView textView = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            textView.setTextSize(14);
            textView.setPadding(0, 0, 0, 0);
            ImageView image = (ImageView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.icon);
            image.getLayoutParams().height = 100;//通过给它的属性赋值的方法可以解决问题
            image.getLayoutParams().width = 100;
        }
    }
}

