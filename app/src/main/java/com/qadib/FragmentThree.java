package com.qadib;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qadib.fragmentmanager.R;
import com.qadib.qdfragmentmanager.Base.BaseFragment;

/**
 * Created by ahmadraza on 29/07/15.
 */
public class FragmentThree extends BaseFragment implements View.OnClickListener {

    public static FragmentThree newInstance() {
        FragmentThree fragment = new FragmentThree();
        return fragment;
    }

    public FragmentThree() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_fragment_blank, container, false);
        view.setBackgroundResource(R.color.blue);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getContainerFragment().setCurrentFragment(this);

        notifyActivity(FragmentThree.class.getSimpleName());
        ((TextView) view.findViewById(R.id.textView)).setText("Fragment Three");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

        }
    }
}
