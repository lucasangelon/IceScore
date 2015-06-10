package hockey.icescore.helper;

import android.widget.BaseAdapter;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hockey.icescore.R;


/**
 * Created by Suchi on 7/04/15.
 */
public class GameSelectListViewAdapter extends BaseAdapter{
    private static ArrayList<SearchResults> searchArrayList;

    private LayoutInflater mInflater;

    public GameSelectListViewAdapter(Context context, ArrayList<SearchResults> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return searchArrayList.size();
    }

    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_view_game_select, null);
            holder = new ViewHolder();
            holder.txtHomeTeamName = (TextView) convertView.findViewById(R.id.name);
            holder.txtAwayTeamName = (TextView) convertView.findViewById(R.id.cityState);
            holder.txtVenue = (TextView) convertView.findViewById(R.id.phone);
            holder.txtDate = (TextView) convertView.findViewById(R.id.date);
            holder.txtTime = (TextView) convertView.findViewById(R.id.time);

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtHomeTeamName.setText(searchArrayList.get(position).getHomeTeamName());
        holder.txtAwayTeamName.setText(searchArrayList.get(position).getAwayTeamName());
        holder.txtVenue.setText(searchArrayList.get(position).getVenue());
        holder.txtDate.setText(searchArrayList.get(position).getDate());
        holder.txtTime.setText(searchArrayList.get(position).getTime());

        return convertView;
    }

    static class ViewHolder {
        TextView txtHomeTeamName;
        TextView txtAwayTeamName;
        TextView txtVenue;
        TextView txtDate;
        TextView txtTime;

    }

}
