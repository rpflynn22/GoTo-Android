/** Custom ListView adapter. Used to create custom layout within ListView.
 *  Don't ask me how it works. */

package com.destination.gotoapp;

import java.util.HashMap;
import java.util.List;

import org.joda.time.DateTime;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DetailListAdapter extends ArrayAdapter<Event> {
	Context context;
	
	HashMap<Integer, String> MONTH_MAP = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(1, "Jan");
			put(2, "Feb");
			put(3, "Mar");
			put(4, "Apr");
			put(5, "May");
			put(6, "Jun");
			put(7, "Jul");
			put(8, "Aug");
			put(9, "Sep");
			put(10, "Oct");
			put(11, "Nov");
			put(12, "Dec");
		}
	};

    public DetailListAdapter(Context context, int resourceId,
            List<Event> items) {
        super(context, resourceId, items);
        this.context = context;
    }
 
    private class ViewHolder {
        TextView userNameView;
        TextView timeStampView;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Event event = getItem(position);
 
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.group_detail_list_row, null);
            holder = new ViewHolder();
            holder.userNameView = (TextView) convertView.findViewById(R.id.UserName);
            holder.timeStampView = (TextView) convertView.findViewById(R.id.TimeStamp);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
    	}
        String timeRep;
        DateTime timeStamp = event.getTimeStamp();
        if (timeStamp.isBefore(DateTime.now().minusDays(1))) {
        	timeRep = MONTH_MAP.get(timeStamp.getMonthOfYear()) + " " + Integer.toString(timeStamp.getDayOfMonth());
        } else {
        	timeRep = Integer.toString(timeStamp.getHourOfDay()) + ":" + Integer.toString(timeStamp.getMinuteOfHour());
        }
        holder.userNameView.setText(event.getUser());
        holder.timeStampView.setText(timeRep);
        return convertView;
    }
}