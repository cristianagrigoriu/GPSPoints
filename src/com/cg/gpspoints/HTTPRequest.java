package com.cg.gpspoints;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class HTTPRequest extends AsyncTask<Double, Void, String> {
	
    @Override
    protected String doInBackground(Double... arg) {
    	
        Double latitude = arg[0]; // Added this line
        Double longitude = arg[1];

        //Toast.makeText(, "Aici lat: " + latitude + " long: " + longitude, Toast.LENGTH_LONG).show();
        Log.d("Am intrat in HTTPR", "Aici lat: " + latitude + " long: " + longitude);
        
        // Cria o cliente de conexão
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://students.info.uaic.ro/~cristiana.grigoriu/myWay/points/GPSPoints.php");

        Log.d("Am facut clientul in HTTPR", "Aici lat: " + latitude + " long: " + longitude);
        
        try {
	  		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
	  		pairs.add(new BasicNameValuePair("lat", latitude.toString()));
	  		pairs.add(new BasicNameValuePair("long", longitude.toString()));
	  		post.setEntity(new UrlEncodedFormEntity(pairs));
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
        
        Log.d("Am setat pairs in HTTPR", "Aici lat: " + latitude + " long: " + longitude);
        
		try {
			/*HttpResponse response = */client.execute(post);
		}
		catch (ClientProtocolException e) {
			e.printStackTrace();
			return null;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		Log.d("Am trimis in HTTPR", "Aici lat: " + latitude + " long: " + longitude);
		
        return null; // This value will be returned to your onPostExecute(result) method
    }

    @Override
    protected void onPostExecute(String result) {
        
    }
}
