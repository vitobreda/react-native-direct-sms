import React from 'react';
import { NativeModules } from 'react-native'
var DirectSms = NativeModules.DirectSms;

export default async function(Number, Message) {
    await sendDirectSms() {
        DirectSms.sendDirectSms(Number, Message);
    }
}
