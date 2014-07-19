/** Custom ListView adapter. Used to create custom layout within ListView.
 *  Don't ask me how it works. */

package com.destination.gotoapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListViewAdapter extends ArrayAdapter<GroupListItem> {
	Context context;

    public CustomListViewAdapter(Context context, int resourceId,
            List<GroupListItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }
 
    private class ViewHolder {
        ImageView groupImage;
        TextView groupName;
        TextView recentActivity;
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
            holder.recentActivity = (TextView) convertView.findViewById(R.id.RecentGroupActivity);
            holder.groupImage = (ImageView) convertView.findViewById(R.id.GroupImage);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
    	}
 
        holder.groupName.setText(groupListItem.getGroupName());
        holder.recentActivity.setText(groupListItem.getRecentActivity());
        try {
        	holder.groupImage.setImageDrawable(new ImageOperations().execute(groupListItem.getImageLocation()).get());
        } catch (InterruptedException e) {
        	e.printStackTrace();
        	holder.groupImage.setImageDrawable(null);
        } catch (ExecutionException e) {
        	e.printStackTrace();
        	holder.groupImage.setImageDrawable(null);
        }
 
        return convertView;
    }
    
    private class ImageOperations extends AsyncTask<String, Void, Drawable> {
    	public Drawable doInBackground(String... url) {
        	try {
        		InputStream is = (InputStream) new URL(url[0]).getContent();
        		Drawable d = Drawable.createFromStream(is, "image.jpg");
        		return d;
        	} catch (MalformedURLException e) {
        		e.printStackTrace();
        		return null;
        	} catch (IOException e) {
        		e.printStackTrace();
        		return null;
        	}
        }
    }
    
    
}
