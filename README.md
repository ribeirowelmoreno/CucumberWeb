# CucumberWeb

*********Setup para Tests Web usando o Cucumber*********

1- Baixar o Intellij e instalar
2- Instalar o plugin "cucumber for java" (Select projec>file>settings>plugins)
3- Criar um projeto "Maven"
4- No pom.xml, adicionar as dependencias: cucumber-core, cucumber-html, cobertura, cucumber-java, cucumber-junit, cucumber-jvm-deps, cucumber-reporting, hamcrest-core, gherkin, selenium-java, junit
5- Adicionar manualmente as libraries do Junit e Hamcrest
	* Vai em: Project Structure>>Modules>>selecionar dependencias dentro de modules>>clicar no "+" no canto direito>>Library>>New Library>>Java>>Ir na pasta do Intellij>>lib>>selecionar a lib junit.4.12>>ok>>repedir o processo para a lib hamcrest-core
6- Criar o diretório "ChromeDriver" na raiz do projeto e colocar o chromedriver dentro
7- Criar o diretorio "Features" na raiz do projeto e criar um arquivo "nomeDoArquivo.feature"
8- Criar um diretorio "stepDefinition" ou algo que referencia "step" dentro de src>test>java


**********Escrita do Gherkin (arquivo feature criado no passo 7)**********

@Tag-do-cenario-de-testes (não necessáriamente precisa ter uma tag, mais pra frente eu explico o porque de ter)


	@Search-for-some-product
	Scenario Outline (ou só Scenario, caso não queira passar nenhum parametro): This test is intended to...
	
	Given user is in home page
	
	When user insert "<name>" and "<password>" correctly
	
	And press confirm button
	And search for a product
	
	Then the produtc should be appears on the screen
	Then close browser
	
	Examples:
	| email | password |
	|email.exemple@ab.com | 123456 |
