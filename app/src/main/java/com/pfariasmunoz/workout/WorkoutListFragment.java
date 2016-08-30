package com.pfariasmunoz.workout;

import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WorkoutListFragment extends ListFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // calling the superclass onCreateView() method give the default layout for the ListFragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
