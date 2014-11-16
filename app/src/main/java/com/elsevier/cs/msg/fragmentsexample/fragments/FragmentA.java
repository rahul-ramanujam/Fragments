package com.elsevier.cs.msg.fragmentsexample.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.elsevier.cs.msg.fragmentsexample.R;
import com.elsevier.cs.msg.fragmentsexample.interfaces.FragmentChangeListener;

public class FragmentA extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmen1_layout_fragment,container,false);

        Button button = (Button) view.findViewById(R.id.showFragB);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentChangeListener fragmentChangeListener = (FragmentChangeListener) getActivity();
                fragmentChangeListener.replaceFragment(new FragmentB());
            }
        });
        return view;
    }
}
