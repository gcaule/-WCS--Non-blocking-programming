package com.example.apprenti.liftsimulator;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isLiftMoving = false;
    private int currentFloor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button buttonFloor0 = (Button) findViewById(R.id.floor0);
        Button buttonFloor1 = (Button) findViewById(R.id.floor1);
        Button buttonFloor2 = (Button) findViewById(R.id.floor2);
        Button buttonFloor3 = (Button) findViewById(R.id.floor3);
        Button buttonFloor4 = (Button) findViewById(R.id.floor4);
        Button buttonFloor5 = (Button) findViewById(R.id.floor5);
        Button buttonFloor6 = (Button) findViewById(R.id.floor6);
        Button buttonFloor7 = (Button) findViewById(R.id.floor7);
        Button buttonFloor8 = (Button) findViewById(R.id.floor8);
        Button buttonFloor9 = (Button) findViewById(R.id.floor9);

        buttonFloor0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    goToFloor(0);
            }
        });

        buttonFloor1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    goToFloor(1);
            }
        });

        buttonFloor2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    goToFloor(2);
            }
        });

        buttonFloor3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    goToFloor(3);

            }
        });

        buttonFloor4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    goToFloor(4);

            }
        });

        buttonFloor5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    goToFloor(5);

            }
        });

        buttonFloor6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    goToFloor(6);

            }
        });

        buttonFloor7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    goToFloor(7);

            }
        });

        buttonFloor8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    goToFloor(8);

            }
        });

        buttonFloor9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    goToFloor(9);

            }
        });
    }

    private void goToFloor(int floor) {
        if (!isLiftMoving && floor != currentFloor) {
            moveNextFloor(floor);
            isLiftMoving = false;
        }
    }

    private void moveNextFloor(int floor) {
        if (floor != currentFloor) {
            isLiftMoving = true;
            new MoveLift().execute(floor);

        }
    }

    private class MoveLift extends AsyncTask<Integer,Void,Void> {
        private Integer floor;

        @Override
        protected Void doInBackground(Integer... integers) {
            floor = integers[0];
            SystemClock.sleep(3000);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            currentFloor = (floor > currentFloor) ? currentFloor + 1 : currentFloor - 1;
            TextView floorCount = (TextView) findViewById(R.id.floor_count);
            floorCount.setText(String.valueOf(currentFloor));
            isLiftMoving = false;
            moveNextFloor(floor);
        }

    }
}