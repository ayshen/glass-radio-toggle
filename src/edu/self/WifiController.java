package edu.self;

import android.content.Context;
import android.net.wifi.WifiManager;


public class WifiController implements RadioController {

    private final WifiManager m_wfmgr;

    public WifiController(Context context) {
        m_wfmgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    public void on() {
        m_wfmgr.setWifiEnabled(true);
    }

    public void off() {
        m_wfmgr.setWifiEnabled(false);
    }

}
