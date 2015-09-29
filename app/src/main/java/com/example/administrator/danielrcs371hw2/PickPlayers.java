package com.example.administrator.danielrcs371hw2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

/*
*Author: Daniel Rothschilds
* Last Edit: Septemeber 29th
 */
public class PickPlayers extends ActionBarActivity {
    //Declare instance variables
    /*
    *- Two TeamRosters for the game
    *- Two counters to limit the selection of players
    *- Two button Arrays to show the players
    *- Two text view arrays to show the players that were chosen
     */

    public static TeamRoster TeamRoster1;
    public static TeamRoster TeamRoster2;
    public int counter1;
    public int counter2;
    public Button[] team1B;
    public Button[] team2B;
    public TextView[] team1Players;
    public TextView[] team2Players;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_players);

        TeamRoster1 = new TeamRoster(PickTeams.teamsToPlayGame[0].teamName, PickTeams.teamsToPlayGame[0].resource);
        TeamRoster2 = new TeamRoster(PickTeams.teamsToPlayGame[1].teamName, PickTeams.teamsToPlayGame[1].resource);

        team1B = new Button[15];
        team2B = new Button[15];
        team1B[0] = (Button)this.findViewById(R.id.t1p1);
        team1B[1] = (Button)this.findViewById(R.id.t1p2);
        team1B[2] = (Button)this.findViewById(R.id.t1p3);
        team1B[3] = (Button)this.findViewById(R.id.t1p4);
        team1B[4] = (Button)this.findViewById(R.id.t1p5);
        team1B[5] = (Button)this.findViewById(R.id.t1p6);
        team1B[6] = (Button)this.findViewById(R.id.t1p7);
        team1B[7] = (Button)this.findViewById(R.id.t1p8);
        team1B[8] = (Button)this.findViewById(R.id.t1p9);
        team1B[9] = (Button)this.findViewById(R.id.t1p10);
        team1B[10] = (Button)this.findViewById(R.id.t1p11);
        team1B[11] = (Button)this.findViewById(R.id.t1p12);
        team1B[12] = (Button)this.findViewById(R.id.t1p13);
        team1B[13] = (Button)this.findViewById(R.id.t1p14);
        team1B[14] = (Button)this.findViewById(R.id.t1p15);

        team2B[0] = (Button)this.findViewById(R.id.t2p1);
        team2B[1] = (Button)this.findViewById(R.id.t2p2);
        team2B[2] = (Button)this.findViewById(R.id.t2p3);
        team2B[3] = (Button)this.findViewById(R.id.t2p4);
        team2B[4] = (Button)this.findViewById(R.id.t2p5);
        team2B[5] = (Button)this.findViewById(R.id.t2p6);
        team2B[6] = (Button)this.findViewById(R.id.t2p7);
        team2B[7] = (Button)this.findViewById(R.id.t2p8);
        team2B[8] = (Button)this.findViewById(R.id.t2p9);
        team2B[9] = (Button)this.findViewById(R.id.t2p10);
        team2B[10] = (Button)this.findViewById(R.id.t2p11);
        team2B[11] = (Button)this.findViewById(R.id.t2p12);
        team2B[12] = (Button)this.findViewById(R.id.t2p13);
        team2B[13] = (Button)this.findViewById(R.id.t2p14);
        team2B[14] = (Button)this.findViewById(R.id.t2p15);
        for(int i = 0; i<15; i++) {
            team1B[i].setVisibility(View.INVISIBLE);
            team2B[i].setVisibility(View.INVISIBLE);
        }
        //These two arrays are the 5 players that will be played on the field
        team1Players = new TextView[6];
        team2Players = new TextView[6];

        team1Players[0] = (TextView)this.findViewById(R.id.Player1);
        team1Players[1] = (TextView)this.findViewById(R.id.Player2);
        team1Players[2] = (TextView)this.findViewById(R.id.Player3);
        team1Players[3] = (TextView)this.findViewById(R.id.Player4);
        team1Players[4] = (TextView)this.findViewById(R.id.Player5);
        team1Players[5] = (TextView)this.findViewById(R.id.Player6);

        team2Players[0] = (TextView)this.findViewById(R.id.LPlayer1);
        team2Players[1] = (TextView)this.findViewById(R.id.LPlayer2);
        team2Players[2] = (TextView)this.findViewById(R.id.LPlayer3);
        team2Players[3] = (TextView)this.findViewById(R.id.LPlayer4);
        team2Players[4] = (TextView)this.findViewById(R.id.LPlayer5);
        team2Players[5] = (TextView)this.findViewById(R.id.LPlayer6);

        team1Players[0].setText(PickTeams.teamsToPlayGame[0].getTeamName());
        team2Players[0].setText(PickTeams.teamsToPlayGame[1].getTeamName());

        counter1 = 0;
        counter2 = 0;
        //Show the players on the screen
        PickTeams.teamsToPlayGame[0].showPlayers(team1B);
        PickTeams.teamsToPlayGame[1].showPlayers(team2B);


    }

    //Purpose: to add a player to team1
    public void team1(View view)
    {


        Button playerButton = (Button) view;
        //Find the player by the name of the player, and put him into roster 1
        for (String key : PickTeams.teamsToPlayGame[0].teamPlayers.keySet())
        {
            if (key.equals(playerButton.getText().toString()))
            {
                if (!(TeamRoster1.teamPlayers.containsKey(key))&&TeamRoster1.teamPlayers.size()<5)
                {
                    TeamRoster1.teamPlayers.put(key, PickTeams.teamsToPlayGame[0].teamPlayers.get(key));
                    team1Players[counter1+1].setText(key);
                    counter1++;
                }

            }
        }
    }

    public void repick(View view)
    {
        Intent intent = new Intent(this, PickPlayers.class);
        startActivity(intent);
        finish();
    }


    //Purpose: Add a player that is clicked to team two, same implementation as team1
    public void team2(View view)
    {
        PlayerStats player = new PlayerStats();
        Button playerButton = (Button)view;
        for(String key: PickTeams.teamsToPlayGame[1].teamPlayers.keySet())
        {
            if(key.equals(playerButton.getText().toString()))
            {
                if (!(TeamRoster2.teamPlayers.containsKey(key))&&TeamRoster2.teamPlayers.size()<5)
                {
                    TeamRoster2.teamPlayers.put(key, PickTeams.teamsToPlayGame[1].teamPlayers.get(key));
                    team2Players[counter2+1].setText(key);
                    counter2++;
                }

            }
        }

    }

    //Start the game with the 5 players for each team selected
    public void startGameWithPlayers(View view)
    {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
        finish();
    }
    //Repick the teams
    public void pickNewTeams(View view)
    {
        Intent intent = new Intent(this, PickTeams.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pick_players, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
