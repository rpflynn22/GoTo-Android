package com.destination.gotoapp;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class GroupDetailActivity extends Activity {
	
	private static final String API_URL = "gotoapp.herokuapp.com";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_detail);
		Bundle b = getIntent().getExtras();
		final String groupName = b.getString("groupName");
		final String streamName = b.getString("streamName");
		final String id = b.getString("id");
		final String firstName = b.getString("firstName");
		final String lastName = b.getString("lastName");
		TextView title = (TextView) findViewById(R.id.groupDetailListTitle);
		title.setText(groupName);
		recentActivity(streamName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.group_detail, menu);
		return true;
	}
	
	public void listEvents(List<Event> recentEvents) {
		DetailListAdapter adapter = new DetailListAdapter(this,
    			R.layout.group_list_adapter, recentEvents);
		
		final ListView eventListView = (ListView) findViewById(R.id.groupEvents);
		Log.d("is null eventListView", Boolean.toString(eventListView==null));
		Log.d("is null adapter", Boolean.toString(adapter==null));
		eventListView.setAdapter(adapter);
	}
	
	public void recentActivity(String streamName) {
		// TODO make call to pubnub based on streamName and get recent activity
		List<Event> recentEvents = new ArrayList<Event>();
		recentEvents.add(new Event("userid1", DateTime.now().minusHours(2)));
		recentEvents.add(new Event("userid2", DateTime.now()));
		listEvents(recentEvents);
	}

}
