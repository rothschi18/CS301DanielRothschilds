package com.example.administrator.danielrcs371hw2;

import android.app.Activity;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.LinkedHashMap;


/**
 * Created by rothschi18 on 9/19/2015.
 */
public class TeamRosterDatabase {
    public  HashMap<String, TeamRoster> rosterDatabase;
    //I have set a limit on the total teams that can be made
    private int totalTeams;
    //public static Button[] teamList;
    private int maxTeams = 12;
    private Activity mainActivity;
    //I want to preserve the order that teams are shown on the main page

    public LinkedHashMap<TeamRoster, Button> mainTeamButtons;

    //pass in a view so methods in this function can manipulate it
    public TeamRosterDatabase(Activity Main)
    {
        mainActivity = Main;
        //totalTeams = countTeams();
        rosterDatabase = new HashMap<String, TeamRoster>();
        mainTeamButtons = new LinkedHashMap<TeamRoster, Button>();
        //Need to build up an array of all the buttons that will be the list of teams
        totalTeams = rosterDatabase.size();







    }
    //Add a team to the roster
    public void addTeam(TeamRoster newTeam)
    {
        String key = newTeam.teamName;
        if(totalTeams>15)
            return;
        if(rosterDatabase.containsKey(key))
        {
            return;
        }

        rosterDatabase.put(key, newTeam);
    }

    public void deleteTeam(String key)
    {

        if(rosterDatabase.containsKey(key))
        {
            rosterDatabase.remove(key);
        }

    }

    //Method may be used in future implementations
    public int countTeams()
    {
        return rosterDatabase.size();
    }

    //Displays the teams in the Main Activity
    public void viewTeams(Activity main, Button[] teamList)
    {
        //initially set all buttons to invisible
        for(int i = 0; i<15; i++){
            teamList[i].setVisibility(View.INVISIBLE);
        }

        int counter = 0;

        //now set all values in the rosterDatabase to their corresponding button
        for(String key: rosterDatabase.keySet())
        {
            teamList[counter].setVisibility(View.VISIBLE);
            teamList[counter].setText(rosterDatabase.get(key).teamName);
            counter++;
        }

    }

    //Create a map of players to their images to be used for displaying the players and their stats
    public HashMap<ImageButton, String> createPlayerMap(HashMap<ImageButton, String> playerMap, ImageButton[] images, TeamRoster team)
    {
        int counter = 0;


        for(String name: team.teamPlayers.keySet())
        {
            playerMap.put(images[counter], team.teamPlayers.get(name).firstName + " " +team.teamPlayers.get(name).lastName);
            counter++;
        }

        return playerMap;

    }


    //Create two default teams
    public void declareTeams()
    {


        ImageView view1 = new ImageView(mainActivity);
        view1.setImageResource(R.mipmap.player1);
        PlayerStats player1 = new PlayerStats(4, 6, 0, "Dog", "Brady", view1, "TeamTwo");

        ImageView view2 = new ImageView(mainActivity);
        view2.setImageResource(R.mipmap.player2);
        PlayerStats player2 = new PlayerStats(3, 2, 0, "Dag", "Dobby", view2, "TeamOne");

        ImageView view3 = new ImageView(mainActivity);
        view3.setImageResource(R.mipmap.player3);
        PlayerStats player3 = new PlayerStats(3, 7, 0, "Rex", "Luther", view3, "TeamTwo");

        ImageView view4 = new ImageView(mainActivity);
        view4.setImageResource(R.mipmap.player4);
        PlayerStats player4 = new PlayerStats(4, 2, 0, "Batmans", "Cape", view4, "TeamTwo");

        ImageView view5 = new ImageView(mainActivity);
        view5.setImageResource(R.mipmap.player5);
        PlayerStats player5 = new PlayerStats(5, 1, 0, "Pug", "Boy", view5, "TeamOne");

        ImageView view6 = new ImageView(mainActivity);
        view6.setImageResource(R.mipmap.player6);
        PlayerStats player6 = new PlayerStats(6, 9, 0, "Just", "In", view6, "TeamTwo");

        ImageView view7 = new ImageView(mainActivity);
        view7.setImageResource(R.mipmap.player7);
        PlayerStats player7 = new PlayerStats(7, 4, 0, "Lazy", "Doge", view7, "TeamTwo");

        ImageView view8 = new ImageView(mainActivity);
        view8.setImageResource(R.mipmap.player8);
        PlayerStats player8 = new PlayerStats(8, 12, 0, "God", "Strength", view8, "TeamOne");

        ImageView view9 = new ImageView(mainActivity);
        view9.setImageResource(R.mipmap.player9);
        PlayerStats player9 = new PlayerStats(0, 1, 0, "Little", "Toby", view9, "TeamOne");

        ImageView view10 = new ImageView(mainActivity);
        view10.setImageResource(R.mipmap.player10);
        PlayerStats player10 = new PlayerStats(1, 7, 0, "Santa", "Please", view10, "TeamOne");


        //create two teams
        TeamRoster team2 = new TeamRoster("TeamTwo", R.mipmap.america);
        team2.addPlayer(player1);
        team2.addPlayer(player3);
        team2.addPlayer(player7);
        team2.addPlayer(player4);
        team2.addPlayer(player6);

        TeamRoster team1 = new TeamRoster("TeamOne", R.mipmap.batman);
        team1.addPlayer(player5);
        team1.addPlayer(player2);
        team1.addPlayer(player8);
        team1.addPlayer(player9);
        team1.addPlayer(player10);


        //Add the teams to the database
        rosterDatabase.put(team1.getTeamName(), team1);
        rosterDatabase.put(team2.getTeamName(), team2);





    }
    //this method returns the teamRoster that was clicked on
    public TeamRoster getTeamRoster(Button view)
    {

        for(String key: rosterDatabase.keySet())
        {
            if((view.getText().toString()).equals(key))
            {

                return rosterDatabase.get(key);

            }

        }

        return null;
    }
}