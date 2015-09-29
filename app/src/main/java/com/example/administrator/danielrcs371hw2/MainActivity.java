package com.example.administrator.danielrcs371hw2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static com.example.administrator.danielrcs371hw2.R.mipmap.player1;

/*
*Author: Daniel Rothschilds
* Last Edit: September 28th
* ALL IMAGES ARE COURTESY OF ICONFINDER
 */

public class MainActivity extends ActionBarActivity {


    public static TeamRosterDatabase TeamData;
    public ImageButton[] playerButtons;

    //public PlayerStats playerShown;
    public static TeamRoster team;
    //public LinkedHashMap<TeamRoster, Button> mainTeamButtons;
    HashMap<ImageButton, String> PlayerImages;
    //public static String newTeam;
    public static ImageView teamImage;
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlayerImages = new HashMap<ImageButton, String>();

        //Because onCreate is called everytime we return to the main activity,
        //only create a new Team roster the first time the program is loaded
        if(TeamData==null) {

            TeamData = new TeamRosterDatabase(this);
            TeamData.declareTeams();
        }
        //Instantiate an array of buttons to display the teams
        Button[] teamList = new Button[15];
        teamList[0] = (Button)this.findViewById(R.id.team1);
        teamList[1] = (Button)this.findViewById(R.id.team2);
        teamList[2] = (Button)this.findViewById(R.id.team3);
        teamList[3] = (Button)this.findViewById(R.id.team4);
        teamList[4] = (Button)this.findViewById(R.id.team5);
        teamList[5] = (Button)this.findViewById(R.id.team6);
        teamList[6] = (Button)this.findViewById(R.id.team7);
        teamList[7] = (Button)this.findViewById(R.id.team8);
        teamList[8] = (Button)this.findViewById(R.id.team9);
        teamList[9] = (Button)this.findViewById(R.id.team10);
        teamList[10] = (Button)this.findViewById(R.id.team11);
        teamList[11] = (Button)this.findViewById(R.id.team12);
        teamList[12] = (Button)this.findViewById(R.id.team13);
        teamList[13] = (Button)this.findViewById(R.id.team14);
        teamList[14] = (Button)this.findViewById(R.id.team15);

        //viewTeams has to be called to refresh the current activity that is being worked on
        TeamData.viewTeams(this, teamList);
        //instantiate the ImageButtons for the players
        playerButtons = new ImageButton[15];
        playerButtons[0] = (ImageButton)this.findViewById(R.id.player1);
        playerButtons[1] = (ImageButton)this.findViewById(R.id.player2);
        playerButtons[2] = (ImageButton)this.findViewById(R.id.player3);
        playerButtons[3] = (ImageButton)this.findViewById(R.id.player4);
        playerButtons[4] = (ImageButton)this.findViewById(R.id.player5);
        playerButtons[5] = (ImageButton)this.findViewById(R.id.player6);
        playerButtons[6] = (ImageButton)this.findViewById(R.id.player7);
        playerButtons[7] = (ImageButton)this.findViewById(R.id.player8);
        playerButtons[8] = (ImageButton)this.findViewById(R.id.player9);
        playerButtons[9] = (ImageButton)this.findViewById(R.id.player10);
        playerButtons[10] = (ImageButton)this.findViewById(R.id.player11);
        playerButtons[11] = (ImageButton)this.findViewById(R.id.player12);
        playerButtons[12] = (ImageButton)this.findViewById(R.id.player13);
        playerButtons[13] = (ImageButton)this.findViewById(R.id.player14);
        playerButtons[14] = (ImageButton)this.findViewById(R.id.player15);
        for(int i = 0; i<15; i++)
            playerButtons[i].setVisibility(View.INVISIBLE);

        //set the Team ImageView
        teamImage = (ImageView)this.findViewById(R.id.teamImage);







    }
    //Purpose: Switch to the SecondActivity, to create a team
    public void createTeam(View view)
    {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }
    //Purpose: Switch to the activity where you can delete players
    public void deletePlayer(View view)
    {
        Intent intent = new Intent(this, DeletePlayer.class);
        startActivity(intent);
        finish();
    }
    //switch to the activity where you can create a player
    public void switchAndCreate(View view)
    {
        Intent intent = new Intent(this, EditTeam.class);
        startActivity(intent);
        finish();
    }
    //switch to the activity where you can pick teams
    public void startGame(View view)
    {
        Intent intent = new Intent(this, PickTeams.class);
        startActivity(intent);
        finish();
    }
    //switch to the activity where you can delete teams
    public void deleteTeam(View view)
    {
        Intent intent = new Intent(this, DeleteTeam.class);
        startActivity(intent);
        finish();

    }


    //get the list of players
    public void sendButtonID(View view)
    {
        //set the background image of the team
        team = TeamData.getTeamRoster((Button)view);
        teamImage.setBackgroundResource(team.resource);
        //if the team is null dont try to call methods on it
        if(team==null)
            return;

        team.showPlayers(playerButtons);
    }
    //View the stats of the player that was clicked
    public void viewStats(View view)
    {

        //pass in an array of text fields to be set
        //playerShown = TeamData.returnPlayer(view);
        String playerName = "";
        PlayerStats player = new PlayerStats();
        //to be able to map the image to the player in the list, create a hashmap
        PlayerImages = TeamData.createPlayerMap(PlayerImages, playerButtons, team);
        //if the image = one of the elements in the map just created

        for(ImageButton image: PlayerImages.keySet())
        {
            if((view) == (image))
            {

                playerName = PlayerImages.get(image);

            }
        }
        //find the player name within the list of teams
        for(String key: team.teamPlayers.keySet())
        {


            if(team.teamPlayers.get(key).fullName.equals(playerName))
            {

                player = team.teamPlayers.get(key);
            }

        }
        //instantiate the list of TextViews
        TextView[] textBoxes = new TextView[6];
        textBoxes[0]= (TextView) this.findViewById(R.id.stats1);
        textBoxes[1]= (TextView) this.findViewById(R.id.stats2);
        textBoxes[2]= (TextView) this.findViewById(R.id.stats3);
        textBoxes[3]= (TextView) this.findViewById(R.id.stats4);
        textBoxes[4]= (TextView) this.findViewById(R.id.stats5);
        textBoxes[5]= (TextView) this.findViewById(R.id.stats6);
        //Set the text of the TextViews
        textBoxes[0].setText("Goals Scored: " + player.goalsScored);
        textBoxes[1].setText("Strength: " + player.strengthFactor);
        textBoxes[2].setText("Games Won: " + player.gamesWon);
        textBoxes[3].setText("First Name: " + player.firstName);
        textBoxes[4].setText("Last Name: " + player.lastName);
        textBoxes[5].setText("Team Name: " + player.team);







    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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