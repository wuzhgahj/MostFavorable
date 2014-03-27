package com.wzg.MostFavorable.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import com.wzg.MostFavorable.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wzg on 14-3-26.
 */
public class NearbyActivity extends Activity {
    Spinner aroundSpinner = null;
    Spinner typeSpinner = null;
    private ArrayList aroundData;
    private ArrayList typeData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.nearby);
        aroundSpinner = (Spinner) findViewById(R.id.aroundSpinner);
        typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        initData();

        SimpleAdapter adapter = new SimpleAdapter(this, aroundData,R.layout.around, new String[]{"distance"},
                new int[]{R.id.leftTextView});

        aroundSpinner.setAdapter(adapter);
        adapter.setDropDownViewResource(R.layout.down);

        adapter = new SimpleAdapter(this, typeData,R.layout.type, new String[]{"distance"},
                new int[]{R.id.leftTextView});

        typeSpinner.setAdapter(adapter);
        adapter.setDropDownViewResource(R.layout.down);
    }
    private void initData() {
        aroundData = new ArrayList();
        HashMap item = new HashMap();
        item.put("distance", "1000米");
        aroundData.add(item);

        item = new HashMap();
        item.put("distance", "3000米");
        aroundData.add(item);

        item = new HashMap();
        item.put("distance", "5000米");
        aroundData.add(item);


        typeData = new ArrayList();
        item = new HashMap();
        item.put("distance", "饮食");
        typeData.add(item);

        item = new HashMap();
        item.put("distance", "服饰");
        typeData.add(item);

        item = new HashMap();
        item.put("distance", "出租车");
        typeData.add(item);
    }
}
