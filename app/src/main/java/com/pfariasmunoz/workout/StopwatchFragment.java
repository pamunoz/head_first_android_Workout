package com.pfariasmunoz.workout;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class StopwatchFragment extends Fragment implements View.OnClickListener {
    // Number of seconds dispplayed on the stopwatch.
    private int seconds = 0;// the number of seconds that have passed
    // Is the stopwatch running?
    private boolean running; // says whether the stopwatch was running
    private boolean wasRunning; // says whether the stopwatch was running
    // before the stopwatch was paused


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore the state of the variables
            // from the savedInstanceState Bundle
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
            if (wasRunning) {
                running = true;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Set the fragment's layout and start the runTimer() method passing in the layout
        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimer(layout);
        Button startButton = (Button) layout.findViewById(R.id.start_button);
        startButton.setOnClickListener(this);
        Button stopButton = (Button) layout.findViewById(R.id.stop_button);
        stopButton.setOnClickListener(this);
        Button resetButton = (Button) layout.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(this);
        return layout;
    }

    @Override
    public void onPause() {
        // If the fragment's paused,
        // record whether the stopwatch
        // was running and stop it.
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume() {
        // If the stopwatch was running before it
        // was paused, set it running again.
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Put the values of the variables in the Bundle before
        // the activity is destroyed. These are used when the
        // user turns the device
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);

    }



    public void onClickStart(View view) {
        // the code needs to run when the user
        // clicks on the Start button
        running = true;
    }

    public void onClickStop(View view) {
        // this method needs to run when the
        // user clicks on the Stop button
        running = false;
    }

    public void onClickReset(View view) {
        // this method needs to run when the
        // user clicks on the Reset button
        running = false;
        seconds = 0;
    }

    public void runTimer(View view) {
        final TextView timeView = (TextView) view.findViewById(R.id.time_view);
        // Putting the code in a Handler mean it can run in the background thread
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                // Display the number of seconds that have passed in the stopwatch
                timeView.setText(time);
                if (running) {
                    // if stopwatch is running increment the number of seconds
                    seconds++;
                }
                // run the handler code every seconds
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {     // Checks which view was clicked
            case R.id.start_button:
                onClickStart(view);
                break;
            case R.id.stop_button:
                onClickStop(view);
                break;
            case R.id.reset_button:
                onClickReset(view);
                break;
        }
    }
}
