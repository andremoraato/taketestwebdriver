import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;


public class EncontrarElementos 
{
	private WebDriver driver;
	@Before //Para acessar o nosso Blog antes da execução de cada teste
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://www.taketest.com.br/");
		driver.manage().window().maximize(); //maximar página
	}
	
	
	@Test
	public void encontrarElementos() 
	{
		WebElement menusobre = driver.findElement(By.id("menu-item-19")); 
		assertTrue(menusobre.getText().contains("SOBRE"));
		
		WebElement topicosrecentes = driver.findElement(By.id("recent-posts-2"));
		assertTrue(topicosrecentes.isDisplayed());
		
		WebElement tagwebdriver = driver.findElement(By.className("tag-link-32"));
		assertTrue(tagwebdriver.getText().equals("Webdriver"));
	}
	
	@Test
	public void atualizarPagina() 
	{
		driver.navigate().refresh();
	}
	
	@After
	public void fecharPagina()
	{
		driver.quit();
	}
}
