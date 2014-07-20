package com.destination.gotoapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import org.joda.time.DateTime;

public class GroupDetailActivity extends Activity {
	
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.group_detail, menu);
		return true;
	}
	
	public List<Event> recentActivity(String streamName) {
		// TODO make call to pubnub based on streamName and get recent activity
		List<Event> recentEvents = new ArrayList<Event>();
		recentEvents.add(new Event("userid1", DateTime.now().minusHours(2)));
		recentEvents.add(new Event("userid2", DateTime.now()));
		return recentEvents;
	}

}
