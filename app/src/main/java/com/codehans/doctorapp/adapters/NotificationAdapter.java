package com.codehans.doctorapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codehans.doctorapp.R;
import com.codehans.doctorapp.models.Notification;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    private ArrayList<Notification> notifications;
    private View.OnClickListener listener;

    public NotificationAdapter(Context mContext, ArrayList<Notification> notifications) {
        this.mContext = mContext;
        this.notifications = notifications;
    }

    public void setOnclickListener(View.OnClickListener listener) {
        this.listener = listener;
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_notification, parent, false);
        NotificationAdapter.ViewHolder notificationViewHolder = new NotificationAdapter.ViewHolder(view);
        view.setOnClickListener(this);
        return notificationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Notification item = notifications.get(position);
        viewHolder.bindNotidication(item);
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtV_item_notification_title, txtV_item_notification_subject, txt_item_notification_timer;
        private ImageView imgV_item_notification;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtV_item_notification_title = itemView.findViewById(R.id.txtV_item_notification_title);
            txtV_item_notification_subject = itemView.findViewById(R.id.txtV_item_notification_subject);
            txt_item_notification_timer = itemView.findViewById(R.id.txt_item_notification_timer);
            imgV_item_notification = itemView.findViewById(R.id.imgV_item_notification);
        }

        public void bindNotidication(Notification notification) {
            txtV_item_notification_title.setText(notification.getTitleNotification());
            txtV_item_notification_subject.setText(notification.getSubjectNotification());
            txt_item_notification_timer.setText(notification.getTimerNotification());
        }
    }
}
