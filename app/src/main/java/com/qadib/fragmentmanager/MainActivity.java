package com.qadib.fragmentmanager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.qadib.FragmentFour;
import com.qadib.FragmentOne;
import com.qadib.FragmentThree;
import com.qadib.FragmentTwo;
import com.qadib.qdfragmentmanager.QDActivity;


public class MainActivity extends QDActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            savedInstanceState = new Bundle();
        }
        savedInstanceState.putInt(KEY_TAB_POSITION, POSITION.BOTTOM.ordinal());

        super.onCreate(savedInstanceState);

        addTab("One", FragmentOne.class);
        addTab("Two", FragmentTwo.class);
        addTab("Three", FragmentThree.class);
        addTab("Four", FragmentFour.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void fragmentPopulated(String fragment) {
        Log.e("Fragment Populated", fragment);
    }
}
