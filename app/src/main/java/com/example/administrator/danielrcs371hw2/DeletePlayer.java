package com.example.administrator.danielrcs371hw2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Iterator;
import java.util.Map;

/*
*Author: Daniel Rothschilds
*Latest Edit: September 28th 2015
 */
public class DeletePlayer extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_player);
    }
    /*
    * Method: deletePlayerAndReturn
    *  Purpose: Iterate through the tree of Teams and Players and if the text from the EditText
    *  field matches a Players full name in the List of players then delete it from the HashMap
     */
    public void deletePlayerAndReturn(View view)
    {

        //Create a variable equal to the Edit Text field on the screen
        EditText player = (EditText)this.findViewById(R.id.deletePlayer);
        //For Each Loop: loop through the HashMap of Teams
        for(String key: MainActivity.TeamData.rosterDatabase.keySet())
        {

            //Because we may be deleting and iterating through the hashmap at the same time,
            //A different type of iterator must be used
            Iterator<Map.Entry<String, PlayerStats>> iter = MainActivity.TeamData.rosterDatabase.get(key).teamPlayers.entrySet().iterator();
            while (iter.hasNext())
            {
                Map.Entry<String, PlayerStats> entry = iter.next();
                //If the value of the entry equals the text of the EditText field
                if (entry.getValue().fullName.equals(player.getText().toString()))
                {
                    //Remove the object
                    iter.remove();
                }

            }
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_delete_player, menu);
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
