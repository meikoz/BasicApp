package com.dintech.api.bleep.utils;

import com.dintech.api.bleep.BluetoothKit;

public class ResourceUtil {

    public static String getString(int stringId) {
        return BluetoothKit.getConfigurations().getApplication().getResources().getString(stringId);
    }
}