package com.qadib.qdfragmentmanager;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.qadib.qdfragmentmanager.Base.BaseContainerFragment;
import com.qadib.qdfragmentmanager.Tab.DummyTabFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmadraza on 28/07/15.
 */
public abstract class QDActivity extends AppCompatActivity {

    private static int TAB_LAYOUT_ID = -1;
    public static List<Class<?>> values = new ArrayList<Class<?>>();
    private int _TAB_CLICKED;
    protected FragmentTabHost mTabHost;
    protected final int containerID = android.R.id.tabcontent;
    private BaseContainerFragment currentContainer;
    public final static String KEY_TAB_POSITION = "tabPosition";

    public enum POSITION {TOP, BOTTOM}

    ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int pos = -1;
        if (savedInstanceState != null) {
            pos = savedInstanceState.getInt(KEY_TAB_POSITION, POSITION.BOTTOM.ordinal());
        }

        if (pos == POSITION.BOTTOM.ordinal()) {
            setContentView(R.layout.activity_home_bottom);
            setupTabHost();
        } else if(pos == POSITION.TOP.ordinal()) {
            setContentView(R.layout.activity_home_top);
            setupTabHost();
        }

    }

    public void setupTabHost() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), containerID);
        mTabHost.setOnTabChangedListener(new TabChangeListener());
    }

    public void setTabLayout(int layoutId) {
        QDActivity.TAB_LAYOUT_ID = layoutId;
    }

    public void addTab(String name, Class<?> fragment) {
        View tabIndicator1 = LayoutInflater.from(this).inflate(TAB_LAYOUT_ID == -1 ? R.layout.tab_text : TAB_LAYOUT_ID,
                mTabHost.getTabWidget(), false);
        ((TextView) tabIndicator1.findViewById(R.id.textView)).setText(name);

        int length = values.size() + 1;
        mTabHost.addTab(
                mTabHost.newTabSpec(Integer.toString(length))
                        .setContent(new DummyTabFactory(this))
                        .setIndicator(tabIndicator1),
                ContainerFragment.class, null);
        values.add(fragment);
    }

    public void addTab(String name, int drawableId, Class<?> fragment) {
        View tabIndicator1 = LayoutInflater.from(this).inflate(TAB_LAYOUT_ID == -1 ? R.layout.tab_text : TAB_LAYOUT_ID,
                mTabHost.getTabWidget(), false);
        ((ImageView) tabIndicator1.findViewById(R.id.imageView)).setImageResource(drawableId);
        ((TextView) tabIndicator1.findViewById(R.id.textView)).setText(name);

        int length = values.size() + 1;
        mTabHost.addTab(
                mTabHost.newTabSpec(Integer.toString(length))
                        .setContent(new DummyTabFactory(this))
                        .setIndicator(tabIndicator1),
                ContainerFragment.class, null);
        values.add(fragment);
    }

    public void setCurrentContainerFragment(BaseContainerFragment containerFragment) {
        this.currentContainer = containerFragment;
    }

    @Override
    public void onBackPressed() {
        if (!currentContainer.popFragment()) {
            if (mTabHost.getCurrentTab() > 0) {
                mTabHost.setCurrentTab(0);
            } else {
                finish();
            }
        }
    }

    public abstract void fragmentPopulated(String fragment);

    private class TabChangeListener implements TabHost.OnTabChangeListener {

        @Override
        public void onTabChanged(String s) {
            _TAB_CLICKED = Integer.valueOf(s);
        }
    }

    public int getTabClicked() {
        return _TAB_CLICKED;
    }
}
