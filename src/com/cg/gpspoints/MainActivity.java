package com.cg.gpspoints;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;

import android.location.Location;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.text.*;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements android.view.View.OnClickListener, 
													  GooglePlayServicesClient.ConnectionCallbacks,
													  GooglePlayServicesClient.OnConnectionFailedListener {
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	  Button btnGPS;
	  
	  LocationClient mLocationClient;

	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
	    // Check that Google Play services is available
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        // If Google Play services is available
        if (ConnectionResult.SUCCESS == resultCode) {
            // In debug mode, log the status
            Log.d("Location Updates",
                    "Google Play services is available.");
        }
        else
        	Toast.makeText(this, "Nu :(", Toast.LENGTH_LONG).show();

	    btnGPS = (Button) findViewById(R.id.btnGPS);

	    // set a listener
	    btnGPS.setOnClickListener(this);
	    
	    /*
         * Create a new location client, using the enclosing class to
         * handle callbacks.
         */
	    mLocationClient = new LocationClient(this, this, this);
	  }

	  
	  
	  @Override
	  public void onClick(View v) {
	     switch (v.getId()) {
	    
	    	case R.id.btnGPS:
	    		//Toast.makeText(this, "Am apasat", Toast.LENGTH_LONG).show();
	    		Location mCurrentLocation = mLocationClient.getLastLocation();
	    		Toast.makeText(this, "Aici lat: " + mCurrentLocation.getLatitude() + " long: " + mCurrentLocation.getLongitude(), Toast.LENGTH_LONG).show();
	    	default:	
	    }
	  }
	  
	  /*
	     * Called by Location Services when the request to connect the
	     * client finishes successfully. At this point, you can
	     * request the current location or start periodic updates
	     */
	  @Override
	    public void onConnected(Bundle dataBundle) {
	        // Display the connection status
	        Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();

	    }
	  
	  /*
	     * Called by Location Services if the connection to the
	     * location client drops because of an error.
	     */
	  @Override
	    public void onDisconnected() {
	        // Display the connection status
	        Toast.makeText(this, "Disconnected. Please re-connect.",
	                Toast.LENGTH_SHORT).show();
	    }
	  
	  /*
	     * Called by Location Services if the attempt to
	     * Location Services fails.
	     */
	  @Override
	    public void onConnectionFailed(ConnectionResult connectionResult) {
	  
	  }
	  
	  @Override
	    protected void onStart() {
	        super.onStart();
	        // Connect the client.
	        mLocationClient.connect();
	    }
	  
	  /*
	     * Called when the Activity is no longer visible.
	     */
	    @Override
	    protected void onStop() {
	        // Disconnecting the client invalidates it.
	        mLocationClient.disconnect();
	        super.onStop();
	    }
	  
	}
