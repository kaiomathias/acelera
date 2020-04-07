package com.codenation.kaio.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HttpClient {

	private String charset;
	private String boundary;
	private static final String LINE_FEED = "\r\n";
	private HttpsURLConnection httpConn;
	private OutputStream outputStream;
	private PrintWriter writer;

	public HttpClient(String requestURL, String charset) throws IOException {
		this.boundary = "";
		this.charset = charset;
		boundary = "===" + System.currentTimeMillis() + "===";
		URL url = new URL(requestURL);
		httpConn = (HttpsURLConnection) url.openConnection();
		httpConn.setUseCaches(false);
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		httpConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
		outputStream = httpConn.getOutputStream();
		writer = new PrintWriter(new OutputStreamWriter(outputStream, charset), true);
	}

	public HttpClient() {
		this.boundary = "";
		// TODO Auto-generated constructor stub
	}

	public void addFilePart(String fieldName, File uploadFile) throws IOException {
		String fileName = uploadFile.getName();
		writer.append("--" + boundary).append(LINE_FEED);
		writer.append("Content-Disposition: form-data; name=\"" + fieldName + "\"; filenamme=\"" + fileName + "\"")
				.append(LINE_FEED);
		writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
		writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
		writer.append(LINE_FEED);
		writer.flush();

		FileInputStream inputStream = new FileInputStream(uploadFile);
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}

		outputStream.flush();
		inputStream.close();

		writer.append(LINE_FEED);
		writer.flush();
	}

	public void addHeaderFields(String name, String value) {
		writer.append(name + ": " + value).append(LINE_FEED);
		writer.flush();
	}

	public List<String> finish() throws IOException {
		List<String> response = new ArrayList<String>();
		writer.append(LINE_FEED).flush();
		writer.append("--" + boundary + "--").append(LINE_FEED);
		writer.close();

		int status = httpConn.getResponseCode();
		BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
		String line = null;
		System.out.println(status);
		while ((line = reader.readLine()) != null) {
			response.add(line);
			System.out.println(line);
		}

		reader.close();
		httpConn.disconnect();

		return response;

	}

	public JSONObject getMethod()
			throws ClientProtocolException, IOException, ParseException, org.json.simple.parser.ParseException {
		JSONParser parser = new JSONParser();
		JSONObject answer = new JSONObject();

		CloseableHttpClient httpCliente = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(
				"https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=2ede92a2afff7a8461977ae2f64c9496e639aaa8");
		CloseableHttpResponse response = httpCliente.execute(httpGet);
		try {
			System.out.println(response.getStatusLine());
			HttpEntity entity = response.getEntity();

			answer = (JSONObject) parser.parse(EntityUtils.toString(entity));

		} finally {
			response.close();
		}

		return answer;

	}
	
	public void postMethod() throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=2ede92a2afff7a8461977ae2f64c9496e639aaa8");
		File file = new File("D:\\Kaio\\CodeNation\\answer.json");
		FileBody filebody = new FileBody(file, ContentType.MULTIPART_FORM_DATA);
		MultipartEntityBuilder multipartBuilder = MultipartEntityBuilder.create();
		multipartBuilder.addPart("answer", filebody);
		HttpEntity entity = multipartBuilder.build();
		httpPost.setEntity(entity);
		
		try {
			CloseableHttpResponse response = httpClient.execute(httpPost);
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			httpClient.close();
		}
		
		
		
	}
	
	
		

}