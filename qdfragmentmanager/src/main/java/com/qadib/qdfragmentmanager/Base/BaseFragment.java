package com.qadib.qdfragmentmanager.Base;

import android.support.v4.app.Fragment;

import com.qadib.qdfragmentmanager.FragmentHolder;

;

/**
 * Created by ahmadraza on 29/07/15.
 */
public abstract class BaseFragment extends Fragment {

    private BaseContainerFragment containerFragment;

    public void setContainerFragment(BaseContainerFragment containerFragment) {
        this.containerFragment = containerFragment;
    }

    public BaseContainerFragment getContainerFragment() {
        return this.containerFragment;
    }

    protected void replaceFragment(BaseFragment fragment) {
        replaceFragment(fragment, true);
    }

    protected void replaceFragment(BaseFragment fragment, boolean addToBackStack) {
        containerFragment.replaceFragment(fragment, addToBackStack);
    }

    public void notifyActivity(String name) {
        ((FragmentHolder) getActivity()).fragmentPopulated(name);
    }

}