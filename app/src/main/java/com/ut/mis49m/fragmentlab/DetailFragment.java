package com.ut.mis49m.fragmentlab;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by km10232 on 4/6/16.
 */
public class DetailFragment extends Fragment {

    TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        tv = (TextView) view.findViewById(R.id.tv);

        Bundle bundle = getArguments();
        if(bundle!=null) {
            int pos = bundle.getInt("pos");
            message(pos);
        }
        return view;
    }


    public void message(int pos){
        tv.setText(ListItem.texts[pos]);
    }

}
