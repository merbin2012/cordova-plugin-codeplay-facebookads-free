var exec = require('cordova/exec');

exports.showBannerAds = function (arg0, success, error) {
    exec(success, error, 'codeplayfacebookads', 'showBannerAds',[{
        bannerid: '523519301434699_610920452694583',
        isTesting: true,
    }]);
};


exports.hideBannerAds = function (success, error) {
    exec(success, error, 'codeplayfacebookads', 'hideBannerAds');
};


exports.showInterstitialAds = function (arg0, success, error) {
    exec(success, error, 'codeplayfacebookads', 'showInterstitialAds', [{
        interstitialid: '523519301434699_610920006027961',
        isTesting: true,
    }]);
};