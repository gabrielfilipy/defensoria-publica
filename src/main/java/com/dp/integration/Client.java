package com.dp.integration;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dp.model.Insumo;

@Component
public class Client {
	
	public static List<Insumo> list;
	
	public Client() {
		carregarDados();
	}

	public void carregarDados() { 
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.GET()
					.uri(URI.create("https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.json"))
					.header("accept", "application/json")
					//.headers("Authorization", "")
					.timeout(Duration.ofSeconds(1000))   
					.build();
			
			HttpClient client = HttpClient.newBuilder()
					.followRedirects(Redirect.NORMAL)
					.connectTimeout(Duration.ofSeconds(25)) 
					.build(); 
			
			HttpResponse<String> response;
			
			response = client.send(request, BodyHandlers.ofString());
			String json = response.body();
			list = new ArrayList<>();
			list = Serializador.jsonParaColecaoObjetoJavaJson(json);
			
		} catch (Exception e) {
			e.printStackTrace();
			//throw new Exception(e.getMessage());
		}
		
	}
	
}
