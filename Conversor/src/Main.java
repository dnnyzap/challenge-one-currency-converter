import service.CurrencyApiService;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static final String apiKey = "853d5f589803807400740132";
    private static final String apiBaseUrl = "https://v6.exchangerate-api.com/v6/latest";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CurrencyApiService apiService = new CurrencyApiService(apiKey, apiBaseUrl);

        System.out.println("===Danny conversor de Moedas===");

        while (true) {
            exibirMenu();
            try {
                int opcao = input.nextInt();
                input.nextLine();

                if (opcao == 0) {
                    System.out.println("Finalizando operação. Até mais!");
                    break;
                }

                String coinOrigem = "";
                String coinDestino = "";

                switch (opcao) {
                    case 1:
                        coinOrigem = "USD";
                        coinDestino = "BRL";
                        break;
                    case 2:
                        coinOrigem = "BRL";
                        coinDestino = "USD";
                        break;
                    case 3:
                        coinOrigem = "EUR";
                        coinDestino = "JPY";
                        break;
                    case 4:
                        coinOrigem = "JPY";
                        coinDestino = "EUR";
                        break;
                    case 5:
                        coinOrigem = "GBP";
                        coinDestino = "USD";
                        break;
                    case 6:
                        coinOrigem = "CAD";
                        coinDestino = "BRL";
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, digite um número de 0 a 6.");
                        continue;
                }

                System.out.println(String.format("Digite o valor em %s para converter: ",
                        coinOrigem));
                double valor = input.nextDouble();

                double taxa = apiService.getExchangeRate(coinOrigem, coinDestino);

                if (taxa != -1.0) {
                    double valorConvertido = valor * taxa;
                    System.out.println(String.format("\n%.2f %s equivalem a %.2f %s (taxa: %.4f",
                            valor, coinOrigem, valorConvertido, coinDestino, taxa));
                } else {
                    System.out.println("Não foi possível realizar a conversão com as moedas " +
                            "selecionadas" +
                            " ");
                }
            catch(InputMismatchException e){
                    System.out.println("Entrada inválida. Por favor, digite um número para a " +
                            "opção e para o valor.");
                    input.nextLine();
                }
            catch(Exception e){
                    System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            input.close();
        }
        private static void exibirMenu () {
            String textomenu = "\n Escolha uma opção de conversão: " + "\n1. USD para BRL" + "\n2" +
                    ". " +
                    "BRL para USD" + "\n3. EUR para JPY" + "\n4. JPY para EUR" + "\n5. GBP para " +
                    "USD" + "\n6. CAD para BRL" + "0. Sair" + "\nDigite o número da sua opção:  ";

            System.out.println(textomenu);
        }

    }
}
