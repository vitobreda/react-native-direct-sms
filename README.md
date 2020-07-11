# react-native-direct-sms

## Getting started

`$ npm install react-native-direct-sms --save`

### Mostly automatic installation

`$ react-native link react-native-direct-sms`

## Usage
```javascript
import DirectSms from 'react-native-direct-sms';

DirectSms.sendDirectSms('999...', 'This is a direct sms');
 
```

## User Permission

```javascript
function sendDirectSms() {
    try {
        const granted = await PermissionsAndroid.request(
        PermissionsAndroid.PERMISSIONS.SEND_SMS,
            {
                title: 'App Sms Permission',
                message:
                'App needs access to your inbox         ' +
                'so you can send messages in background.',
                buttonNeutral: 'Ask Me Later',
                buttonNegative: 'Cancel',
                buttonPositive: 'OK',
            },
        );
        if (granted === PermissionsAndroid.RESULTS.GRANTED) {
            DirectSms.sendDirectSms('0935...', 'This is a direct message');
        } else {
            console.log('SMS permission denied');
        }
    } catch (err) {
        console.warn(err);
    }
}

```
