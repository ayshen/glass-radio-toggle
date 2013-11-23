package edu.self;

import android.content.Context;


public class AirplaneModeController implements RadioController {

    private final BluetoothController m_btctl;
    private final WifiController m_wfctl;

    public AirplaneModeController(Context context) {
        m_btctl = new BluetoothController(context);
        m_wfctl = new WifiController(context);
    }

    public void on() {
        m_btctl.off();
        m_wfctl.off();
    }

    public void off() {
        m_btctl.on();
        m_wfctl.on();
    }

}
