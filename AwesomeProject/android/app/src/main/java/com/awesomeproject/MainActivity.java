package com.awesomeproject;

import android.os.Bundle;

import com.awesomeproject.rn.CRNAMapNavViewManager;
import com.facebook.react.ReactActivity;

public class MainActivity extends ReactActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    CRNAMapNavViewManager.setCRNAMapNavView(this);
    if(CRNAMapNavViewManager.mCrnAMapNavView!=null && CRNAMapNavViewManager.mCrnAMapNavView.getAMapView()!=null){
      CRNAMapNavViewManager.mCrnAMapNavView.getAMapView().onCreate(savedInstanceState);
    }

  }

  @Override
  protected void onResume() {
    super.onResume();
    if(CRNAMapNavViewManager.mCrnAMapNavView!=null && CRNAMapNavViewManager.mCrnAMapNavView.getAMapView()!=null){
      CRNAMapNavViewManager.mCrnAMapNavView.getAMapView().onResume();
    }
  }

  @Override
  protected void onPause() {
    if(CRNAMapNavViewManager.mCrnAMapNavView!=null && CRNAMapNavViewManager.mCrnAMapNavView.getAMapView()!=null){
      CRNAMapNavViewManager.mCrnAMapNavView.getAMapView().onPause();
    }
    super.onPause();
  }

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "AwesomeProject";
  }
}
