package com.qadib.qdfragmentmanager.Base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.qadib.qdfragmentmanager.R;


/**
 * Created by ahmadraza on 29/07/15.
 */
public abstract class BaseContainerFragment extends Fragment {

    private BaseFragment currentFragment;

    public void replaceFragment(BaseFragment fragment, boolean addToBackStack) {
        fragment.setContainerFragment(this);

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(fragment.getTag());
        }

        transaction.replace(R.id.container_framelayout, fragment, fragment.getTag());
        transaction.commit();
        getChildFragmentManager().executePendingTransactions();
    }

    public boolean popFragment() {
        boolean isPop = false;
        if (getChildFragmentManager().getBackStackEntryCount() > 0) {
            isPop = true;
            getChildFragmentManager().popBackStack();
        }
        return isPop;
    }

    public BaseFragment getCurrentFragment() {
        return currentFragment;
    }

    public void setCurrentFragment(BaseFragment fragment) {
        currentFragment = fragment;
    }
}