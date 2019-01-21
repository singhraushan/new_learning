package com.rau.migo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

/**
 * @author Raushan kumar
 *
 */
public class SamplePractice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			int res;
			String _substr;
			try{
				_substr = sc.nextLine();
			}catch (Exception e) {
				_substr = null;
			}
			
			res = getNumberOfMovies(_substr);
			bw.write(String.valueOf(res));
			bw.newLine();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static int getNumberOfMovies(String subStr) {
		Client c = new Client("https://jasonmock.hackerrank.com/api/movies/search/?Tital=" + subStr);
		return c.getMovies();
	}
}

class Response {
	public int page;
	public int total;

	public int getTotal() {
		return total;
	}
}

class Client {
	public String url;

	public Client(String url) {
		this.url = url;
	}

	int getMovies() {
		int total = 0;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("GET");

			InputStream in = connection.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			StringBuffer buffer = new StringBuffer();

			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				buffer.append(inputLine + "\n");
			}

			String jasonResponse = buffer.toString();

			Gson gson = new Gson();
			Response response = gson.fromJson(jasonResponse, Response.class);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return total;
	}

}
