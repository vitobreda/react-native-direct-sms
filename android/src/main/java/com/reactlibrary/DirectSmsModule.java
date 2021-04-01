package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import com.facebook.react.uimanager.IllegalViewOperationException;
import android.telephony.SmsManager;
 
public class DirectSmsModule extends ReactContextBaseJavaModule {
 
    public DirectSmsModule(ReactApplicationContext reactContext) {
        super(reactContext); //required by React Native
    }
 
    @Override
    //getName is required to define the name of the module represented in JavaScript
    public String getName() { 
        return "DirectSms";
    }
 
    @ReactMethod
    public void sendDirectSms(String phoneNumber, String msg, Promise promise) {
        try {      
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, msg, null, null);    
            promise.resolve("sms sent");
        } catch (Exception e) {
            promise.reject("Error to send sms ", e);
        } 
    }
}