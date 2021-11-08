var exec = require('cordova/exec');

exports.loadAndShowBannerAds = function (arg0, success, error) {
    exec(success, error, 'codeplayfacebookads', 'loadAndShowBannerAds',[arg0]);
};


exports.loadBannerAds = function (arg0, success, error) {
    exec(success, error, 'codeplayfacebookads', 'loadBannerAds',[arg0]);
};


exports.showBannerAds = function (success, error) {
    exec(success, error, 'codeplayfacebookads', 'showBannerAds');
};





exports.hideBannerAds = function (success, error) {
    exec(success, error, 'codeplayfacebookads', 'hideBannerAds');
};





exports.distroyBannerAds = function (success, error) {
    exec(success, error, 'codeplayfacebookads', 'distroyBannerAds');
};

exports.loadInterstitialAds = function (arg0, success, error) {
    exec(success, error, 'codeplayfacebookads', 'loadInterstitialAds', [arg0]);
};

exports.showInterstitialAds = function (success, error) {
    exec(success, error, 'codeplayfacebookads', 'showInterstitialAds');
};

exports.loadRewardVideoAd = function (arg0,success, error) {
    exec(success, error, 'codeplayfacebookads', 'loadRewardVideoAd',[arg0]);
};

exports.showRewardVideoAd = function (success, error) {
    exec(success, error, 'codeplayfacebookads', 'showRewardVideoAd');
};

