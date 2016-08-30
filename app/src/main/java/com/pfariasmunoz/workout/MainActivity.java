package com.pfariasmunoz.workout;

import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentTransaction;

public class MainActivity extends Activity
                          implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        // the code to set the detail
        WorkoutDetailFragment details = new WorkoutDetailFragment();
        // start the fragment transaction
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        details.setWorkout(id);
        // replace the fragment and add it to the back stack
        ft.replace(R.id.fragment_container, details);
        // add it to the back stack
        ft.addToBackStack(null);
        // get the new and old fragments to face in and out
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // commit the transaction
        ft.commit();
    }
}
