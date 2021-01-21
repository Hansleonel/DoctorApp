package com.codehans.doctorapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.codehans.doctorapp.R;
import com.codehans.doctorapp.services.SinchService;
import com.sinch.android.rtc.calling.Call;

public class PlaceCallActivity extends BaseActivity {

    private TextView txtVNamePerson, txtVIdPerson;

    private String idPerson, namePerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_call);

        txtVIdPerson = findViewById(R.id.txtVIdPerson);
        txtVNamePerson = findViewById(R.id.txtVNamePerson);
        txtVIdPerson = findViewById(R.id.txtVIdPerson);

        idPerson = getIntent().getStringExtra("idPerson");
        namePerson = getIntent().getStringExtra("namePerson");
        Log.d("idPerson", "onCreate: " + " id: " + idPerson + " name: " + namePerson);
        txtVNamePerson.setText(namePerson);
        txtVIdPerson.setText(idPerson);

        findViewById(R.id.btnCall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callButtonClicked();
            }
        });

        findViewById(R.id.btnCall02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopButtonClicked();
            }
        });
    }

    @Override
    protected void onServiceConnected() {
        Log.d("TAG", "onServiceConnected: " + getSinchServiceInterface().getUserName());
    }

    private void stopButtonClicked() {
        if (getSinchServiceInterface() != null) {
            getSinchServiceInterface().stopClient();
        }
        finish();
    }

    private void callButtonClicked() {
        String userName = txtVIdPerson.getText().toString();

        Call call = getSinchServiceInterface().callUserVideo(userName);
        String callId = call.getCallId();

        Intent callScreen = new Intent(this, CallScreenActivity.class);
        callScreen.putExtra(SinchService.CALL_ID, callId);
        startActivity(callScreen);
        finish();
    }
}