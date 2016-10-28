//Bibliotecas que são utilizadas e devem ser importadas
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidarCadastroNovidades 
{
	private WebDriver driver;
	@Before //Para acessar o nosso Blog antes da execução de cada método
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://www.taketest.com.br/");
		driver.manage().window().maximize();
	}
	
	//Declaração das variáveis que vamos utilizar no nosso teste
	String nome = "informar nome";
	String email = "email@email.com.br";
	String mensagemsucesso = "Sua mensagem foi enviada com sucesso. Obrigado.";

	@Test 
	public void validarCadastroSucces() 
	{
			// Preencher o campo Seu nome (utilizando xpath)
			driver.findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-text wpcf7-validates-as-required']")).sendKeys(nome);
			
			//Preencher o campo Seu email
			driver.findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-text wpcf7-email wpcf7-validates-as-required wpcf7-validates-as-email']")).sendKeys(email);
			
			//Clicar no botão Enviar para confirmar o cadastro
			driver.findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-submit']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// Tempo para espera da mensagem de validação
			
			/*//Validar mensagem de sucesso
			WebElement confirmConfirm = driver.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ok']"));
			assertTrue(confirmConfirm.getText().contains(mensagemsucesso));*/
		}
		
		@After
		public void fecharPagina()
		{
			driver.quit();
		}
}
