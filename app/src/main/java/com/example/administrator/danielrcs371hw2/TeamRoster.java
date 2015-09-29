package com.example.administrator.danielrcs371hw2;

import android.app.Activity;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;



/**
 * Author: Daniel Rothschilds
 * Last Edit: September 29th
 * This class represents a Team of player objects
 */
public class TeamRoster {

    protected HashMap<String, PlayerStats> teamPlayers;
    protected String teamName;
    protected ImageView teamImage;
    protected Integer resource;
    // protected HashMap<ImageButton, PlayerStats> Team;

    public TeamRoster(String teamName, Integer resource)
    {
        this.teamName=teamName;

        this.resource=resource;
        teamPlayers = new HashMap<String, PlayerStats>();

    }

    public TeamRoster(){}

    public void incrementWins()
    {
        for(String key: teamPlayers.keySet())
        {
            teamPlayers.get(key).setGamesWon(1);
        }
    }

    public void incrementGoals()
    {
        int counter = 4;
        for(String key: teamPlayers.keySet())
        {
            teamPlayers.get(key).incrementGoals(counter%2);
            counter++;

        }
    }





    //Method was never used, however it may be implemented in further versions
    public void clearPlayers(ImageButton[] buttons)
    {
        //If their are no players on the team, reset all images to blank
        if (teamPlayers.size() == 0) {
            for (int i = 0; i < 15; i++) {
                teamImage.setImageResource(R.mipmap.blankteam);
                buttons[i].setVisibility(View.INVISIBLE);

            }

        }
    }



    //Purpose: display the images for each player
    public void showPlayers(ImageButton[] buttons)
    {
        if(buttons.length==0)
            return;
        int counter = 0;
        // loop through the players in the current object and set the corresponding button background to the recourse held
        for(String key: teamPlayers.keySet())
        {
            buttons[counter].setVisibility(View.VISIBLE);
            buttons[counter].setBackground(teamPlayers.get(key).playerImage.getDrawable());
            if(counter<buttons.length)
                counter++;
        }
        //set all other buttons to a blank image
        for(int i = counter; i<buttons.length; i++)
            buttons[i].setBackgroundResource(R.mipmap.blankteam);



    }
    //Purpose: Display the players for an array of buttons rather than image buttons
    public void showPlayers(Button[] buttons)
    {
        int counter = 0;
        for(String key: teamPlayers.keySet())
        {
            buttons[counter].setVisibility(View.VISIBLE);
            buttons[counter].setText(teamPlayers.get(key).fullName);
            if(counter<buttons.length-1)
                counter++;
        }
        for(int i = counter+1; i<buttons.length-1; i++)
            buttons[i].setBackgroundResource(R.mipmap.blankteam);
    }
    //Purpose: Add a player to the current list of players
    public void addPlayer(PlayerStats player)
    {
        String key = player.fullName;

        if(teamPlayers.containsKey(key))
        {
            return;
        }

        teamPlayers.put(key, player);

    }
    //return the teamName
    public String getTeamName()
    {
        return teamName;
    }


}