package service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class CurrencyApiService {

        private final String apiBaseUrl;
        private final String apiKey;
        private final HttpClient httpClient;
        private final Gson gson; // Instância do Gson

        public CurrencyApiService(String apiBaseUrl, String apiKey) {
                this.apiBaseUrl = apiBaseUrl;
                this.apiKey = apiKey;
                this.httpClient = HttpClient.newHttpClient();
                this.gson = new Gson();
        }

        public double getExchangeRate(String baseCurrency, String targetCurrency) {
                try {
                        String url = apiBaseUrl + baseCurrency;

                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .GET()
                                .build();

                        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                        if (response.statusCode() != 200) {
                                System.err.println("Erro na requisição HTTP: " + response.statusCode() + " - " + response.body());
                                return -1.0;
                        }

                        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);


                        String result = jsonResponse.get("result").getAsString();
                        if (!"success".equals(result)) {

                                String errorType = jsonResponse.has("error-type") ? jsonResponse.get("error-type").getAsString() : "Desconhecido";
                                System.err.println("Erro da API: " + errorType);
                                return -1.0;
                        }


                        JsonObject rates = jsonResponse.getAsJsonObject("rates");
                        if (rates != null && rates.has(targetCurrency)) {
                                return rates.get(targetCurrency).getAsDouble();
                        } else {
                                System.err.println("Moeda de destino não encontrada na resposta da API ou 'rates' ausente: " + targetCurrency);
                                return -1.0;
                        }

                } catch (IOException | InterruptedException e) {
                        System.err.println("Erro de comunicação com a API: " + e.getMessage());
                        return -1.0;
                } catch (JsonSyntaxException e) {
                        System.err.println("Erro ao analisar a resposta JSON da API. Formato inválido: " + e.getMessage());
                        return -1.0;
                } catch (NullPointerException e) {
                        System.err.println("Erro: Estrutura da resposta da API inesperada. Elemento JSON ausente. " + e.getMessage());
                        return -1.0;
                } catch (Exception e) {
                        System.err.println("Ocorreu um erro inesperado ao processar a resposta da API: " + e.getMessage());
                        return -1.0;
                }
        }
}