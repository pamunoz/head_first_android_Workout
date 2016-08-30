package com.pfariasmunoz.workout;

import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class WorkoutListFragment extends ListFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] names = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {
            // creates an String array of the workouts names
            names[i] = Workout.workouts[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_expandable_list_item_1,
                names);
        // bind the array adapter to the list view
        setListAdapter(adapter);

        // calling the superclass onCreateView() method give the default layout for the ListFragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
