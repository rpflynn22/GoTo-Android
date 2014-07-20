/** Custom ListView adapter. Used to create custom layout within ListView.
 *  Don't ask me how it works. */

package com.destination.gotoapp;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomListViewAdapter extends ArrayAdapter<GroupListItem> {
	Context context;

    public CustomListViewAdapter(Context context, int resourceId,
            List<GroupListItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }
 
    private class ViewHolder {
        TextView groupName;
        //TextView recentActivity;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        GroupListItem groupListItem = getItem(position);
 
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.group_list_adapter, null);
            holder = new ViewHolder();
            holder.groupName = (TextView) convertView.findViewById(R.id.GroupName);
            //holder.recentActivity = (TextView) convertView.findViewById(R.id.RecentGroupActivity);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
    	}
 
        holder.groupName.setText(groupListItem.getGroupName());
        //holder.recentActivity.setText(groupListItem.getRecentActivity());
        return convertView;
    }
}
