package com.destination.gotoapp;

public class GroupListItem {
	/** Constructor for GroupListItem Object. */
	GroupListItem(String groupNameIn, String recentActivityIn, String imageLocationIn) {
		groupName = groupNameIn;
		recentActivity = recentActivityIn;
		imageLocation = imageLocationIn;
	}

	/** Getter for groupName. */
	public String getGroupName() {
		return groupName;
	}
	
	/** Getter for recentActivity. */
	public String getRecentActivity() {
		return recentActivity;
	}
	
	/** Getter for imageLocation. */
	public String getImageLocation() {
		return imageLocation;
	}
	
	/** The name of the group */
	private String groupName;
	/** The text describing recent activity. */
	private String recentActivity;
	/** The http request location as a string. */ // TODO this will need to be changed based on the backend config.
	private String imageLocation;
	
}
