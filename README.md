*********Setup para Tests Web usando o Cucumber*********

1- Baixar o Intellij e instalar

2- Instalar o plugin "cucumber for java" (Select projec>file>settings>plugins)
3- Criar um projeto "Maven"

4- No pom.xml, adicionar as dependencias: cucumber-core, cucumber-html, cobertura, cucumber-java, cucumber-junit, cucumber-jvm-deps, cucumber-reporting, hamcrest-core, gherkin, selenium-java, junit

5- Adicionar manualmente as libraries do Junit e Hamcrest
	* Vai em: Project Structure>>Modules>>selecionar dependencias dentro de modules>>clicar no "+" no canto direito>>Library>>New Library>>Java>>Ir na pasta do Intellij>>lib>>selecionar a lib junit.4.12>>ok>>repedir o processo para a lib hamcrest-core
6- Criar o diretório "ChromeDriver" na raiz do projeto e colocar o chromedriver dentro

7- Criar o diretorio "Features" na raiz do projeto e criar um arquivo "nomeDoArquivo.feature"

8- Criar um package "stepDefinition" ou algo que referencia "step" dentro de src>test>java
	*Criar uma classe dentro desse diretorio (por exemplo LoginSteps)
	
9- Crie um package support dentro de src>test>java e crie uma classe Web dentro desse package
	*dentro dessa classe vai ficar o setup de star do navegador:
	
	public class Web {

    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "path\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.br/");

        return driver;
    }
}
10-Crie um package pages e insira as suas páginas do site que quer automatizar, em estrutura de page objects


**********Escrita do Gherkin (arquivo feature criado no passo 7)**********

@Tag-do-cenario-de-testes (não necessáriamente precisa ter uma tag, mais pra frente eu explico o porque de ter)


	@Search-for-some-product
	Scenario Outline (ou só Scenario, caso não queira passar nenhum parametro): This test is intended to...
	
	Given user click in sign in on home page
	
	When user insert "<name>" and "<password>" correctly
	
	And press confirm button
	And search for a product
	
	Then the produtc should be appears on the screen
	Then close browser
	
	Examples:
	| email | password |
	|email.exemple@ab.com | 123456 |
	
1-Com o botão direito do mouse, clique em cima da frase que está no Scenario Outline>>Run Scenario...ou CTRL+SHIFT+F10

2-O teste vai começar a falhar, e no prompt do Intellij vai aparecer uma estrutura pra ser usada, algo como:

	@Given("user is in home page")
    public void user_is_in_home_page() {    
}

3-Va na classe criada no passo 8 e primeiro defina a execução do setUp do browser:

public class LoginSteps {
    private WebDriver driver;

	//quer dizer que antes de executar o teste, o framework vai na sua classe Web e executar o método de criação do browser
    @Before
    public void setUP(){
        driver = Web.createChrome();
    }

	**cole aqui o que foi sugerido pelo cucumber no passo 2 de "Escrita do Gherkin", exemplo:
	
		@Given("user click in sign in on home page")
    public void user_click_in_sign_in_on_home_page() {    
}
}

4-Agora é só chamar os métodos das pages dentro de cada step, por exemplo:
public class LoginSteps {
    private WebDriver driver;

    @Before
    public void setUP(){
        driver = Web.createChrome();
    }
	
		@Given("user click in sign in on home page")
    public void user_click_in_sign_in_on_home_page() {    
		new MainPage(driver)
			.ClickOnSignInButton();
}
}

Após feito isso, da pra rodar os testes igual no step 1

*********Execução dos testes pelo TestRunner*********

1- Crie um package dentro de src>test>java como testRunner

2- Crie uma classe dentro dele com o mesmo nome, ou algo que referencie "runner"
	*Dentro dessa classe, coloque os seguintes dados:
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
        features = "path//PurchaseSimulator.feature", //path do seu arquivo .feature
        glue = "stepDefinitions", //nome do diretorio dos steps
        tags ={"@Tag-do-cenario-de-testes, @Search-for-some-product"} // aqui que usamos aquelas tags feitas na Escrita do Gherkin
)

public class TestRunner {
}

Agora da pra rodar os testes por aqui, e a ordem que as tags forem colocadas, será a ordem de execução


	

