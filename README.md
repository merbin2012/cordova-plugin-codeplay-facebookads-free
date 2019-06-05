<h1>Code Play facebook audience network free ads</h1>

Developed  by <a target="_blank" href="https://play.google.com/store/apps/details?id=com.HTML.AngularJS.Codeplay">HTML Code Play</a> and this plugin is used for showing facebook audience network ads.

<h2>Git URL</h2>
https://github.com/merbin2012/cordova-plugin-codeplay-facebookads-free


<h2>Facebook Audience Network SDK version</h2>
I will try to keep the latest version, current version is com.facebook.android:audience-network-sdk:5.+


<h2>How to Instalation?</h2>
<h4>Using the Cordova CLI</h4>
<blockquote>
  $ cordova plugin add cordova-plugin-codeplay-facebookads-free
</blockquote>


<h4>Using the phonegap CLI</h4>
<blockquote>
  $ phonegap local plugin add cordova-plugin-codeplay-facebookads-free
</blockquote>

<h2>How to Uninstall?</h2>
<h4>Using the Cordova CLI</h4>
<blockquote>
  $ cordova plugin rm cordova-plugin-codeplay-facebookads-free
</blockquote>

<h4>Using the phonegap CLI</h4>
<blockquote>
  $ phonegap local plugin rm cordova-plugin-codeplay-facebookads-free
</blockquote>

<h2>Methods 1</h2>
<h3>Show Banner Ads</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.showBannerAds(options,success,fail)
```

<h4>Options</h4>

```javascript
var options={
bannerid:"523519301434xxx_xxxxxxxxxxxxxxx"
,isTesting:true|false
}
```

<h4>Example</h4>

```javascript
var options={
bannerid:"523519301434xxx_xxxxxxxxxxxxxxx"
,isTesting:true
};

cordova.plugins.codeplayfacebookads.showBannerAds(options,success,fail);

function success(result)
{
 console.log(result);
}
function fail(result)
{
 console.log(result);
}
```

  

<h4>Screenshot</h4>
<p  align="center">
  <img src="https://4.bp.blogspot.com/-T-9Se64wMXE/XPTc1DCv3rI/AAAAAAAAPcE/C5sAXRllwO0JtdbUUL4CKSKwshwfGFj2wCLcBGAs/s1600/1.png" width="350" alt="Facebook banner ads">
</p>





<h2>Methods 2</h2>
<h3>Hide Banner Ads</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.hideBannerAds("",success,fail);

function success(result)
{
 console.log(result);
}
function fail(result)
{
 console.log(result);
}
```

  

<h4>Screenshot</h4>
<p  align="center">
  <img src="https://2.bp.blogspot.com/-pE3cKxZ3uDA/XPTc1FDLcgI/AAAAAAAAPcA/q_d55Dk1HTcBeZaDB0x3W52_QbVyliubwCLcBGAs/s1600/2.png" width="350" alt="Hide facebook banner ads">
</p>




<h2>Methods 3</h2>
<h3>Load interstitial ads</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.loadInterstitialAds(options,success,fail);
```

<h4>Options</h4>

```javascript
var options={
interstitialid:"52351930143xxx_xxxxxxxxxxxxxxx"
,isTesting:true|false
}
```


<h4>Example</h4>

```javascript
var options={
interstitialid:"52351930143xxx_xxxxxxxxxxxxxxx"
,isTesting:true
};

cordova.plugins.codeplayfacebookads.loadInterstitialAds(options,success,fail);

function success(result)
{
 console.log(result);
}
function fail(result)
{
 console.log(result);
}
```



<h2>Methods 4</h2>
<h3>Show interstitial ads</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.showInterstitialAds("",success,fail);
```



<h4>Example</h4>

```javascript
cordova.plugins.codeplayfacebookads.showInterstitialAds("",success,fail);

function success(result)
{
 console.log(result);
}
function fail(result)
{
 console.log(result);
}
```






<h4>Screenshot</h4>
<p  align="center">
  <img src="https://1.bp.blogspot.com/-2b3g7OSzTqk/XPTc1U-FYZI/AAAAAAAAPcI/2IJN-wkYgWoWr75vNOhv5RjPTYhxfDR6wCLcBGAs/s1600/3.png" width="350" alt="Facebook Interstitial">
</p>





<h2>Methods 5</h2>
<h3>Load Video ads</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.loadRewardVideoAd(options,success,fail);
```

<h4>Options</h4>

```javascript
var options={
videoid:"52351930143xxx_xxxxxxxxxxxxxxx"
,isTesting:true|false
}
```


<h4>Example</h4>

```javascript
var options={
videoid:"52351930143xxx_xxxxxxxxxxxxxxx"
,isTesting:true
};

cordova.plugins.codeplayfacebookads.loadRewardVideoAd(options,success,fail);

function success(result)
{
 console.log(result);
}
function fail(result)
{
 console.log(result);
}
```


Important Note : If you get the following error "Rewarded video ad failed to load: The display format in the ad request does not match the display format specified for this placement. Each placement can only be used with a single display format. You can create multiple placements in order to use multiple display formats.", please follow the steps to resolve the issue.
1) You must have the Audience Network SDK integrated in your game
2) Your app must have an active, approved Audience Network account with payment information.
3) Game only: Your game app is active and added to your account.
4) Ad position: You must already have a rewarded video ad unit in your game.
Reference : https://stackoverflow.com/questions/50532615/facebook-rewarded-video-ad-failed-to-load




<h2>Methods 6</h2>
<h3>Show Video ads</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.showRewardVideoAd("",success,fail);
```


<h4>Example</h4>

```javascript
cordova.plugins.codeplayfacebookads.showRewardVideoAd("",options,success,fail);

function success(result)
{
 console.log(result);
}
function fail(result)
{
 console.log(result);
}
```












<h2>Support Platfrom</h2>
<ul>
<li>Android</li>
</ul>

<h2>Our Apps</h2>
https://play.google.com/store/apps/details?id=com.HTML.AngularJS.Codeplay

https://play.google.com/store/apps/details?id=sql.code.play

https://play.google.com/store/apps/details?id=html.editor.codeplay

https://play.google.com/store/apps/details?id=php.code.play

https://play.google.com/store/apps/details?id=cordova.code.play

https://play.google.com/store/apps/details?id=com.kids.learning.master

