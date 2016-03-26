package com.qadib.qdfragmentmanager.Base;

import android.support.v4.app.Fragment;

import com.qadib.qdfragmentmanager.QDActivity;

;

/**
 * Created by ahmadraza on 29/07/15.
 */
public abstract class QDFragment extends Fragment {

    private BaseContainerFragment containerFragment;

    public void setContainerFragment(BaseContainerFragment containerFragment) {
        this.containerFragment = containerFragment;
    }

    public BaseContainerFragment getContainerFragment() {
        return this.containerFragment;
    }

    protected void replaceFragment(QDFragment fragment) {
        replaceFragment(fragment, true);
    }

    protected void replaceFragment(QDFragment fragment, boolean addToBackStack) {
        containerFragment.replaceFragment(fragment, addToBackStack);
    }

    public void notifyActivity(String name) {
        ((QDActivity) getActivity()).fragmentPopulated(name);
    }

}