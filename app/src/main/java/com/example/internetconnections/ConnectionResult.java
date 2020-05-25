package com.example.internetconnections;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ConnectionResult extends AppCompatActivity {

  TextView internet_status_view ;
  String internet_status ;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_connection_result);

    Intent getter = getIntent();
    internet_status = getter.getStringExtra("internet_status");
    internet_status_view = (TextView) findViewById(R.id.internet_status);
    internet_status_view.setText(internet_status);

  }
}
