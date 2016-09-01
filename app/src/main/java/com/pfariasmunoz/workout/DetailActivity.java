package com.pfariasmunoz.workout;

import android.app.Activity;
import android.os.Bundle;

public class DetailActivity extends Activity {
    // We're using a constant for the name of the extra information
    // in the intent so hat we know MainActivity and DetailActivity
    // are using the same String
    public static final String EXTRA_WORKOUT_ID = "id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WorkoutDetailFragment workoutDetailFragment = (WorkoutDetailFragment)getFragmentManager().findFragmentById(R.id.detail_frag);
        int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        workoutDetailFragment.setWorkout(workoutId);
    }
}
