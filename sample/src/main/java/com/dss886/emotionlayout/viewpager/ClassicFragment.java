package com.dss886.emotionlayout.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.dss886.emotionlayout.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dss886 on 15/9/22.
 */
public class ClassicFragment extends Fragment {

    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emotion_gird_classic, container, false);
        BaseAdapter adapter = new ClassicEmojiAdapter(mContext);
        GridView grid = (GridView) view.findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(GlobalOnItemClickManager.getInstance().getOnItemClickListener(0));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private class ClassicEmojiAdapter extends BaseAdapter {

        private Context mContext;

        public ClassicEmojiAdapter(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return 73;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.emotion_gird_item_classic, parent, false);
                holder = new ViewHolder();
                holder.image = (ImageView) convertView.findViewById(R.id.image);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            String path = "file:///android_asset/ems/em" + (position + 1) + ".gif";
            Picasso.with(mContext).load(path).into(holder.image);
            return convertView;
        }

        private class ViewHolder {
            public ImageView image;
        }
    }
}
