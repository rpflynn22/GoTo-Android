package com.destination.gotoapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class GroupDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_detail);
		Bundle b = getIntent().getExtras();
		final String number = b.getString("groupName");
		final String name = b.getString("streamName");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.group_detail, menu);
		return true;
	}

}
