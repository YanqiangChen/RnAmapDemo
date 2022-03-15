package com.awesomeproject.rn;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.AMapNaviViewListener;
import com.amap.api.navi.AMapNaviViewOptions;
import com.awesomeproject.R;


public class CRNAMapNavView extends FrameLayout {
    private Context mContext;
    private AMapNaviView aMapNaviView;

    public CRNAMapNavView(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    public CRNAMapNavView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public CRNAMapNavView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public CRNAMapNavView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
    }
    public AMapNaviView getAMapView(){
        return aMapNaviView;
    }
    public void initAMapRouter(AMapNaviViewListener aMapNaviViewListener){
        View popupView = View.inflate(getContext(), R.layout.activity_basic_navi, CRNAMapNavView.this);
        FrameLayout frameLayout = popupView.findViewById(R.id.fr_layout);
        aMapNaviView = popupView.findViewById(R.id.navi_view);
        AMapNaviViewOptions aMapNaviViewOptions = new AMapNaviViewOptions();
        aMapNaviViewOptions.setLayoutVisible(true);
        aMapNaviViewOptions.setSettingMenuEnabled(true);
        aMapNaviViewOptions.setRealCrossDisplayShow(true);
        aMapNaviViewOptions.setRouteListButtonShow(true);
        aMapNaviViewOptions.setTrafficBarEnabled(true);
        aMapNaviView.setViewOptions(aMapNaviViewOptions);
        if(aMapNaviViewListener != null){
            aMapNaviView.setAMapNaviViewListener(aMapNaviViewListener);
        }
//        aMapNaviView.onCreate(new Bundle());
        if (frameLayout != null) {
            ViewGroup parentViewGroup = (ViewGroup) frameLayout.getParent();
            if (parentViewGroup != null ) {
                parentViewGroup.removeView(frameLayout);
            }
        }
        addView(frameLayout, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));



    }
}
