package edu.self;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;


public class RadioTogglesActivity extends Activity {

    private final static String DOT = "\\.";

    private final static String ACTION_ON = "On";
    private final static String ACTION_OFF = "Off";

    private final static String TARGET_WIFI = "Wifi";
    private final static String TARGET_BLUETOOTH = "Bluetooth";
    private final static String TARGET_AIRPLANEMODE = "AirplaneMode";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String cmd = getIntent().getComponent().getClassName();
        if(cmd.startsWith(getClass().getName()))
            run(cmd.substring(getClass().getName().length() + 1));

        finish();
    }

    private void run(String cmd) {
        String[] tokens = cmd.split(DOT);

        if(tokens.length != 2)
            return;

        Boolean isEnable = null;
        if(tokens[0].equals(ACTION_ON)) isEnable = new Boolean(true);
        else if(tokens[0].equals(ACTION_OFF)) isEnable = new Boolean(false);

        if(isEnable == null)
            return;

        String[] targetDisplayNames = new String[] {
                this.getString(R.string.target_wf),
                this.getString(R.string.target_bt),
                this.getString(R.string.target_air)
        };

        RadioController ctl = null;
        String targetName = null;
        if(tokens[1].equals(TARGET_WIFI)) {
            ctl = new WifiController(this);
            targetName = targetDisplayNames[0];
        }
        else if(tokens[1].equals(TARGET_BLUETOOTH)) {
            ctl = new BluetoothController(this);
            targetName = targetDisplayNames[1];
        }
        else if(tokens[1].equals(TARGET_AIRPLANEMODE)) {
            ctl = new AirplaneModeController(this);
            targetName = targetDisplayNames[2];
        }

        if(ctl == null)
            return;

        if(isEnable.booleanValue()) {
            ctl.on();
            Toast.makeText(this,
                    targetName + " " + this.getString(R.string.is_on),
                    Toast.LENGTH_SHORT).show();
        }
        else {
            ctl.off();
            Toast.makeText(this,
                    targetName + " " + this.getString(R.string.is_off),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
