package edu.self;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;


public class RadioTogglesActivity extends Activity
        implements CompoundButton.OnCheckedChangeListener {


    private Switch wifiToggle = null;
    private Switch bluetoothToggle = null;


    private WifiManager wfmgr = null;
    private BluetoothAdapter btmgr = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        wifiToggle = (Switch)findViewById(android.R.id.button1);
        bluetoothToggle = (Switch)findViewById(android.R.id.button2);

        wfmgr = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        btmgr = BluetoothAdapter.getDefaultAdapter();

        if(wfmgr.isWifiEnabled())
            wifiToggle.setChecked(true);
        if(btmgr.isEnabled())
            bluetoothToggle.setChecked(true);

        wifiToggle.setOnCheckedChangeListener(this);
        bluetoothToggle.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton button, boolean checked) {
        if(button == wifiToggle) {
            wfmgr.setWifiEnabled(checked);
        }
        else if(button == bluetoothToggle) {
            if(checked) btmgr.enable();
            else btmgr.disable();
        }
    }
}
