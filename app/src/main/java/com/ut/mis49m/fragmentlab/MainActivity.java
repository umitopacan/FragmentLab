package com.ut.mis49m.fragmentlab;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.layout)!=null) {
            Fragment fragment = new ListFragment();

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.layout, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        // Load previous fragment from the stack when user clicks the back button
        if(getFragmentManager().getBackStackEntryCount()>0) {
            getFragmentManager().popBackStack();
            return;
        }

        super.onBackPressed();
    }

    @Override
    public void onItemClicked(int pos) {

        DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail);
        if(detailFragment !=null){
            detailFragment.message(pos);
        }else {

            DetailFragment fragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("pos", pos);
            fragment.setArguments(bundle);

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.layout, fragment);
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.commit();
        }
    }
}
