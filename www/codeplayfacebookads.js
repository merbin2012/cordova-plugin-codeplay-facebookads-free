var exec = require('cordova/exec');

exports.showBannerAds = function (arg0, success, error) {
    exec(success, error, 'codeplayfacebookads', 'showBannerAds',[arg0]);
};


exports.hideBannerAds = function (arg0,success, error) {
    exec(success, error, 'codeplayfacebookads', 'hideBannerAds',[arg0]);
};

exports.loadInterstitialAds = function (arg0, success, error) {
    exec(success, error, 'codeplayfacebookads', 'loadInterstitialAds', [arg0]);
};

exports.showInterstitialAds = function (arg0,success, error) {
    exec(success, error, 'codeplayfacebookads', 'showInterstitialAds',[arg0]);
};

exports.loadRewardVideoAd = function (arg0,success, error) {
    exec(success, error, 'codeplayfacebookads', 'loadRewardVideoAd',[arg0]);
};

exports.showRewardVideoAd = function (success, error) {
    exec(success, error, 'codeplayfacebookads', 'showRewardVideoAd',[""]);
};