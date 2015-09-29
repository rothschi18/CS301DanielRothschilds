package com.example.administrator.danielrcs371hw2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

/*
*Author: Daniel Rothschilds
*Last Edit: September 28th
 * Purpose: To create a new team
 */
public class SecondActivity extends ActionBarActivity {
    //Declare an array of images and resources to be able to display the players
    public ImageButton[] teamImages;
    public int[] teamResources;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        teamImages = new ImageButton[10];
        teamImages[0] = (ImageButton)this.findViewById(R.id.TI1);
        teamImages[1] = (ImageButton)this.findViewById(R.id.TI2);
        teamImages[2] = (ImageButton)this.findViewById(R.id.TI3);
        teamImages[3] = (ImageButton)this.findViewById(R.id.TI4);
        teamImages[4] = (ImageButton)this.findViewById(R.id.TI5);
        teamImages[5] = (ImageButton)this.findViewById(R.id.TI6);
        teamImages[6] = (ImageButton)this.findViewById(R.id.TI7);
        teamImages[7] = (ImageButton)this.findViewById(R.id.TI8);
        teamImages[8] = (ImageButton)this.findViewById(R.id.TI9);
        teamImages[9] = (ImageButton)this.findViewById(R.id.TI10);

        teamImages[0].setBackgroundResource(R.mipmap.america);
        teamImages[1].setBackgroundResource(R.mipmap.batman);
        teamImages[2].setBackgroundResource(R.mipmap.soccerfield);
        teamImages[3].setBackgroundResource(R.mipmap.deadpool);
        teamImages[4].setBackgroundResource(R.mipmap.flames);
        teamImages[5].setBackgroundResource(R.mipmap.flash);
        teamImages[6].setBackgroundResource(R.mipmap.greenlantern);
        teamImages[7].setBackgroundResource(R.mipmap.ironman);
        teamImages[8].setBackgroundResource(R.mipmap.loki);
        teamImages[9].setBackgroundResource(R.mipmap.mario);


        teamResources = new int[10];
        teamResources[0] = R.mipmap.america;
        teamResources[1] = R.mipmap.batman;
        teamResources[2] = R.mipmap.soccerfield;
        teamResources[3] = R.mipmap.deadpool;
        teamResources[4] = R.mipmap.flames;
        teamResources[5] = R.mipmap.flash;
        teamResources[6] = R.mipmap.greenlantern;
        teamResources[7] = R.mipmap.ironman;
        teamResources[8] = R.mipmap.loki;
        teamResources[9] = R.mipmap.mario;






    }
    //Switch back to the main activity
    public void backToMain(View view)
    {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    //Create a team with the image
    public void createFinalTeam(View view)
    {
        //set an anchor number that will be the resource to be used
        int resource = 0;
        //Search through the array of teamImages and set the anchor
        for(int i = 0; i<10; i++)
        {
            if(view==teamImages[i])
                resource = i;
        }

        EditText teamText = (EditText)findViewById(R.id.editText);


        //create a new team object
        TeamRoster newTeam = new TeamRoster(teamText.getText().toString(), teamResources[resource]);
        //the amount of teams it can hold is limited to 15
        if(MainActivity.TeamData.rosterDatabase.size()<15) {
            MainActivity.TeamData.addTeam(newTeam);

        }
        //switch back to the main view
        backToMain(view);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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