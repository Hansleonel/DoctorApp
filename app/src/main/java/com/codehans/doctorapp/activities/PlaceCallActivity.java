package com.codehans.doctorapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.codehans.doctorapp.R;
import com.codehans.doctorapp.services.SinchService;
import com.sinch.android.rtc.calling.Call;

public class PlaceCallActivity extends BaseActivity {

    private TextView txtVNamePerson;

    private String idPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_call);

        txtVNamePerson = findViewById(R.id.txtVNamePerson);

        idPerson = getIntent().getStringExtra("idPerson");
        callButtonClicked(idPerson);
    }

    @Override
    protected void onServiceConnected() {
        getSinchServiceInterface().getUserName();
    }

    private void callButtonClicked(String idPerson) {
        Call call = getSinchServiceInterface().callUserVideo(idPerson);
        String callId = call.getCallId();

        Intent intent = new Intent(this, CallScreenActivity.class);
        intent.putExtra(SinchService.CALL_ID, callId);
        startActivity(intent);
    }
}