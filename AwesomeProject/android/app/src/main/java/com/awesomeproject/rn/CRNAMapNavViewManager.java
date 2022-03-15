package com.awesomeproject.rn;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.util.Log;

import androidx.annotation.NonNull;

import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.AMapNaviViewListener;
import com.amap.api.navi.enums.NaviType;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.ArrayList;
import java.util.List;


public class CRNAMapNavViewManager extends ViewGroupManager<CRNAMapNavView> {
    private ThemedReactContext mContext;
    public static AMapNavi mAMapNavi;
    public static final List<NaviLatLng> sList = new ArrayList<NaviLatLng>();
    public static final List<NaviLatLng> eList = new ArrayList<NaviLatLng>();
    public static CRNAMapNavView mCrnAMapNavView;

    @NonNull
    @Override
    public String getName() {
        return "CRNAMapNavView";
    }

    public static void setCRNAMapNavView(Context context){
        try {
            mAMapNavi = AMapNavi.getInstance(context);
            mAMapNavi.addAMapNaviListener(aMapNaviListener);
            NaviLatLng mEndLatlng = new NaviLatLng(40.084894,116.603039);
            NaviLatLng mStartLatlng = new NaviLatLng(39.825934,116.342972);
            sList.add(mStartLatlng);
            eList.add(mEndLatlng);
            mAMapNavi.setEmulatorNaviSpeed(75);



        }catch (Exception e){
            Log.e("","");

        }
        initCRNAMapNavView(new MutableContextWrapper(context));

    }
    public static AMapNaviListener aMapNaviListener = new AMapNaviListener() {
        @Override
        public void onInitNaviFailure() {

        }

        @Override
        public void onInitNaviSuccess() {
            /**
             * 方法: int strategy=mAMapNavi.strategyConvert(congestion, avoidhightspeed, cost, hightspeed, multipleroute); 参数:
             *
             * @congestion 躲避拥堵
             * @avoidhightspeed 不走高速
             * @cost 避免收费
             * @hightspeed 高速优先
             * @multipleroute 多路径
             *
             *  说明: 以上参数都是boolean类型，其中multipleroute参数表示是否多条路线，如果为true则此策略会算出多条路线。
             *  注意: 不走高速与高速优先不能同时为true 高速优先与避免收费不能同时为true
             */
            int strategy = 0;
            try {
                //再次强调，最后一个参数为true时代表多路径，否则代表单路径
                strategy = mAMapNavi.strategyConvert(true, false, false, false, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mAMapNavi.calculateDriveRoute(sList, eList, null, strategy);
        }

        @Override
        public void onStartNavi(int i) {

        }

        @Override
        public void onTrafficStatusUpdate() {

        }

        @Override
        public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

        }

        @Override
        public void onGetNavigationText(int i, String s) {

        }

        @Override
        public void onGetNavigationText(String s) {

        }

        @Override
        public void onEndEmulatorNavi() {

        }

        @Override
        public void onArriveDestination() {

        }

        @Override
        public void onCalculateRouteFailure(int i) {

        }

        @Override
        public void onReCalculateRouteForYaw() {

        }

        @Override
        public void onReCalculateRouteForTrafficJam() {

        }

        @Override
        public void onArrivedWayPoint(int i) {

        }

        @Override
        public void onGpsOpenStatus(boolean b) {

        }

        @Override
        public void onNaviInfoUpdate(NaviInfo naviInfo) {

        }

        @Override
        public void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfos) {

        }

        @Override
        public void updateIntervalCameraInfo(AMapNaviCameraInfo aMapNaviCameraInfo, AMapNaviCameraInfo aMapNaviCameraInfo1, int i) {

        }

        @Override
        public void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfos) {

        }

        @Override
        public void showCross(AMapNaviCross aMapNaviCross) {

        }

        @Override
        public void hideCross() {

        }

        @Override
        public void showModeCross(AMapModelCross aMapModelCross) {

        }

        @Override
        public void hideModeCross() {

        }

