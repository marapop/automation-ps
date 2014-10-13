package a.tools.alfresco;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class ApacheHttpHelper {

	private static DefaultHttpClient httpClient = new DefaultHttpClient();
	private Credentials credentials = new UsernamePasswordCredentials(Constants.ALFRESCO_USER_LOGIN, Constants.ALFRESCO_PASS_LOGIN);

	public ApacheHttpHelper() {
		super();
		httpClient.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
	}

	// set credentials
	public void setUserNameAndPassword(String userName, String password) {
		credentials = new UsernamePasswordCredentials(userName, password);
	}

	// HTTP GET request
	public String sendGet(String url) throws Exception {
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", Constants.USER_AGENT);
		request.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");

		return executeRequest(request);

	}

	// HTTP POST request
	public String sendPost(String url, String requestBody) throws Exception {
		HttpPost post = new HttpPost(url);

		System.out.println("Sending POST request to: " + url);
		System.out.println("requestBody:" + requestBody);

		// add header
		post.setHeader("User-Agent", Constants.USER_AGENT);
		post.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		post.setHeader("Content-Type", "application/json; charset=UTF-8");
		post.setEntity(new StringEntity(requestBody));

		return executeRequest(post);

	}

	// HTTP DELETE request
	public String sendDelete(String url) throws Exception {
		HttpDelete request = new HttpDelete(url);
		// add request header
		request.addHeader("User-Agent", Constants.USER_AGENT);
		return executeRequest(request);
	}

	// upload document
	public String uploadDocument(String url, File fileobj, String site, String container, String path) throws ClientProtocolException, IOException {

		HttpPost post = new HttpPost(url);
		System.out.println("Sending UPLOAD request to: " + url);

		// add header
		post.setHeader("User-Agent", Constants.USER_AGENT);
		post.setHeader("Accept", "application/json");

		MultipartEntity mpe = new MultipartEntity();
		FileBody fileBody = new FileBody(fileobj, "application/octect-stream");
		mpe.addPart("filedata", fileBody);
		mpe.addPart("siteid", new StringBody(site));
		mpe.addPart("containerid", new StringBody(container));
		mpe.addPart("uploaddirectory", new StringBody(path));
		post.setEntity(mpe);

		return executeRequest(post);
	}

	// execute http request
	private String executeRequest(HttpUriRequest request) throws ClientProtocolException, IOException {
		HttpResponse response = httpClient.execute(request);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		if (response.getStatusLine().getStatusCode() < 200 || response.getStatusLine().getStatusCode() >= 400) {
			System.out.println("Execute request got BAD RESPONSE: " + result.toString());
			throw new IOException("Got bad response, error code = " + response.getStatusLine().getStatusCode());
		}

		return result.toString();
	}

}
