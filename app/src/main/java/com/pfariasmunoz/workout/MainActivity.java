package com.pfariasmunoz.workout;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity
                          implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        // We only need to run the code if the fragment layout is there
        // meaning: if the app is in a tablet (using the layout from layout-large directory)
        if (fragmentContainer != null) {
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
        } else {
            // if the frame layout isn't there, the app must be running
            // ib a device with a smaller screen. Start DetailActivity, passing
            // the ID of the workout
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }

    }
}
