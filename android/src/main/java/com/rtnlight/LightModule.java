package com.rtnlight;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraCharacteristics;

public class LightModule extends NativeLightSpec {

        public static String NAME = "RTNLight";

    private final ReactApplicationContext context;

    LightModule(ReactApplicationContext context) {
        super(context);
        this.context = context;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    private boolean isFlashSupported() {
        PackageManager pm = context.getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public void isFlashActive(Promise promise) {
        try {
            CameraManager camManager = (CameraManager) context.getSystemService(context.CAMERA_SERVICE);
            String cameraId = camManager.getCameraIdList()[0];
            promise.resolve(camManager.getCameraCharacteristics(cameraId));
        } catch (Exception e) {
//             promise.reject("FLASH_ERROR", e.getMessage());
            promise.reject("FLASH_ERROR");
        }
    }

    @ReactMethod
    public void switchOn() {
        toggleFlash(true);
    }

    @ReactMethod
    public void switchOff() {
        toggleFlash(false);
    }

    private void toggleFlash(boolean enable) {
        try {
            CameraManager camManager = (CameraManager) context.getSystemService(context.CAMERA_SERVICE);
            String cameraId = camManager.getCameraIdList()[0];
            camManager.setTorchMode(cameraId, enable);
            sendEvent(context, enable ? "onSwitchOn" : "onSwitchOff");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendEvent(ReactContext reactContext, String eventName) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, null);
    }
}
