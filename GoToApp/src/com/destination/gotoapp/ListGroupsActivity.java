package com.destination.gotoapp;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListGroupsActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_groups);
        getUserInfo();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_groups, menu);
        return true;
    }
    
    /** Creates a listview of the groups to which the user is subscribed. */
    public void listGroups(List<GroupListItem> groups, String idIn, String firstNameIn, String lastNameIn) {
    	final String userId = idIn;
    	final String firstName = firstNameIn;
    	final String lastName = lastNameIn;
    	final ListView groupList = (ListView) findViewById(R.id.listOfGroups);
    	final List<GroupListItem> listElements = new ArrayList<GroupListItem>();
    	for (GroupListItem group : groups) {
    		//String recentActivity = getRecentActivity(group);
    		listElements.add(group/*, recentActivity*/);
    	}
    	CustomListViewAdapter adapter = new CustomListViewAdapter(this,
    			R.layout.group_list_adapter, listElements);
    	final SwipeDetector swipeDetector = new SwipeDetector();
        groupList.setOnTouchListener(swipeDetector);
    	groupList.setAdapter(adapter);
    	groupList.setOnItemClickListener(new OnItemClickListener() {


    	    @Override
    	    public void onItemClick(AdapterView <? > parent, View view,
    	        int position, long id) {

    	        if (swipeDetector.swipeDetected()) {
    	            if (swipeDetector.getAction() == SwipeDetector.Action.LR) {
    	            	String groupName = listElements.get(position).getGroupName();
    	            	String streamName = listElements.get(position).getStreamName();
    					Intent i = new Intent("com.destination.gotoapp.GroupDetailActivity");
    					Bundle b = new Bundle();
    					b.putString("groupName", groupName);
    					b.putString("streamName", streamName);
    					b.putString("id", userId);
    					b.putString("firstName", firstName);
    					b.putString("lastName", lastName);    					
    					i.putExtras(b);
    			        startActivity(i);
    	            } else if (swipeDetector.getAction() == SwipeDetector.Action.RL) {
    	            	/*String groupName = listElements.get(position).getGroupName();
    	            	String streamName = listElements.get(position).getStreamName();*/
    	            	onSwipeLeft();
    	            }
    	        } else {
    	        	Toast.makeText(ListGroupsActivity.this,
    	                    "Send that notification", Toast.LENGTH_SHORT).show();
    	        }
    	    }    	    
    	});
    	
    }
    
    /** On swipe left. */
    public void onSwipeLeft() {
    	AlertDialog alertDialog = new AlertDialog.Builder(
                ListGroupsActivity.this).create();
    	alertDialog.setMessage("Are you sure you want to be removed from ?");
        alertDialog.setButton("Continue", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // TODO Remove the user from the group
            }
        });
    	alertDialog.show();
    }
    
    public void getUserInfo() {
    	Intent i = new Intent(ListGroupsActivity.this, GetUserFacebookActivity.class);
    	startActivityForResult(i, 1);
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String result = (String) data.getStringExtra("result");
                try {
					JSONObject j = new JSONObject(result);
					TextView v = (TextView) findViewById(R.id.titleGroupList);
	                String firstName = j.getString("first_name");
	                String lastName = j.getString("last_name");
	                String id = j.getString("id");
	                // TODO give it to zach
	                // TODO lookup user and put groups
	                List<GroupListItem> gList = getGroups(id, firstName, lastName);
	                listGroups(gList, id, firstName, lastName);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
    
    /** Get the user's list of groups from the backend. */
    // TODO params should probably include user info
    public List<GroupListItem> getGroups(String id, String firstName, String lastName) {
    	// TODO make HTTP request to the backend
    	List<GroupListItem> gList = new ArrayList<GroupListItem>();
    	gList.add(new GroupListItem("Phi Psi", "phipsi_goto"));
    	gList.add(new GroupListItem("Second Floor", "secondfloor_goto"));
    	gList.add(new GroupListItem("Eta", "eta_goto"));
    	return gList;
    }    
}