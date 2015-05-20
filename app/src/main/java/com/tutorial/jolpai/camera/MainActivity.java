package com.tutorial.jolpai.camera;



import android.hardware.Camera;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    static Camera camera = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isCameraUsebyApp();

    }

    public boolean isCameraUsebyApp() {

        try {
            camera = Camera.open();
            Log.e("Camera", "It was Off");
            Toast.makeText(this, "Now On", Toast.LENGTH_SHORT).show();
        } catch (RuntimeException e) {
            Toast.makeText(this, "Now Off", Toast.LENGTH_SHORT).show();
            return true;
        } finally {
            if (camera != null) camera.release();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
