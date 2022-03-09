package java11;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@SuppressWarnings("unused")
public class HttpClientExamples {

	public static void main(String[] args) throws IOException, InterruptedException {
		// syncBuscarCEP("88063100");
		// asyncBuscarCEP("88063100");
		// postData();
		// basicAuth();
	}

	private static void syncRequest(String cep) throws IOException, InterruptedException {
		var request = HttpRequest.newBuilder() //
				.uri(URI.create("https://viacep.com.br/ws/88063100/json")) //
				.build();
		var client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}

	private static void asyncRequest(String cep) {
		var request = HttpRequest.newBuilder() //
				.uri(URI.create("https://viacep.com.br/ws/88063100/json")) //
				.build();
		var client = HttpClient.newHttpClient();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString()) //
				.thenApply(HttpResponse::body) //
				.thenAccept(System.out::println);
	}

	private static void postData() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder() //
				.uri(URI.create("https://postman-echo.com/post")) //
				.timeout(Duration.ofSeconds(30)) //
				.version(HttpClient.Version.HTTP_2) //
				.header("Content-Type", "text/plain") //
				.POST(HttpRequest.BodyPublishers.ofString("Opa, blz?!")) //
				.build();
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.statusCode()); // 200
	}

	private static void basicAuth() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request1 = HttpRequest.newBuilder() //
				.uri(URI.create("https://postman-echo.com/basic-auth")) //
				.build();
		HttpResponse<String> response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());

		System.out.println(response1.statusCode()); // 401

		HttpClient authClient = HttpClient.newBuilder() //
				.authenticator(new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("postman", "password".toCharArray());
					}
				}) //
				.build();
		HttpRequest request2 = HttpRequest.newBuilder() //
				.uri(URI.create("https://postman-echo.com/basic-auth")) //
				.build();
		HttpResponse<String> response2 = authClient.send(request2, HttpResponse.BodyHandlers.ofString());

		System.out.println(response2.statusCode()); // 200
	}

}
