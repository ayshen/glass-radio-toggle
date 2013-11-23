package edu.self;

import android.content.Context;
import android.bluetooth.BluetoothAdapter;


public class BluetoothController implements RadioController {

    private final BluetoothAdapter m_btmgr;

    public BluetoothController(Context context) {
        m_btmgr = BluetoothAdapter.getDefaultAdapter();
    }

    public void on() {
        m_btmgr.enable();
    }

    public void off() {
        m_btmgr.disable();
    }
}
