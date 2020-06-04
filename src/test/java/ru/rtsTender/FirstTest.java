package ru.rtsTender;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FirstTest {
 private static final Logger logger= LoggerFactory.getLogger(FirstTest.class);

    @Test
    public void main() {
        logger.info("Тест");

        System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
//Открываем страницу поиска
        driver.get("https://223.rts-tender.ru/supplier/auction/Trade/Search.aspx");

//Ставим все чекбоксы
        driver.findElement(By.xpath("//input[@id='BaseMainContent_MainContent_cbxCollectivePurchasing' and @name='ctl00$ctl00$BaseMainContent$MainContent$cbxCollectivePurchasing' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@id='BaseMainContent_MainContent_cbxIsForSubjectsSmb' and @name='ctl00$ctl00$BaseMainContent$MainContent$cbxIsForSubjectsSmb' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@id='BaseMainContent_MainContent_cbxIsTradeInvalid' and @name='ctl00$ctl00$BaseMainContent$MainContent$cbxIsTradeInvalid' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//span/input[@id='BaseMainContent_MainContent_chkPurchaseType_0' and @name='ctl00$ctl00$BaseMainContent$MainContent$chkPurchaseType$0' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//span/input[@id='BaseMainContent_MainContent_chkPurchaseType_1' and @name='ctl00$ctl00$BaseMainContent$MainContent$chkPurchaseType$1' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//span/input[@id='BaseMainContent_MainContent_chkPurchaseType_2' and @name='ctl00$ctl00$BaseMainContent$MainContent$chkPurchaseType$2' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//span/input[@id='BaseMainContent_MainContent_chkPurchaseType_3' and @name='ctl00$ctl00$BaseMainContent$MainContent$chkPurchaseType$3' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//span/input[@id='BaseMainContent_MainContent_chkPurchaseType_4' and @name='ctl00$ctl00$BaseMainContent$MainContent$chkPurchaseType$4' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//span/input[@id='BaseMainContent_MainContent_chkPurchaseType_5' and @name='ctl00$ctl00$BaseMainContent$MainContent$chkPurchaseType$5' and @type='checkbox']")).click();


//Вписываем заказчика
        driver.findElement(By.className("dbig")).click();
        driver.findElement(By.xpath("//input[@id='BaseMainContent_MainContent_txtOrgnizer_txtText' and @name='ctl00$ctl00$BaseMainContent$MainContent$txtOrgnizer$txtText' and @type='text']")).sendKeys("лукойл");
//Заполняем дату неправильно
        driver.findElement(By.id("BaseMainContent_MainContent_txtPublicationDate_txtDateFrom")).click();
        driver.findElement(By.xpath("//input[@id='BaseMainContent_MainContent_txtPublicationDate_txtDateFrom' and @name='ctl00$ctl00$BaseMainContent$MainContent$txtPublicationDate$txtDateFrom' and @type='text']")).sendKeys("2.02.20");
//Нажимаем Поиск
        WebElement find = driver.findElement(By.id("BaseMainContent_MainContent_btnSearch"));
        find.click();
//Проверяем, появилась ли ошибка
        WebElement body = driver.findElement(By.className("err_list"));
        String bug = body.getText();
        if (bug.contains("Неверно заполнено поле"))
        System.out.println("Выводится ошибка");
//Стираем дату
        driver.findElement(By.id("BaseMainContent_MainContent_txtPublicationDate_txtDateFrom")).click();
        driver.findElement(By.xpath("//input[@id='BaseMainContent_MainContent_txtPublicationDate_txtDateFrom' and @name='ctl00$ctl00$BaseMainContent$MainContent$txtPublicationDate$txtDateFrom' and @type='text']")).clear();
//Нажимаем Поиск
        WebElement find1 = driver.findElement(By.id("BaseMainContent_MainContent_btnSearch"));
        find1.click();
        System.out.println("В таблице только Организация - Лукойл");
//Вписываем объект
        driver.findElement(By.id("BaseMainContent_MainContent_txtName_txtText")).click();
        driver.findElement(By.xpath("//input[@id='BaseMainContent_MainContent_txtName_txtText' and @name='ctl00$ctl00$BaseMainContent$MainContent$txtName$txtText' and @type='text']")).sendKeys("известь");
//Нажимаем Поиск
        WebElement find2 = driver.findElement(By.id("BaseMainContent_MainContent_btnSearch"));
        find2.click();
        System.out.println("В таблице только Организация - Лукойл и Предмет договора - известь");
//Проверяем работу разделов
        driver.findElement(By.xpath("//a[@class='ui-tabs-anchor' and @value='97']")).click();
        System.out.println("Перешли в раздел Прием заявок");
//Нажимаем кнопку Очистить
        WebElement Clear = driver.findElement(By.id("BaseMainContent_MainContent_btnCancel"));
        Clear.click();
        System.out.println("Очистка фильтра");


//Проверяем работу пагинации
        WebElement Pag = driver.findElement(By.id("next_t_BaseMainContent_MainContent_jqgTrade_toppager"));
        Pag.click();
        System.out.println("Переход на вторую страницу");

        System.out.println("Тест завершен");
}
}