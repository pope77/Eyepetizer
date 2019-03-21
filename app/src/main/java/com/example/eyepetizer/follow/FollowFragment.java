package com.example.eyepetizer.follow;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eyepetizer.R;

import butterknife.ButterKnife;

/**
 * V层
 * @author popeg
 */
public class FollowFragment extends Fragment implements FollowView {


    public FollowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        ButterKnife.bind(view);
        return view;
    }

}
