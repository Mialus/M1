package ufc.deptinfo.bt;

import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.IOException ;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class HttpClientGet extends Activity {
	private static final String LOG_TAG = "HttpClientGET";

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		HttpPage tacheHttpPage = new HttpPage() ;
		tacheHttpPage.execute() ;
	}

	private String getPage(String adresse) {
		StringBuffer stringBuffer = new StringBuffer("");
		BufferedReader bufferedReader = null;
		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet();

			URI uri = new URI(adresse);
			httpGet.setURI(uri);

			HttpResponse httpResponse = httpClient.execute(httpGet);
			InputStream inputStream = httpResponse.getEntity().getContent();
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			String ligneLue = bufferedReader.readLine();
			while (ligneLue != null) {
				stringBuffer.append(ligneLue);
				stringBuffer.append("\n");
				ligneLue = bufferedReader.readLine();
			}
		} catch (Exception e) {
			Log.e(LOG_TAG, e.getMessage());
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					Log.e(LOG_TAG, e.getMessage());
				}
			}
		}
		return stringBuffer.toString();
	}
	
	private class HttpPage extends AsyncTask<Void, Void, Void> {
		String page ;
    	@Override
    	protected Void doInBackground (Void... params) {
    		page = getPage("http://www.lemonde.fr/rss/tag/enseignement-superieur.xml") ;   		
			return null;
    	}
    	@Override
    	protected void onPostExecute (Void result) {
    		Log.i(LOG_TAG, page);
    	}
    }
}