        @Override
        public void showLaneInfo(AMapLaneInfo[] aMapLaneInfos, byte[] bytes, byte[] bytes1) {

        }

        @Override
        public void showLaneInfo(AMapLaneInfo aMapLaneInfo) {

        }

        @Override
        public void hideLaneInfo() {

        }

        @Override
        public void onCalculateRouteSuccess(int[] ints) {

        }

        @Override
        public void notifyParallelRoad(int i) {

        }

        @Override
        public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfos) {

        }

        @Override
        public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {

        }

        @Override
        public void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {

        }

        @Override
        public void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {

        }

        @Override
        public void onPlayRing(int i) {

        }

        @Override
        public void onCalculateRouteSuccess(AMapCalcRouteResult aMapCalcRouteResult) {
            mAMapNavi.startNavi(NaviType.EMULATOR);
        }

        @Override
        public void onCalculateRouteFailure(AMapCalcRouteResult aMapCalcRouteResult) {

        }

        @Override
        public void onNaviRouteNotify(AMapNaviRouteNotifyData aMapNaviRouteNotifyData) {

        }

        @Override
        public void onGpsSignalWeak(boolean b) {

        }
    };

    @NonNull
    @Override
    protected CRNAMapNavView createViewInstance(@NonNull ThemedReactContext reactContext) {
        mContext = reactContext;
        ((MutableContextWrapper)mCrnAMapNavView.getContext()).setBaseContext(reactContext);
        if(mCrnAMapNavView == null){
            initCRNAMapNavView(reactContext);
        }

        try {
            mAMapNavi = AMapNavi.getInstance(reactContext);
            mAMapNavi.addAMapNaviListener(aMapNaviListener);
            NaviLatLng mEndLatlng = new NaviLatLng(40.084894,116.603039);
            NaviLatLng mStartLatlng = new NaviLatLng(39.825934,116.342972);
            sList.add(mStartLatlng);
            eList.add(mEndLatlng);
            mAMapNavi.setEmulatorNaviSpeed(75);



        }catch (Exception e){
            Log.e("","");

        }



        return mCrnAMapNavView;

    }

    public static void initCRNAMapNavView(Context context){
        mCrnAMapNavView = new CRNAMapNavView(context);
        mCrnAMapNavView.initAMapRouter(new AMapNaviViewListener() {

            @Override
            public void onNaviSetting() {

            }

            @Override
            public void onNaviCancel() {

            }

            @Override
            public boolean onNaviBackClick() {
                return false;
            }

            @Override
            public void onNaviMapMode(int i) {

            }

            @Override
            public void onNaviTurnClick() {

            }

            @Override
            public void onNextRoadClick() {

            }

            @Override
            public void onScanViewButtonClick() {

            }

            @Override
            public void onLockMap(boolean b) {

            }

            @Override
            public void onNaviViewLoaded() {

            }

            @Override
            public void onMapTypeChanged(int i) {

            }

            @Override
            public void onNaviViewShowMode(int i) {

            }
        });
    }

    @ReactProp(name = "startNavi")
    public void startNavi(CRNAMapNavView crnaMapNavView, ReadableMap routeInfo){
        try {
            NaviLatLng mEndLatlng = new NaviLatLng(40.084894,116.603039);
            NaviLatLng mStartLatlng = new NaviLatLng(39.825934,116.342972);
            sList.add(mStartLatlng);
            eList.add(mEndLatlng);
            mAMapNavi = AMapNavi.getInstance(mContext);
            mAMapNavi.addAMapNaviListener(aMapNaviListener);



        }catch (Exception e){

        }

    }

    @ReactProp(name = "startNavi")
    public void stopNavi(CRNAMapNavView crnaMapNavView, ReadableMap routeInfo){
        try {
            mAMapNavi = AMapNavi.getInstance(mContext);
            mAMapNavi.removeAMapNaviListener(aMapNaviListener);
            mAMapNavi.stopNavi();

        }catch (Exception e){

        }


    }




}
