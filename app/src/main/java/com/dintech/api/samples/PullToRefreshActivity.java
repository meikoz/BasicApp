package com.dintech.api.samples;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dintech.api.scorpius.LoadView;
import com.dintech.api.scorpius.ScorpiusView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PullToRefreshActivity extends AppCompatActivity {

    public static final int REFRESH_DELAY = 10000;

    private ScorpiusView mPullToRefreshView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh);

//        Indicator indicator = new LineScalePulseOutIndicator(this);
//        ImageView viewById = findViewById(R.id.iv_animal);
//        viewById.setBackground(indicator);
//        indicator.start();

        LoadView viewById = findViewById(R.id.load_view);
        viewById.start();

        Map<String, Integer> map;
        List<Map<String, Integer>> sampleList = new ArrayList<>();


        int[] colors = {
                R.color.saffron,
                R.color.eggplant,
                R.color.sienna};

        int[] tripNames = {
                R.string.trip_to_india,
                R.string.trip_to_italy,
                R.string.trip_to_indonesia};

        for (int i = 0; i < tripNames.length; i++) {
            map = new HashMap<>();
            map.put(SampleAdapter.KEY_NAME, tripNames[i]);
            map.put(SampleAdapter.KEY_COLOR, colors[i]);
            sampleList.add(map);
        }

//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(new SampleAdapter(this, R.layout.list_item, sampleList));

//        mPullToRefreshView = (ScorpiusView) findViewById(R.id.pull_to_refresh);
//        mPullToRefreshView.setScorpiusText("感谢来到灯影科技");
//        mPullToRefreshView.setOnRefreshListener(new ScorpiusView.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                mPullToRefreshView.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        mPullToRefreshView.setRefreshing(false);
//                    }
//                }, REFRESH_DELAY);
//            }
//        });
    }

    class SampleAdapter extends ArrayAdapter<Map<String, Integer>> {

        public static final String KEY_NAME = "name";
        public static final String KEY_COLOR = "color";

        private final LayoutInflater mInflater;
        private final List<Map<String, Integer>> mData;

        public SampleAdapter(Context context, int layoutResourceId, List<Map<String, Integer>> data) {
            super(context, layoutResourceId, data);
            mData = data;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
            final ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.list_item, parent, false);
                viewHolder.textViewName = (TextView) convertView.findViewById(R.id.text_view_name);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.textViewName.setText(mData.get(position).get(KEY_NAME));
            convertView.setBackgroundResource(mData.get(position).get(KEY_COLOR));

            return convertView;
        }

        class ViewHolder {
            TextView textViewName;
        }

    }

}