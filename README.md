# Desafio Selenium Cucumber

Projeto de automação de testes utilizando **Selenium WebDriver** e **Cucumber** para validar o fluxo completo do site de demonstração da Tricentis.

## 🚀 Fluxo automatizado
O teste cobre as seguintes abas do formulário:
1. Vehicle Data
2. Insurant Data
3. Product Data
4. Price Option
5. Send Quote

### Cenários implementados
- **Fluxo de sucesso**: preenchimento completo e envio da cotação com mensagem de sucesso.
- **Fluxo de erro**: validação de senhas diferentes no Send Quote, exibindo popup de erro.

## 📂 Estrutura do projeto
- `src/test/java/pages` → Page Objects (representação das telas)
- `src/test/java/steps` → Step Definitions (implementação dos cenários)
- `src/test/resources/features` → Feature files em Gherkin
- `support/TestContext.java` → Contexto compartilhado para WebDriver e Page Objects
- `pom.xml` → dependências (Selenium, Cucumber, JUnit/TestNG)

## ▶️ Como executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/desafio-selenium-cucumber.git
2. Abra o projeto no IntelliJ IDEA.

3. Execute os testes pelo runner do Cucumber ou diretamente pelo IntelliJ.

🛠️ Dependências

Java 17+

Maven

Selenium 4.21.0

Cucumber 7.15.0

PicoContainer para injeção de dependências

🎥 Vídeo explicativo

[Link para o vídeo explicando a solução]

📌 Decisões técnicas

Uso de Page Object Model para separar responsabilidades.

Métodos safeClick e safeSendKeys para evitar erros de elementos invisíveis.

Estratégia para lidar com inputs escondidos (clicar no pai do input).

Uso de WebDriverWait para sincronizar com o carregamento no Send Quote.

Introdução de TestContext com PicoContainer para compartilhar WebDriver e Page Objects entre steps.

Validação de mensagens de erro via popup no cenário de senhas inválidas.