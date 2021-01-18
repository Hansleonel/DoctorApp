package com.codehans.doctorapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codehans.doctorapp.R;
import com.codehans.doctorapp.services.SinchService;
import com.sinch.android.rtc.SinchError;

public class MainActivity extends BaseActivity implements SinchService.StartFailedListener {

    private EditText edtUserDni, edtUserPassword;
    private Button btnLogin;

    private ProgressDialog mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserDni = findViewById(R.id.edtUserDni);
        edtUserPassword = findViewById(R.id.edtUserPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }

    private void login() {
        String userName = edtUserDni.getText().toString();

        if (userName.isEmpty()) {
            Toast.makeText(this, "Ingrese DNI", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!userName.equals(getSinchServiceInterface().getUserName())) {
            getSinchServiceInterface().stopClient();
        }

        if (!getSinchServiceInterface().isStarted()) {
            getSinchServiceInterface().startClient(userName);
            showSpinner();
        } else {
            openPlaceCallActivity();
        }
    }

    private void showSpinner() {
        mSpinner = new ProgressDialog(this);
        mSpinner.setTitle("Logging in");
        mSpinner.setMessage("Please wait...");
        mSpinner.show();
    }

    private void openPlaceCallActivity() {
        Intent mainActivity = new Intent(this, NavigationActivity.class);
        startActivity(mainActivity);
    }

    @Override
    protected void onServiceConnected() {
        btnLogin.setEnabled(true);
        getSinchServiceInterface().setStartListener(this);
    }

    @Override
    protected void onPause() {
        if (mSpinner != null) {
            mSpinner.dismiss();
        }
        super.onPause();
    }

    @Override
    public void onStartFailed(SinchError error) {
        Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show();
        if (mSpinner != null) {
            mSpinner.dismiss();
        }
    }

    @Override
    public void onStarted() {
        openPlaceCallActivity();
    }

}