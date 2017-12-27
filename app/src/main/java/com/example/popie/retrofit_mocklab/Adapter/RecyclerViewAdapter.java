package com.example.popie.retrofit_mocklab.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.popie.retrofit_mocklab.Model.Event;
import com.example.popie.retrofit_mocklab.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by popie on 11/1/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ContactViewHolder> {

    Context context;
    List<Event> events;

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card_view, null);

        return new ContactViewHolder(v);
    }

    public RecyclerViewAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        Event event = events.get(position);

        holder.name.setText(event.getName());
        holder.date.setText(event.getDate());
        holder.time.setText(event.getTime());

    }


    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView name, date, time;

        public ContactViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);

        }
    }
}
