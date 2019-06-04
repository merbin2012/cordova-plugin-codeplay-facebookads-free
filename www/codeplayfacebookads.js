var exec = require('cordova/exec');

exports.showBannerAds = function (arg0, success, error) {
    exec(success, error, 'codeplayfacebookads', 'showBannerAds',[arg0]);
};


exports.hideBannerAds = function (success, error) {
    exec(success, error, 'codeplayfacebookads', 'hideBannerAds');
};

exports.loadInterstitialAds = function (arg0, success, error) {
    exec(success, error, 'codeplayfacebookads', 'loadInterstitialAds', [arg0]);
};

exports.showInterstitialAds = function (success, error) {
    exec(success, error, 'codeplayfacebookads', 'showInterstitialAds');
};