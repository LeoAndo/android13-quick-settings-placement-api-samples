# Overview
Sample for Quick Settings placement API(Android 13+)<br>

Using a new [tile placement API](https://developer.android.com/reference/android/app/StatusBarManager#requestAddTileService(android.content.ComponentName,%20java.lang.CharSequence,%20android.graphics.drawable.Icon,%20java.util.concurrent.Executor,%20java.util.function.Consumer%3Cjava.lang.Integer%3E)), your app can now prompt the user to directly add your custom tile to the set of active Quick Settings tiles.<br>
[about Quick Settings placement API](https://developer.android.com/about/versions/13/features#quick-settings)<br>
[about TileService API](https://developer.android.com/reference/android/service/quicksettings/TileService)<br>

# dev memo

[RequestResult not found!!](https://developer.android.com/reference/android/app/StatusBarManager.RequestResult)<br>
[use constants](https://github.com/LeoAndo/android-quick-settings-placement-api-samples/blob/main/TileServiceKotlinSample/app/src/main/java/com/example/tileservicekotlinsample/RequestResult.kt#L6:L14)

# [For Kotlin](https://github.com/LeoAndo/android-quick-settings-placement-api-samples/tree/main/TileServiceKotlinSample)
- material3

# [For Java](https://github.com/LeoAndo/android-quick-settings-placement-api-samples/tree/main/TileServiceJavaSample)
- material2

# capture Pixel 4 API Level Tiramisu

| [startService(API Level 1)](https://developer.android.com/reference/android/content/Context?hl=ja#startService(android.content.Intent)) | [requestAddTileService(API Level Tiramisu)](https://developer.android.com/reference/android/app/StatusBarManager#requestAddTileService(android.content.ComponentName,%20java.lang.CharSequence,%20android.graphics.drawable.Icon,%20java.util.concurrent.Executor,%20java.util.function.Consumer%3Cjava.lang.Integer%3E)) |
|:---|:---:|
|<img src="https://github.com/LeoAndo/android-quick-settings-placement-api-samples/blob/main/capture_startTileService.gif" width=320 /> |<img src="https://github.com/LeoAndo/android-quick-settings-placement-api-samples/blob/main/capture_requestAddTileService.gif" width=320 /> |
