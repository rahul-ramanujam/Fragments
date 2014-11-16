package com.elsevier.cs.msg.fragmentsexample.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.ViewGroup;

import com.elsevier.cs.msg.fragmentsexample.R;
import com.elsevier.cs.msg.fragmentsexample.fragments.BaseFragment;
import com.elsevier.cs.msg.fragmentsexample.fragments.FragmentA;
import com.elsevier.cs.msg.fragmentsexample.interfaces.FragmentChangeListener;

/**
 * Created by vijayr on 11/14/14.
 */
public class HomeActivity extends  BaseActivity implements FragmentChangeListener{

    ViewGroup mFragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout_activity);
        mFragmentContainer = (ViewGroup)findViewById(R.id.fragment_container);

        if(mFragmentContainer!=null)
        {
            if(savedInstanceState!=null){
                return;
            }

            FragmentA fragmentA = new FragmentA();

            getFragmentManager().beginTransaction().add(R.id.fragment_container,fragmentA).commit();

        }

        getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if(getFragmentManager().getBackStackEntryCount()>0)
                {
                    getActionBar().setHomeButtonEnabled(true);
                    getActionBar().setDisplayHomeAsUpEnabled(true);
                }
                else{
                    getActionBar().setHomeButtonEnabled(false);
                    getActionBar().setDisplayHomeAsUpEnabled(false);
                }
            }
        });
    }

    @Override
    public boolean onNavigateUp() {
        getFragmentManager().popBackStack();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void replaceFragment(BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.slide_right_in,R.animator.slide_right_out,
                R.animator.slide_left_in,R.animator.slide_left_out);
        fragmentTransaction.replace(R.id.fragment_container,fragment,fragment.toString());
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();
    }


}
