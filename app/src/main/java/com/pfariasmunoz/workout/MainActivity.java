package com.pfariasmunoz.workout;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WorkoutDetailFragment frag = (WorkoutDetailFragment)getFragmentManager().findFragmentById(R.id.detail_frag);
        // This is a setter method for the workout ID
        // The activity will use this method to set the value of the workout ID.
        // This is to get WorkoutDetailFragment to display detail of workout hereto check it's working
        frag.setWorkout(1);
    }
}
