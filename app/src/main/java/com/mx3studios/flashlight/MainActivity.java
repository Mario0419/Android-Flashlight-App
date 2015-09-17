package com.mx3studios.flashlight;

import android.content.Context;
import android.hardware.Camera;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.hardware.Camera.*;
import android.widget.ImageButton;

import java.lang.reflect.ParameterizedType;
import java.security.Policy;

public class MainActivity extends ActionBarActivity {

    private Button mFlashlightButton;
    private ImageButton mFlashLight;
    private Camera mCamera;
    private boolean isOn;
    private Parameters mParameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isOn = false;
        mCamera = Camera.open();
        mParameters = mCamera.getParameters();
//        mFlashlightButton = (Button)findViewById(R.id.button_flashlight);
        mFlashLight = (ImageButton)findViewById(R.id.button_flashlight2);

//       

        mFlashLight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if(!isOn){

                    mParameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
                    mCamera.setParameters(mParameters);
                    mCamera.startPreview();
                    isOn = !isOn;
                }else{
                    mParameters.setFlashMode(Parameters.FLASH_MODE_OFF);
                    mCamera.setParameters(mParameters);
                    mCamera.startPreview();
                    isOn = !isOn;
                }
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(mCamera == null){
            mCamera = Camera.open();
            mParameters = mCamera.getParameters();
        }else{

        }
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        if(mCamera == null){
            mCamera = Camera.open();
            mParameters = mCamera.getParameters();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();

    }
    @Override
    protected void onStop(){
        super.onStop();
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
