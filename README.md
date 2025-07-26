
# Conversor de Moedas (Terminal Interativo)

Este é um aplicativo simples de conversão de moedas baseado em terminal, desenvolvido em Java para um Challenge da capacitação em Java na Alura. Ele permite aos usuários converter valores entre diferentes pares de moedas, obtendo as taxas de câmbio em tempo real através de uma API externa.

## Funcionalidades

* **Conversão de Moedas:** Converte valores entre pares de moedas pré-definidos (USD, BRL, EUR, JPY, GBP, CAD).

* **Taxas de Câmbio em Tempo Real:** Obtém as taxas de câmbio mais recentes de uma API externa.

* **Interface de Terminal Interativa:** Menu simples e fácil de usar para seleção de opções e entrada de valores.

* **Tratamento de Erros:** Lida com entradas inválidas do usuário e erros de comunicação com a API.

## Como Executar o Projeto

Para executar este projeto, você precisará ter o Java Development Kit (JDK) instalado em sua máquina (versão 11 ou superior é recomendada).

### Pré-requisitos

* **Java Development Kit (JDK):** Certifique-se de ter o JDK instalado e configurado corretamente em suas variáveis de ambiente. Você pode baixá-lo em [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) ou [OpenJDK](https://openjdk.java.net/install/).

* **Chave de API da ExchangeRate-API:** Este projeto utiliza a [ExchangeRate-API](https://www.exchangerate-api.com/). Você precisará de uma chave de API gratuita. Obtenha sua chave e insira-a no código (veja a seção "Configuração da API").

* **Dependência Gson:** O projeto utiliza a biblioteca Gson para parsear as respostas JSON da API.

### Configuração da API

1. **Obtenha sua Chave de API:** Vá para [ExchangeRate-API](https://www.exchangerate-api.com/) e registre-se para obter sua chave de API gratuita.

2. **Atualize `Main.java`:**
   No arquivo `Main.java`, atualize a variável `apiKey` com a sua chave obtida:

```

private static final String apiKey = "SUA\_CHAVE\_API\_AQUI"; // Substitua por sua chave real
private static final String apiBaseUrl = "[https://v6.exchangerate-api.com/v6/](https://www.google.com/url?sa=E&source=gmail&q=https://v6.exchangerate-api.com/v6/)";

```

Certifique-se de que `apiBaseUrl` esteja configurado como `"https://v6.exchangerate-api.com/v6/"`.

### Adicionar Dependência Gson

Se você estiver usando um ambiente de desenvolvimento como IntelliJ IDEA:

1. **Baixe o JAR do Gson:** Você pode baixar o arquivo JAR do Gson em [Maven Central](https://mvnrepository.com/artifact/com.google.code.gson/gson). Escolha a versão mais recente.

2. **Adicione ao Projeto (IntelliJ IDEA):**

* Abra seu projeto no IntelliJ IDEA.

* Vá em `File` > `Project Structure...` (ou `Ctrl+Alt+Shift+S`).

* No painel esquerdo, selecione `Modules`.

* Selecione o módulo do seu projeto (geralmente o nome do seu projeto).

* Vá para a aba `Dependencies`.

* Clique no botão `+` e selecione `JARs or directories...`.

* Navegue até o local onde você baixou o arquivo `gson-X.Y.Z.jar` e selecione-o.

* Clique em `OK` para adicionar a dependência.

### Compilar e Executar

1. **Navegue até o Diretório do Projeto:**
Abra um terminal ou prompt de comando e navegue até a pasta raiz do seu projeto (onde estão as pastas `src`, `.idea`, etc.).

2. **Compile o Código:**

```

javac -d out/production/conversor src/main/java/Main.java src/main/java/service/CurrencyApiService.java

```

* `javac`: Compilador Java.

* `-d out/production/conversor`: Define o diretório de saída para os arquivos compilados (`.class`).

* `src/main/java/Main.java src/main/java/service/CurrencyApiService.java`: Caminhos para seus arquivos `.java`.

**Nota:** Se você estiver usando um IDE como IntelliJ IDEA, ele geralmente compila o projeto automaticamente.

3. **Execute o Programa:**

```

java -cp out/production/conversor;lib/gson-2.10.1.jar Main

```

* `java`: Máquina Virtual Java.

* `-cp out/production/conversor;lib/gson-2.10.1.jar`: Define o `classpath`, que informa ao Java onde encontrar suas classes compiladas (`.class`) e a biblioteca Gson. **Substitua `lib/gson-2.10.1.jar` pelo caminho real e nome do arquivo JAR do Gson no seu projeto.** No Windows, use `;` como separador de classpath; no Linux/macOS, use `:`.

* `Main`: O nome da sua classe principal com o método `main`.

**Nota:** Se você estiver usando um IDE, basta clicar no botão "Run" (geralmente um triângulo verde) na sua classe `Main`.

## Estrutura do Projeto

```

.
├── .idea/                 \# Configurações do IntelliJ IDEA (ignoradas pelo Git)
├── out/                   \# Arquivos compilados (ignorados pelo Git)
├── src/
│   └── main/
│       └── java/
│           ├── service/
│           │   └── CurrencyApiService.java \# Lógica de comunicação com a API
│           └── Main.java                 \# Ponto de entrada e interface do usuário
├── .gitignore             \# Arquivo para ignorar arquivos e pastas no Git
├── Conversor.iml          \# Arquivo de módulo do IntelliJ (pode ser ignorado se usar Maven/Gradle)
└── README.md              \# Este arquivo

```

## Tecnologias Utilizadas

* **Java 21+**

* **Java HTTP Client (java.net.http)**: Para fazer requisições HTTP.

* **Gson Library**: Para parsear respostas JSON.

* **ExchangeRate-API (v6)**: API de taxas de câmbio.



