package com.example.impactioproselyteconsulting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProfileArrayAdapter extends ArrayAdapter<String> {
    public ProfileArrayAdapter(Context context, List<String> allProfiles){
        super(context,0,allProfiles);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent){
        View itemView = convertView;
        ViewHolder viewHolder;

        if(itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.all_profiles_view,parent,false);

            viewHolder = new ViewHolder(itemView);

            itemView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder)itemView.getTag();
        }
        String name = getItem(position);

        viewHolder.personNameTextView.setText(name);
        return itemView;
    }

    public class ViewHolder{
        TextView personNameTextView;
        public ViewHolder(View itemView){
            personNameTextView = itemView.findViewById(R.id.tvPersonProfileName);
        }
    }
}
