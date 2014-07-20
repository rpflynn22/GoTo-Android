package com.destination.gotoapp;

import org.joda.time.DateTime;

public class Event {
	public Event(String userIn, DateTime timeStampIn) {
		user = userIn;
		timeStamp = timeStampIn;
	}
	
	public String getUser() {
		return user;
	}
	
	public DateTime getTimeStamp() {
		return timeStamp;
	}
	
	private String user;
	private DateTime timeStamp;
}
