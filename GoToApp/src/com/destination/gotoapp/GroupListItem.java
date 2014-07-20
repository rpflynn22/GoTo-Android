package com.destination.gotoapp;

public class GroupListItem {
	/** Constructor for GroupListItem Object. */
	GroupListItem(String groupNameIn, String streamNameIn/*, String recentActivityIn*/) {
		groupName = groupNameIn;
		streamName = streamNameIn;
		//recentActivity = recentActivityIn;
	}

	/** Getter for groupName. */
	public String getGroupName() {
		return groupName;
	}
	
	/** Getter for streamName. */
	public String getStreamName() {
		return streamName;
	}
	
	/** Getter for recentActivity. */
	/*public String getRecentActivity() {
		return recentActivity;
	}*/
	
	/** The name of the group */
	private String groupName;
	/** The text describing recent activity. */
	//private String recentActivity;
	/** The streamname for pubhub. */
	private String streamName;
}
