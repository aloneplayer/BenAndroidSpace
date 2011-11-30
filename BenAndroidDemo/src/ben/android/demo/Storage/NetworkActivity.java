package ben.android.demo.Storage;

import java.net.URI;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;

public class NetworkActivity extends Activity
{
	private String Request(String url)
	{
		HttpClient httpClient = new DefaultHttpClient();
		//????URI uri = URIUtils.createURI("http", url, -1, null, null, null);
		//????HttpGet get = new HttpGet(uri);
		ResponseHandler<String> rh = new BasicResponseHandler();
		//?????String content = new String(httpClient.execute().getBytes());
		
		return null;
	}
}
