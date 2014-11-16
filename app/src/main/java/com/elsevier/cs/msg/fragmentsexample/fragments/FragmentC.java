package com.elsevier.cs.msg.fragmentsexample.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elsevier.cs.msg.fragmentsexample.R;


public class FragmentC extends BaseFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment3_layout_fragment,container,false);

        return view;
    }
}