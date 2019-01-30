package com.example.lbenitez.schoolapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ColegiosInteractionListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

//  @Override
//  public void onColegioDireccionClick(String direccion) {
//    Intent intent = new Intent(Intent.ACTION_CALL);
//    intent.setData(Uri.parse("Ubi:" + direccion));
//    if (intent.resolveActivity(getPackageManager()) != null) {
//      startActivity(intent);
//    } else {
//      // Toast
//    }
//
//  }

  @Override
  public void onColegioDireccionClick(String direccion) {
    Uri location = Uri.parse("geo:0,0?q=" + direccion);
    Intent intent = new Intent(Intent.ACTION_VIEW, location);
    startActivity(intent);
  }


}
