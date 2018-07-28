

package com.example.farhan.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*Team A methods Start*/

    /**
     * Button addOne in Team A
     **/
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Button addTwo in Team A
     **/
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Button addThree in Team A
     **/
    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }
    /*Team A methods End*/


    /*Team B methods Start*/

    /**
     * Button addOne in Team B
     **/
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Button addTwo in Team B
     **/
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Button addThree in Team B
     **/
    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }
     /*Team B methods End*/

    public void showResults(View v) {

        if (scoreTeamA > scoreTeamB) {
            Toast.makeText(this, "The Winner Is Team A", Toast.LENGTH_SHORT).show();
        } else if (scoreTeamB > scoreTeamA) {
            Toast.makeText(this, "The Winner Is Team B", Toast.LENGTH_SHORT).show();
        } else if (scoreTeamA == scoreTeamB) {
            Toast.makeText(this, "Draw...!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Button That Reset the scroe of both team A and B.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

}