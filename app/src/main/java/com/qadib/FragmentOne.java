package com.qadib;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qadib.fragmentmanager.R;
import com.qadib.qdfragmentmanager.Base.QDFragment;

/**
 * Created by ahmadraza on 29/07/15.
 */
public class FragmentOne extends QDFragment implements View.OnClickListener {

    public static FragmentOne newInstance() {
        FragmentOne fragment = new FragmentOne();
        return fragment;
    }

    public FragmentOne() {
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
        view.setBackgroundResource(R.color.yellow);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getContainerFragment().setCurrentFragment(this);

        notifyActivity(FragmentOne.class.getSimpleName());

        ((TextView) view.findViewById(R.id.textView)).setText("Fragment One");

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
        }
    }
}
