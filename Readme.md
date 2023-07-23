# react-native-light

`react-native-light` is a lightweight and easy-to-use React Native module for controlling the flashlight on both iPhone and Android devices. This module allows you to integrate flashlight functionality into your React Native applications with just a few lines of code.

## Features

- Toggle the flashlight on/off with a simple function call
- Works on both iOS and Android devices

## Installation

To use `react-native-light` in your React Native project, follow these steps:

1. Install the package using npm or yarn:

```bash
npm install react-native-light
```

or

```bash
yarn add react-native-light
```

2. Link the native module on IOS (New Architecture):

```bash
RCT_NEW_ARCH_ENABLED=1 bundle exec pod install
```

3. For iOS, ensure that the flashlight usage description is added to your Info.plist file. Open `Info.plist` and add the following lines:

```xml
<key>NSCameraUsageDescription</key>
<string>Allow access to the flashlight for torch functionality</string>
```

## Usage

1. Import the module:

```javascript
import Light from 'react-native-light';
```

2. Toggle the flashlight on:

```javascript
Light.switchOn();
```

3. Toggle the flashlight off:

```javascript
Light.switchOff();
```

## Example

Here's a simple example of how to use `react-native-light` in your React Native component:

```javascript
import React from 'react';
import { View, Button } from 'react-native';
import Light from 'rtn-light/js/NativeLight';

const FlashlightScreen = () => {
  const turnOnFlashlight = () => {
    Light.switchOn();
  };

  const turnOffFlashlight = () => {
    Light.switchOff();
  };

  return (
    <View>
      <Button title="Switch on" onPress={turnOnFlashlight} />
      <Button title="Switch off" onPress={turnOffFlashlight} />
    </View>
  );
};

export default FlashlightScreen;
```

## Troubleshooting

## Contributions

Contributions are welcome! If you have any suggestions, bug fixes, or additional features you'd like to see, feel free to create an issue or submit a pull request.

## License

`react-native-light` is open-source software licensed under the [MIT License](https://opensource.org/licenses/MIT).

---

Happy flashlight controlling! If you find `react-native-light` useful, consider giving it a star on GitHub and sharing it with others. If you have any questions or need further assistance, don't hesitate to reach out. Thank you for using `react-native-light`! 🚀
