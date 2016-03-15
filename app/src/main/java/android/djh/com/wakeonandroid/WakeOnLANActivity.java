package android.djh.com.wakeonandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.djh.udp.UDPBroadcastLoader;

import java.io.IOException;

public class WakeOnLANActivity extends Activity {

    // TODO Abstract these into configuration within Android preferences
    // http://developer.android.com/guide/topics/data/data-storage.html
    private static final String TARGET_IP_ADDRESS = "192.168.0.255";

    private static final String TARGET_MAC_ADDRESS = "10-BF-48-86-56-40";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wake_on_lan);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wake_on_lan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    public void sendWakeUpSignal(View v) throws IOException {

        // TODO Fix this
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // TODO Fix this bubbled exception
        UDPBroadcastLoader.sendMagicPacket(TARGET_IP_ADDRESS, TARGET_MAC_ADDRESS);
        Toast.makeText(this, "Wake Up Signal Has Been Sent", Toast.LENGTH_SHORT).show();

        ImageView imageView = (ImageView) findViewById(R.id.wakeStateImage);
        imageView.setImageResource(R.drawable.droid);
    }

}
