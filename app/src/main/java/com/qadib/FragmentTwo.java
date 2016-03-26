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
public class FragmentTwo extends QDFragment implements View.OnClickListener {

    public static FragmentTwo newInstance() {
        FragmentTwo fragment = new FragmentTwo();
        return fragment;
    }

    public FragmentTwo() {
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
        View view = inflater.inflate(R.layout.layout_fragment, container, false);
        view.setBackgroundResource(R.color.green);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getContainerFragment().setCurrentFragment(this);
        notifyActivity(FragmentTwo.class.getSimpleName());

        view.findViewById(R.id.btnClicked).setOnClickListener(this);
        ((TextView) view.findViewById(R.id.textView)).setText("Fragment Two");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnClicked:
                replaceFragment(FragmentFour.newInstance(), true);
                break;
        }
    }
}
