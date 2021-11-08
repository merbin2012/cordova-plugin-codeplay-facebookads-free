<h1>Code Play facebook audience network free ads</h1>

Developed  by <a target="_blank" href="https://play.google.com/store/apps/details?id=com.HTML.AngularJS.Codeplay">HTML Code Play</a> and this plugin is used for showing facebook audience network ads.

<h2>Git URL</h2>
https://github.com/merbin2012/cordova-plugin-codeplay-facebookads-free


<h2>Facebook Audience Network SDK version</h2>
I will try to keep the latest version, current version is 'com.facebook.android:audience-network-sdk:6.+'


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
<h3>Load and immediately show Banner Ads.</h3>
<p>Note: Strongly recommended  you to use <b>loadAndShowBannerAds</b> for banner ads instead of loading, showing, hiding separately.</p>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.loadAndShowBannerAds(options,bannerSuccess,bannerFail);
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

cordova.plugins.codeplayfacebookads.loadAndShowBannerAds(options,bannerSuccess,bannerFail);

function bannerSuccess(evt)
{

  if(evt === "AdLoaded"){
     console.log("Facebook AdLoaded");
  }
  else if(evt === "AdClicked"){
     console.log("Facebook AdClicked");
  }
  else if(evt === "AdImpression"){
     console.log("Facebook AdImpression");
  }
  else if(evt === "AdDistroyed"){
	console.log("Facebook banner AdDistroyed");
  }  
  else if(evt === "AdHidden"){
     console.log("Facebook AdHidden");
  }  
  
}
function bannerFail(result)
{
 console.log(result);
}
```

  

<h4>Screenshot</h4>
<p  align="center">
  <img src="https://4.bp.blogspot.com/-T-9Se64wMXE/XPTc1DCv3rI/AAAAAAAAPcE/C5sAXRllwO0JtdbUUL4CKSKwshwfGFj2wCLcBGAs/s1600/1.png" width="350" alt="Facebook banner ads">
</p>







<h2>Methods 2</h2>
<h3>Load only Banner Ads</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.loadBannerAds(options,bannerSuccess,bannerFail);
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

cordova.plugins.codeplayfacebookads.loadBannerAds(options,bannerSuccess,bannerFail);

function bannerSuccess(evt)
{

  if(evt === "AdLoaded"){
     console.log("Facebook AdLoaded");
  }
  else if(evt === "AdClicked"){
     console.log("Facebook AdClicked");
  }
  else if(evt === "AdImpression"){
     console.log("Facebook AdImpression");
  }
  else if(evt === "AdDistroyed"){
	console.log("Facebook banner AdDistroyed");
  }   
  else if(evt === "AdHidden"){
     console.log("Facebook AdHidden");
  }  
  
}
function bannerFail(result)
{
 console.log(result);
}
```










<h2>Methods 3</h2>
<h3>Show banner ad after load the banner Ad</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.showBannerAds(bannerSuccess,bannerFail);
```


<h4>Example</h4>

```javascript

cordova.plugins.codeplayfacebookads.showBannerAds(bannerSuccess,bannerFail);

function bannerSuccess(evt)
{

  if(evt === "AdLoaded"){
     console.log("Facebook AdLoaded");
  }
  else if(evt === "AdClicked"){
     console.log("Facebook AdClicked");
  }
  else if(evt === "AdImpression"){
     console.log("Facebook AdImpression");
  }
  else if(evt === "AdDistroyed"){
	console.log("Facebook banner AdDistroyed");
  }  
  else if(evt === "AdHidden"){
     console.log("Facebook AdHidden");
  }  
  
}
function bannerFail(result)
{
 console.log(result);
}
```




















<h2>Methods 4</h2>
<h3>Hide/distroy Banner Ads</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.distroyBannerAds(bannerSuccess,bannerFail);

function bannerSuccess(evt)
{

  if(evt === "AdLoaded"){
     console.log("Facebook AdLoaded");
  }
  else if(evt === "AdClicked"){
     console.log("Facebook AdClicked");
  }
  else if(evt === "AdImpression"){
     console.log("Facebook AdImpression");
  }
  else if(evt === "AdDistroyed"){
     console.log("Facebook AdDistroyed");
  }  
  
}
function bannerFail(result)
{
 console.log(result);
}
```

  

