package com.codehans.doctorapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codehans.doctorapp.R;
import com.codehans.doctorapp.adapters.NotificationAdapter;
import com.codehans.doctorapp.models.Notification;
import com.codehans.doctorapp.models.Schedule;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {

    private SwipeRefreshLayout swipeRefreshLayoutNotification;
    private RecyclerView recyclerViewNotification;

    private ImageView imgVPhotoDoctor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        imgVPhotoDoctor = view.findViewById(R.id.inboxNotification);

        Glide.with(getContext())
                .load("https://www.pngfind.com/pngs/m/53-530843_doctor-png-clipart-doctor-isolated-transparent-png.png")
                .circleCrop()
                .into(imgVPhotoDoctor);

        swipeRefreshLayoutNotification = view.findViewById(R.id.swipeV_Notification);
        recyclerViewNotification = view.findViewById(R.id.rV_notification);

        getPropertiesRV();
        getNotificationData();

        swipeRefreshLayoutNotification.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getNotificationData();
                Toast.makeText(getContext(), "Tus notificaciones estan actualizadas", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void getPropertiesRV() {
        recyclerViewNotification.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);

        mLinearLayoutManager.setReverseLayout(false);

        recyclerViewNotification.setLayoutManager(mLinearLayoutManager);
        recyclerViewNotification.addItemDecoration(mDividerItemDecoration);
    }

    private void getNotificationData() {
        ArrayList<Notification> notificationArrayList = new ArrayList<>();

        notificationArrayList.add(new Notification(1, 1, " ", "Cita Médica", "Tu siguiente cita empezara pronto", "Hace 5 minutos"));

        NotificationAdapter notificationAdapter = new NotificationAdapter(getContext(), notificationArrayList);
        notificationAdapter.notifyDataSetChanged();

        recyclerViewNotification.setAdapter(notificationAdapter);

        swipeRefreshLayoutNotification.setVisibility(View.VISIBLE);
        swipeRefreshLayoutNotification.setRefreshing(false);
    }
}