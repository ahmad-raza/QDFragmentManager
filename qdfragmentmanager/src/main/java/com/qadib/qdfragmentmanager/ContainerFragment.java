package com.qadib.qdfragmentmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qadib.qdfragmentmanager.Base.BaseContainerFragment;
import com.qadib.qdfragmentmanager.Base.QDFragment;

/**
 * Created by ahmadraza on 30/07/15.
 */
public class ContainerFragment extends BaseContainerFragment {

    private boolean mIsViewInited;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((QDActivity) getActivity()).setCurrentContainerFragment(this);
        return inflater.inflate(R.layout.container_fragment, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!mIsViewInited) {
            mIsViewInited = true;
            initView();
        }
    }

    private void initView() {
        try {
            Class<QDFragment> cls = (Class<QDFragment>) QDActivity.values.get(((QDActivity) getActivity()).getTabClicked() - 1);
            QDFragment instance = cls.newInstance();
            replaceFragment(instance, false);
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
