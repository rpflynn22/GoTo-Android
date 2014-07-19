package com.destination.gotoapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class ListGroupsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_groups);
        listGroups();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_groups, menu);
        return true;
    }
    
    /** Creates a listview of the groups to which the user is subscribed. */
    public void listGroups() {
    	final ListView groupList = (ListView) findViewById(R.id.listOfGroups);
    	String[] values = getGroups(); // TODO params should probably include user info
    }
    
    /** Get the user's list of groups from the backend. */
    // TODO params should probably include user info
    public String[] getGroups() {
    	// TODO make HTTP request to the backend
    	return new String[] {"Phi Psi", "Second Floor", "Eta"};
    }
    
}
