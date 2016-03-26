package com.qadib.qdfragmentmanager.Tab;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

public class DummyTabFactory implements TabHost.TabContentFactory {
    private final Context mContext;

    public DummyTabFactory(final Context context) {
        mContext = context;
    }

    @Override
    public View createTabContent(final String tag) {
        View v = new View(mContext);
        v.setMinimumWidth(0);
        v.setMinimumHeight(0);
        return v;
    }
}
