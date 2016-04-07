package com.ut.mis49m.fragmentlab;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

}
