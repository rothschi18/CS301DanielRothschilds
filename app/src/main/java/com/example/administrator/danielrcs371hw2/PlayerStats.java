package com.example.administrator.danielrcs371hw2;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Author: Daniel Rothschilds
 * Last Edit: September 29th
 * Class: PlayerStats
 * Purpose: To keep track of the statistics of an individual player object
 */
public class PlayerStats {
    protected int goalsScored;
    protected int strengthFactor;
    protected int gamesWon;
    protected String firstName;
    protected String lastName;
    protected ImageView playerImage;
    protected String team;
    protected String fullName;

    /**
     * Constructor for PlayerStats,
     * @param goalsScored
     * @param strengthFactor
     * @param gamesWon
     * @param firstName
     * @param lastName
     * @param playerImage
     */


    public PlayerStats(int goalsScored, int strengthFactor,
                            int gamesWon, String firstName, String lastName, ImageView playerImage, String team)
    {
        this.goalsScored=goalsScored;
        this.strengthFactor=strengthFactor;
        this.gamesWon=gamesWon;
        this.firstName=firstName;
        this.lastName=lastName;
        this.playerImage=playerImage;
        this.team=team;
        this.fullName = firstName + " " + lastName;

    }
    //Empty constructor
    public PlayerStats(){}
    //method to view the stats of the player
    public void viewStats(View view, TextView[] textField)
    {
        textField[0].setText("Goals Scored: " + goalsScored);
        textField[1].setText("Strength: " + strengthFactor);
        textField[2].setText("Games Won: " + gamesWon);
        textField[3].setText("First Name: " + firstName);
        textField[4].setText("Last Name: " + lastName);
        textField[5].setText("Team Name: " + team);
    }
    //to set the players values
    public void setGamesWon(int gamesWon){this.gamesWon+=gamesWon;}
    public void setStrengthFactor(int strengthFactor){this.strengthFactor=strengthFactor;}
    public void incrementGoals(int goalsScored){this.goalsScored+=goalsScored;}

}
