package cordova.plugin.codeplay.facebookads.free;



import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.ads.AudienceNetworkAds;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.apache.cordova.PluginResult;

import com.facebook.ads.*;

import java.io.IOError;
import java.util.HashMap;



/**
 * This class echoes a string called from JavaScript.
 */
public class codeplayfacebookads extends CordovaPlugin {


    private AdView facebookadView;
    private InterstitialAd interstitialAd;


    private ViewGroup facebookparentView;
    static boolean isFirstTime=true;
    static boolean isBannerLoad=false;
    static boolean isInterstitialLoad=false;
    static boolean isRewardVideoLoad=false;
    private RewardedVideoAd rewardedVideoAd;

    static boolean _isBannerShowing=false;


    boolean _isLoadBannerRequest=false;

    boolean isFirstTimeBannerShowing=true;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try{
                _isLoadBannerRequest = false;

                JSONObject opts = args.optJSONObject(0);


                Context testParameter = (cordova.getActivity()).getBaseContext();
                if (isFirstTime)
                    AudienceNetworkAds.initialize(testParameter);

                isFirstTime = false;


                if (action.equals("showBannerAds")) {


                    if (isBannerLoad && !_isBannerShowing)
                    {
                        if(isFirstTimeBannerShowing)
                        {
                            showBannerAds(callbackContext);

                        }
                        else
                        {
                            showBannerAdsForShow(callbackContext);

                        }
                        return false;
                    }
                    else if (!isBannerLoad) {
                        callbackContext.error("Banner not loaded");
                        return false;

                    } else if (_isBannerShowing) {
                        callbackContext.success("Already banner is showing");
                        return false;
                    }

                }

                if (action.equals("loadBannerAds")) {
                    if (_isBannerShowing) {
                        callbackContext.success("Already banner is loaded and showing");
                        return false;
                    }

                    _isLoadBannerRequest = true;
                }

                if (action.equals("loadAndShowBannerAds") || _isLoadBannerRequest) {

                    if (_isBannerShowing && !_isLoadBannerRequest) {
                        callbackContext.success("Already banner is showing");
                        return false;
                    }


                    String isTesting;
                    String bannerid;

                    try {
                        bannerid = opts.optString("bannerid");
                    } catch (NullPointerException e) {
                        callbackContext.error("Please pass the bannerid");
                        return false;
                    }

                    try {
                        isTesting = opts.optString("isTesting");
                    } catch (NullPointerException e) {
                        callbackContext.error("Please pass isTesting value");
                        return false;
                    }

                    //Banner size set here getBannerAdSize(BANNER SIZE)
                    facebookadView = new AdView(testParameter, bannerid, getBannerAdSize(""));

                    if (Boolean.parseBoolean(isTesting)) {
                        SharedPreferences adPrefs = cordova.getActivity().getSharedPreferences("FBAdPrefs", 0);
                        String deviceIdHash = adPrefs.getString("deviceIdHash", (String) null);
                        AdSettings.addTestDevice(deviceIdHash);
                    }

                    try {
                        facebookBannerAdsShow(callbackContext);
                    } catch (IOError err) {
                        callbackContext.error("App prevent from closing");
                    }
                    //String message = args.getString(0);
                    //this.coolMethod(message, callbackContext);
                    return true;
                }


                if (action.equals("distroyBannerAds")) {


                    if (!_isBannerShowing) {
                        callbackContext.error("Banner is not showing");
                        return false;
                    }

                    cordova.getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (facebookadView != null) {
                                try {

                                    facebookadView.destroy();
                                    facebookadView.setVisibility(View.GONE);

                                    ((ViewGroup) facebookadView.getParent()).removeView(facebookadView);
                                    facebookadView = null;


                                    _isBannerShowing = false;
                                    isBannerLoad = false;


                                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdDistroyed");   //Facebook Banner AdDistroyed
                                    result.setKeepCallback(true);
                                    callbackContext.sendPluginResult(result);

                                } catch (NullPointerException err) {
                                    callbackContext.error(err.toString());
                                }
                            }

                            //callbackContext.success("Facebook banner Ads hide");

                            //PluginResult result = new PluginResult(PluginResult.Status.OK, "");
                            //callbackContext.sendPluginResult(result);
                        }
                    });

                    return true;

                }



            if (action.equals("hideBannerAds")) {


                if (!_isBannerShowing) {
                    callbackContext.error("Banner is not showing");
                    return false;
                }

                cordova.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (facebookadView != null) {
                            try {
                                facebookadView.setVisibility(View.GONE);

                                    /*
                                    facebookadView.destroy();
                                    facebookadView.setVisibility(View.GONE);

                                    ((ViewGroup) facebookadView.getParent()).removeView(facebookadView);
                                    facebookadView = null;


                                    _isBannerShowing = false;
                                    isBannerLoad = false;
                                    */

                                _isBannerShowing = false;

                                PluginResult result = new PluginResult(PluginResult.Status.OK, "AdHidden");   //Facebook Banner AdDistroyed
                                result.setKeepCallback(true);
                                callbackContext.sendPluginResult(result);

                            } catch (NullPointerException err) {
                                callbackContext.error(err.toString());
                            }
                        }

                        //callbackContext.success("Facebook banner Ads hide");

                        //PluginResult result = new PluginResult(PluginResult.Status.OK, "");
                        //callbackContext.sendPluginResult(result);
                    }
                });

                return true;

            }


                if (action.equals("loadInterstitialAds")) {


                    String isTesting;
                    String interstitialid;

                    try {
                        interstitialid = opts.optString("interstitialid");
                    } catch (NullPointerException e) {
                        callbackContext.error("Please pass the interstitial ad id");
                        return false;
                    }

                    try {
                        isTesting = opts.optString("isTesting");
                    } catch (NullPointerException e) {
                        callbackContext.error("Please pass isTesting value");
                        return false;
                    }


                    interstitialAd = new InterstitialAd(testParameter, interstitialid);


                    if (Boolean.parseBoolean(isTesting)) {
                        SharedPreferences adPrefs = cordova.getActivity().getSharedPreferences("FBAdPrefs", 0);
                        String deviceIdHash = adPrefs.getString("deviceIdHash", (String) null);
                        AdSettings.addTestDevice(deviceIdHash);
                    }


                    facebookInterstitialAdsLoad(callbackContext);

                    return true;
                }

                if (action.equals("showInterstitialAds")) {

                    if (isInterstitialLoad) {
                        interstitialAd.show();
                        //callbackContext.success("Facebook interstitial Ads Showing");
                    } else
                        callbackContext.error("First initialize the facebook interstitial ads '	cordova.plugins.codeplayfacebookads.loadInterstitialAds(options,success,fail);'");

                    return true;
                }


                if (action.equals("loadRewardVideoAd")) {

                    String isTesting;
                    String videoid;

                    try {
                        videoid = opts.optString("videoid");
                    } catch (NullPointerException e) {
                        callbackContext.error("Please pass the videoid");
                        return false;
                    }

                    try {
                        isTesting = opts.optString("isTesting");
                    } catch (NullPointerException e) {
                        callbackContext.error("Please pass isTesting value");
                        return false;
                    }


                    rewardedVideoAd = new RewardedVideoAd(testParameter, videoid);

                    if (Boolean.parseBoolean(isTesting)) {
                        SharedPreferences adPrefs = cordova.getActivity().getSharedPreferences("FBAdPrefs", 0);
                        String deviceIdHash = adPrefs.getString("deviceIdHash", (String) null);
                        AdSettings.addTestDevice(deviceIdHash);
                    }

                    facebookRewardVideoAds(callbackContext);

                    return true;
                }


                if (action.equals("showRewardVideoAd")) {

                    if (isRewardVideoLoad) {
                        //interstitialAd.show();
                        rewardedVideoAd.show();
                        isRewardVideoLoad = false;
                        //callbackContext.success("Facebook interstitial Ads Loaded");
                    } else
                        callbackContext.error("First initialize the facebook Video ads '	cordova.plugins.codeplayfacebookads.loadRewardVideoAd(videoid,success,fail);'");

                    return true;
                }
            }
        catch (RuntimeException e){
            callbackContext.error("Runtime exception found");
        }
        return false;
    }



    private void facebookRewardVideoAds(CallbackContext callbackContext)
    {

        try {

            RewardedVideoAdListener rewardedVideoAdListener = new RewardedVideoAdListener() {
                @Override
                public void onError(Ad ad, AdError error) {
                    // Rewarded video ad failed to load
                    //Log.e(TAG, "Rewarded video ad failed to load: " + error.getErrorMessage());
                    isRewardVideoLoad = false;
                    callbackContext.error("Rewarded video ad failed to load: " + error.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    // Rewarded video ad is loaded and ready to be displayed
                    //Log.d(TAG, "Rewarded video ad is loaded and ready to be displayed!");
                    //callbackContext.success("Rewarded video ad is loaded and ready to be displayed!");


                    //PluginResult result = new PluginResult(PluginResult.Status.OK, "AdLoaded");
                    //result.setKeepCallback(true);
                    //callbackContext.sendPluginResult(result);

                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdLoaded"); //Facebook Reward AdLoaded
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);


                    // rewardedVideoAd.show();
                    isRewardVideoLoad = true;
                }

                @Override
                public void onAdClicked(Ad ad) {
                    // Rewarded video ad clicked
                    //Log.d(TAG, "Rewarded video ad clicked!");
                    //callbackContext.error("Rewarded video ad clicked!");
                    //PluginResult result = new PluginResult(PluginResult.Status.OK, "AdClicked");
                    //result.setKeepCallback(true);
                    //callbackContext.sendPluginResult(result);

                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdClicked"); //Facebook Reward AdClicked
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);

                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    // Rewarded Video ad impression - the event will fire when the
                    // video starts playing
                    //callbackContext.success("Rewarded video ad impression logged!");
                    //PluginResult result = new PluginResult(PluginResult.Status.OK, "AdPlaying");
                    //result.setKeepCallback(true);
                    //callbackContext.sendPluginResult(result);

                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdPlaying");  //Facebook Reward AdPlaying
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);

                }

                @Override
                public void onRewardedVideoCompleted() {
                    // Rewarded Video View Complete - the video has been played to the end.
                    // You can use this event to initialize your reward
                    //Log.d(TAG, "Rewarded video completed!");

                    //callbackContext.success("Rewarded video completed!");
                    //PluginResult result = new PluginResult(PluginResult.Status.OK, "AdCompleted");
                    //result.setKeepCallback(true);
                    //callbackContext.sendPluginResult(result);

                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdCompleted");  //Facebook Reward AdCompleted
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);

                    // Call method to give reward
                    // giveReward();
                }

                @Override
                public void onRewardedVideoClosed() {
                    // The Rewarded Video ad was closed - this can occur during the video
                    // by closing the app, or closing the end card.
                    //Log.d(TAG, "Rewarded video ad closed!");
                    //callbackContext.success("Rewarded video ad closed!");
                    //PluginResult result = new PluginResult(PluginResult.Status.OK, "AdClosed");
                    //result.setKeepCallback(true);
                    //callbackContext.sendPluginResult(result);

                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdClosed");   //Facebook Reward AdClosed
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);

                }
            };
            rewardedVideoAd.loadAd(
                    rewardedVideoAd.buildLoadAdConfig()
                            .withAdListener(rewardedVideoAdListener)
                            .build());
        }

        catch(RuntimeException err){
            callbackContext.error("reward video runtime error");
        }
    }



    private void facebookBannerAdsShow(CallbackContext callbackContext) {
        try{
            AdListener adListener = new AdListener() {
                @Override
                public void onError(Ad ad, AdError adError) {
                    // Ad error callback
                    callbackContext.error(adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    // Ad loaded callback
                    //callbackContext.success("Facebook banner Ads loaded");

                    isBannerLoad = true;

                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdLoaded"); //Facebook Banner AdLoaded
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);

                    if (!_isLoadBannerRequest)
                        showBannerAds(callbackContext);


                }

                @Override
                public void onAdClicked(Ad ad) {
                    // Ad clicked callback

                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdClicked");   //Facebook Banner AdClicked
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);

                    //callbackContext.success("Facebook banner Ads clicked");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    // Ad impression logged callback
                    //callbackContext.success("Facebook Ads impression logged");

                    _isBannerShowing = true;

                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdImpression");   //Facebook Banner Ads impression logged
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);


                }
            };

            // Request an ad
            facebookadView.loadAd(facebookadView.buildLoadAdConfig().withAdListener(adListener).build());
        }
        catch(RuntimeException err)
        {
            callbackContext.error("Runtime error");
        }

    }
    public void showBannerAdsForShow(CallbackContext callbackContext)
    {
        cordova.getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {

                facebookadView.setVisibility(View.VISIBLE);

            }
        });

    }



    public void showBannerAds(CallbackContext callbackContext)
    {
        try {

            cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                try {
                    View viewfacebook = webView.getView();
                    ViewGroup facebookwvParentView = (ViewGroup) viewfacebook.getParent();
                    if (facebookparentView == null) {
                        facebookparentView = new LinearLayout(webView.getContext());
                    }


                    if (facebookwvParentView != null && facebookwvParentView != facebookparentView) {
                        ViewGroup facebookrootView = (ViewGroup) (viewfacebook.getParent());
                        facebookwvParentView.removeView(viewfacebook);
                        ((LinearLayout) facebookparentView).setOrientation(LinearLayout.VERTICAL);
                        facebookparentView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 0.0F));
                        viewfacebook.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0F));



                        /*
                        if(viewfacebook.getParent() != null)
                        {
                            ((ViewGroup)viewfacebook.getParent()).removeView(viewfacebook); // <- fix
                        }

                        if(facebookparentView.getParent() != null)
                        {
                            ((ViewGroup)facebookparentView.getParent()).removeView(facebookparentView); // <- fix
                        }
                        */


                        facebookparentView.addView(viewfacebook);
                        facebookrootView.addView(facebookparentView);
                    }

                    /*
                    if(facebookadView.getParent() != null)
                    {
                        ((ViewGroup)facebookadView.getParent()).removeView(facebookadView); // <- fix
                    }
                    */

                    facebookparentView.addView(facebookadView);
                    facebookparentView.bringToFront();
                    facebookparentView.requestLayout();
                    facebookparentView.requestFocus();

                    isFirstTimeBannerShowing=false;

                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdShown"); //Facebook Banner AdLoaded
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }
                catch (IllegalArgumentException err)
                {
                    callbackContext.error(err.toString());
                }

                }
            });

        }
        catch (RuntimeException e){
            callbackContext.error("Runtime exception found");
        }

    }

    private void facebookInterstitialAdsLoad(CallbackContext callbackContext)
    {
        try{
            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    // Interstitial ad displayed callback
                    isInterstitialLoad=false;
                    // callbackContext.success("Facebook interstitial Ads displayed.");
                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdDisplayed");  //Facebook Interstitial AdDisplayed
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
                    // Interstitial dismissed callback
                    // callbackContext.success("Facebook interstitial Ads dismissed");
                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdClosed");     //Facebook Interstitial AdClosed
                    //result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    // Ad error callback
                    isInterstitialLoad=false;
                    callbackContext.error("Facebook interstitial Ads failed to load: " + adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    // Interstitial ad is loaded and ready to be displayed
                    isInterstitialLoad=true;
                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdLoaded");     //Facebook Interstitial AdLoaded
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }

                @Override
                public void onAdClicked(Ad ad) {
                    // Ad clicked callback
                    // callbackContext.success("Facebook interstitial Ads clicked!");
                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdClicked");    //Facebook Interstitial AdClicked
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    // Ad impression logged callback
                    PluginResult result = new PluginResult(PluginResult.Status.OK, "AdImpression"); //Facebook Interstitial AdLogged
                    result.setKeepCallback(true);
                    callbackContext.sendPluginResult(result);
                }


            };

            // For auto play video ads, it's recommended to load the ad
            // at least 30 seconds before it is shown
            interstitialAd.loadAd(
                    interstitialAd.buildLoadAdConfig()
                            .withAdListener(interstitialAdListener)
                            .build());
        }
        catch (RuntimeException e){
            callbackContext.error("Runtime exception found");
        }
    }



    protected AdSize getBannerAdSize(String str) {
        AdSize sz;
        if("BANNER".equals(str)) {
            sz = AdSize.BANNER_HEIGHT_50;
            // other size not supported by facebook audience network: FULL_BANNER, MEDIUM_RECTANGLE, LEADERBOARD, SKYSCRAPER
            //} else if ("SMART_BANNER".equals(str)) {
        } else {
            sz = isTablet() ? AdSize.BANNER_HEIGHT_90 : AdSize.BANNER_HEIGHT_50;
        }

        return sz;
    }

    public boolean isTablet() {
        Configuration conf = cordova.getActivity().getResources().getConfiguration();
        boolean xlarge = ((conf.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == 4);
        boolean large = ((conf.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE);
        return (xlarge || large);
    }

    @Override
    public void onDestroy() {
        if (facebookadView != null) {
            facebookadView.destroy();
        }
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }


}