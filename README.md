# react-native-direct-sms

## Getting started

`$ npm install react-native-direct-sms --save`

### Mostly automatic installation

`$ react-native link react-native-direct-sms`

## Usage
```javascript
import DirectSms from 'react-native-direct-sms';

DirectSms
.sendDirectSms('999...', 'This is a direct sms')
.then(()=>{
    console.log("sms sent");
})
.catch((e)=>{
    console.log("have a error", e);
})
 
```

## User Permission

```javascript
async function sendDirectSms(number, mensage) {
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
         const messageStatus =  await DirectSms.sendDirectSms(number, mensage);
        } else {
            console.log('SMS permission denied');
        }
    } catch (err) {
        console.warn(err);
    }
}

```
