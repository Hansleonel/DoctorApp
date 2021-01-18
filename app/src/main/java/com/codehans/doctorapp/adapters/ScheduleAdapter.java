package com.codehans.doctorapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codehans.doctorapp.R;
import com.codehans.doctorapp.models.Schedule;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    private ArrayList<Schedule> schedules;
    private View.OnClickListener listener;

    public void setOnclickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public ScheduleAdapter(Context mContext, ArrayList<Schedule> schedules) {
        this.mContext = mContext;
        this.schedules = schedules;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_schedule, parent, false);
        ScheduleAdapter.ViewHolder scheduleViewHolder = new ScheduleAdapter.ViewHolder(view);
        view.setOnClickListener(this);
        return scheduleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Schedule item = schedules.get(position);
        viewHolder.bindSchedule(item);
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtV_item_schedule_id, txtV_item_schedule_title, txtV_item_schedule_description, txtV_item_schedule_content, txtV_item_schedule_date;
        private ImageView imgV_item_schedule_call, imgV_item_schedule_photo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtV_item_schedule_id = itemView.findViewById(R.id.item_schedule_id);
            txtV_item_schedule_title = itemView.findViewById(R.id.item_schedule_title);
            txtV_item_schedule_description = itemView.findViewById(R.id.item_schedule_description);
            txtV_item_schedule_content = itemView.findViewById(R.id.item_schedule_content);
            txtV_item_schedule_date = itemView.findViewById(R.id.item_schedule_date);
            imgV_item_schedule_call = itemView.findViewById(R.id.item_schedule_call);
            imgV_item_schedule_photo = itemView.findViewById(R.id.item_schedule_photo);
        }

        public void bindSchedule(Schedule schedule) {
            txtV_item_schedule_id.setText(String.valueOf(schedule.getIdSchedule()));
            txtV_item_schedule_title.setText(schedule.getNamePersonSchedule());
            txtV_item_schedule_description.setText(schedule.getSubjectSchedule());
            txtV_item_schedule_content.setText(schedule.getDescriptionSchedule());
            txtV_item_schedule_date.setText(schedule.getDateSchedule());

            Glide.with(mContext)
                    .load(schedule.getImgPersonSchedule())
                    .circleCrop()
                    .into(imgV_item_schedule_photo);
        }
    }
}
