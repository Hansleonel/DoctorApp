package com.codehans.doctorapp.fragments;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codehans.doctorapp.R;
import com.codehans.doctorapp.activities.PlaceCallActivity;
import com.codehans.doctorapp.adapters.ScheduleAdapter;
import com.codehans.doctorapp.models.Schedule;

import java.util.ArrayList;

public class ScheduleFragment extends Fragment {

    private SwipeRefreshLayout swipeRefreshLayoutSchedule;
    private RecyclerView recyclerViewSchedules;

    private ImageView imgVPhotoDoctor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        swipeRefreshLayoutSchedule = view.findViewById(R.id.swipeV_Schedule);
        recyclerViewSchedules = view.findViewById(R.id.rV_Schedule);

        imgVPhotoDoctor = view.findViewById(R.id.inbox);

        Glide.with(getContext())
                .load("https://www.pngfind.com/pngs/m/53-530843_doctor-png-clipart-doctor-isolated-transparent-png.png")
                .circleCrop()
                .into(imgVPhotoDoctor);

        getPropertiesRV();
        getDataSchedules();

        swipeRefreshLayoutSchedule.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataSchedules();
                Toast.makeText(getContext(), R.string.schedule_refresh, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    private void getPropertiesRV() {
        recyclerViewSchedules.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);

        mLinearLayoutManager.setReverseLayout(false);

        recyclerViewSchedules.setLayoutManager(mLinearLayoutManager);
        recyclerViewSchedules.addItemDecoration(mDividerItemDecoration);
    }

    private void getDataSchedules() {
        ArrayList<Schedule> scheduleArrayList = new ArrayList<>();

        scheduleArrayList.add(new Schedule(1000000, "https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8d29tYW58ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80", "Raquel Torres Joaquin", "Dolor Abdominal", "Dolor en el centro del estomago durante una semana", "7 Mar, 4:26 pm"));
        scheduleArrayList.add(new Schedule(2000000, "https://cdn.fs.teachablecdn.com/ezN0MmFuQMONni797t1D", "Patricia Gamarra Brescia", "Gastritis", "Dolor durante 1 semana y media", "7 Mar, 5:30 pm"));
        scheduleArrayList.add(new Schedule(3000000, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeDeaYzC2sP-L420tZa_LBFRNWQx4t9GZ4Ig&usqp=CAU", "Susana Belaunde Caballero", "Dolor localizado", "Dolor en el centro del estomago de manera eventual", "7 Mar, 6:00 pm"));
        scheduleArrayList.add(new Schedule(4000000, "https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80", "Juan Alvaro Miro", "Dolor gastrointestinal", "Dolor en el lado izquierdo del estomago", "7 Mar, 6:30 pm"));
        scheduleArrayList.add(new Schedule(5000000, "https://upload.wikimedia.org/wikipedia/commons/d/de/Sam_Worthington_4%2C_2013.jpg", "Rodrigo Castro Alvarado", "Gastritis", "Dolor constante en el parte abdominal", "7 Mar, 7:00 pm"));
        scheduleArrayList.add(new Schedule(6000000, "https://app.employmentjamaica.com/uploads/jobseekers/4eba1078899bfa19831ee81a99daac3e.jpg", "Augusto Moscoso Robert", "Dolor Gastrointestinal", "Dolor por 3 semanas", "7 mar, 7:30 pm"));

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getContext(), scheduleArrayList);
        scheduleAdapter.notifyDataSetChanged();

        recyclerViewSchedules.setAdapter(scheduleAdapter);

        swipeRefreshLayoutSchedule.setVisibility(View.VISIBLE);
        swipeRefreshLayoutSchedule.setRefreshing(false);

        scheduleAdapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idPerson = ((TextView) recyclerViewSchedules.findViewHolderForAdapterPosition(recyclerViewSchedules.getChildLayoutPosition(view))
                        .itemView.findViewById(R.id.item_schedule_id)).getText().toString();

                Intent intent = new Intent(getContext(), PlaceCallActivity.class);
                intent.putExtra("idPerson", idPerson);
                startActivity(intent);
            }
        });
    }
}