<h4>Screenshot</h4>
<p  align="center">
  <img src="https://2.bp.blogspot.com/-pE3cKxZ3uDA/XPTc1FDLcgI/AAAAAAAAPcA/q_d55Dk1HTcBeZaDB0x3W52_QbVyliubwCLcBGAs/s1600/2.png" width="350" alt="Hide facebook banner ads">
</p>




<h2>Methods 5</h2>
<h3>Load interstitial ads</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.loadInterstitialAds(options,interstitialSuccess,interstitialFail);
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

cordova.plugins.codeplayfacebookads.loadInterstitialAds(options,interstitialSuccess,interstitialFail);

function interstitialSuccess(evt)
{

  if(evt === "AdDisplayed"){
     console.log("Facebook AdDisplayed");
  }
  else if(evt === "AdClosed"){
     console.log("Facebook AdClosed");
  }
  else if(evt === "AdLoaded"){
     console.log("Facebook AdLoaded");
  }
  else if(evt === "AdClicked"){
     console.log("Facebook AdClicked");
  }
  else if(evt === "AdImpression"){
     console.log("Facebook AdImpression");
  }
}
function interstitialFail(result)
{
 console.log(result);
}
```



<h2>Methods 6</h2>
<h3>Show interstitial ads</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.showInterstitialAds(interstitialSuccess,interstitialFail);
```



<h4>Example</h4>

```javascript
cordova.plugins.codeplayfacebookads.showInterstitialAds(interstitialSuccess,interstitialFail);

function interstitialSuccess(evt)
{

  if(evt === "AdDisplayed"){
     console.log("Facebook AdDisplayed");
  }
  else if(evt === "AdClosed"){
     console.log("Facebook AdClosed");
  }
  else if(evt === "AdLoaded"){
     console.log("Facebook AdLoaded");
  }
  else if(evt === "AdClicked"){
     console.log("Facebook AdClicked");
  }
  else if(evt === "AdImpression"){
     console.log("Facebook AdImpression");
  }
}
function interstitialFail(result)
{
 console.log(result);
}
```






<h4>Screenshot</h4>
<p  align="center">
  <img src="https://1.bp.blogspot.com/-2b3g7OSzTqk/XPTc1U-FYZI/AAAAAAAAPcI/2IJN-wkYgWoWr75vNOhv5RjPTYhxfDR6wCLcBGAs/s1600/3.png" width="350" alt="Facebook Interstitial">
</p>





<h2>Methods 7</h2>
<h3>Load Video ads</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.loadRewardVideoAd(options,videoRewardSuccess,videoRewardFail);
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

cordova.plugins.codeplayfacebookads.loadRewardVideoAd(options,videoRewardSuccess,videoRewardFail);

function videoRewardSuccess(evt)
{

  if(evt === "AdLoaded"){
     console.log("Facebook AdLoaded");
  }
  else if(evt === "AdClicked"){
     console.log("Facebook AdClicked");
  }
  else if(evt === "AdPlaying"){
     console.log("Facebook AdPlaying");
  }
  else if(evt === "AdCompleted"){
     console.log("Facebook AdCompleted");
  }
  else if(evt === "AdClosed"){
     console.log("Facebook AdClosed");
  }
}
function videoRewardFail(result)
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




<h2>Methods 8</h2>
<h3>Show Video ads</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplayfacebookads.showRewardVideoAd(videoRewardSuccess,videoRewardFail);
```


<h4>Example</h4>

```javascript
cordova.plugins.codeplayfacebookads.showRewardVideoAd(videoRewardSuccess,videoRewardFail);

function videoRewardSuccess(evt)
{

  if(evt === "AdLoaded"){
     console.log("Facebook AdLoaded");
  }
  else if(evt === "AdClicked"){
     console.log("Facebook AdClicked");
  }
  else if(evt === "AdPlaying"){
     console.log("Facebook AdPlaying");
  }
  else if(evt === "AdCompleted"){
     console.log("Facebook AdCompleted");
  }
  else if(evt === "AdClosed"){
     console.log("Facebook AdClosed");
  }
}
function videoRewardFail(result)
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

