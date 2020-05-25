package com.example.internetconnections;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import cz.msebera.android.httpclient.entity.mime.Header;

public class MainActivity extends AppCompatActivity {

  Boolean internet_status;


//  ProgressDialog connection_progress;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final Intent intent  = new Intent(this,ConnectionResult.class);

//    connection_progress.

    AsyncHttpClient client = new AsyncHttpClient();
    client.get("https://www.google.com", new AsyncHttpResponseHandler() {


      @Override
      public void onStart() {
        // called before request is started
//        connection_progress.;
      }

      /**
       * Fired when a request returns successfully, override to handle in your own code
       *
       * @param statusCode   the status code of the response
       * @param headers      return headers, if any
       * @param responseBody the body of the HTTP response from the server
       */
      @Override
      public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
          internet_status  = true;
          System.out.println("connected true ------------------");
          intent.putExtra("internet_status",internet_status.toString());
          startActivity(intent);
      }

      /**
       * Fired when a request fails to complete, override to handle in your own code
       *
       * @param statusCode   return HTTP status code
       * @param headers      return headers, if any
       * @param responseBody the response body, if any
       * @param error        the underlying cause of the failure
       */
      @Override
      public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
        internet_status  = false;
        System.out.println("connected false------------------");
        intent.putExtra("internet_status",internet_status.toString());
        startActivity(intent);
      }



      @Override
      public void onRetry(int retryNo) {
        // called when request is retried
      }
    });

}

}
