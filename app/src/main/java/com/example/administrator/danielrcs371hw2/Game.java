package com.example.administrator.danielrcs371hw2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Game extends ActionBarActivity {

    public static TeamRoster winTeam;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ImageButton[] currentPlayersRight = new ImageButton[5];
        ImageButton[] currentPlayersLeft = new ImageButton[5];
        winTeam = new TeamRoster();
        //initialize first array of buttons
        currentPlayersLeft[0] = (ImageButton)this.findViewById(R.id.LP1);
        currentPlayersLeft[1] = (ImageButton)this.findViewById(R.id.LP2);
        currentPlayersLeft[2] = (ImageButton)this.findViewById(R.id.LP3);
        currentPlayersLeft[3] = (ImageButton)this.findViewById(R.id.LP4);
        currentPlayersLeft[4] = (ImageButton)this.findViewById(R.id.LP5);

        currentPlayersRight[0] = (ImageButton)this.findViewById(R.id.RP1);
        currentPlayersRight[1] = (ImageButton)this.findViewById(R.id.RP2);
        currentPlayersRight[2] = (ImageButton)this.findViewById(R.id.RP3);
        currentPlayersRight[3] = (ImageButton)this.findViewById(R.id.RP4);
        currentPlayersRight[4] = (ImageButton)this.findViewById(R.id.RP5);


        PickPlayers.TeamRoster1.showPlayers(currentPlayersRight);
        PickPlayers.TeamRoster2.showPlayers(currentPlayersLeft);

        Button team1 = (Button)this.findViewById(R.id.Team1);
        Button team2 = (Button)this.findViewById(R.id.Team2);

        team1.setText(PickPlayers.TeamRoster1.getTeamName());
        team2.setText(PickPlayers.TeamRoster2.getTeamName());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    public void returnToPick(View view)
    {
        Intent intent = new Intent(this, PickTeams.class);
        startActivity(intent);
        finish();
    }
    //This method will determine who should be the winner based on who has more total strength on their team currently playing!
    public void playGame(View view)
    {
        //Add up strength for team 1
        int strTeamOne = 0;
        int strTeamTwo = 0;
        for(String key: PickPlayers.TeamRoster1.teamPlayers.keySet())
        {
            strTeamOne+=PickTeams.teamsToPlayGame[0].teamPlayers.get(key).strengthFactor;
        }
        for(String key: PickPlayers.TeamRoster2.teamPlayers.keySet())
        {
            strTeamTwo+=PickTeams.teamsToPlayGame[1].teamPlayers.get(key).strengthFactor;
        }

        if(strTeamOne==strTeamTwo){
            if(PickTeams.teamsToPlayGame[0].teamPlayers.size()>PickTeams.teamsToPlayGame[1].teamPlayers.size())
            {
                PickTeams.teamsToPlayGame[0].incrementWins();
                winTeam=PickTeams.teamsToPlayGame[0];
                PickTeams.teamsToPlayGame[0].incrementGoals();


            }
            else {
                PickTeams.teamsToPlayGame[1].incrementWins();
                winTeam=PickTeams.teamsToPlayGame[1];
                PickTeams.teamsToPlayGame[1].incrementGoals();
            }
        }

        if(strTeamOne>strTeamTwo) {
            PickTeams.teamsToPlayGame[0].incrementWins();
            winTeam=PickTeams.teamsToPlayGame[0];
            PickTeams.teamsToPlayGame[0].incrementGoals();
        }

        else {
            PickTeams.teamsToPlayGame[1].incrementWins();
            winTeam=PickTeams.teamsToPlayGame[1];
            PickTeams.teamsToPlayGame[1].incrementGoals();
        }


        Intent intent = new Intent(this, WINNINGPAGE.class);
        startActivity(intent);
        finish();
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
