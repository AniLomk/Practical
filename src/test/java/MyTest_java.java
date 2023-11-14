import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import com.codeborne.selenide.selector.ByText;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MyTest_java {


    @Test
    public void myTest() {
        open("https://ee.ge/");
        /*ტესტ მეთოდი 1 - დადებითი მნიშვნელობები*/
        $(byText("რეგისტრაცია")).click();
        $("#firstName").shouldBe(Condition.visible);
        $("#firstName").setValue("ani");
        $("#firstName").shouldNot(Condition.empty);
        $("#lastName").setValue("lomkatsi");
        $("#lastName").shouldNot(Condition.empty);
        $("#email").setValue("ani.lomkatsi@yahoo.com");
        $("#email").shouldNot(Condition.empty);
        $("#password").setValue("Banana123");
        $("#password").shouldBe(Condition.visible);
        $("#confirmPassword").setValue("Banana123");
        $("#confirmPassword").shouldBe(Condition.visible);
        $("#singup").shouldBe(Condition.enabled);
        sleep(5000);

    }

    @Test
    public void myTest2() {
        /*ტესტ მეთოდი 2 - ნეგატიური მნიშვნელობები*/
        open("https://ee.ge");
        $(byText("რეგისტრაცია")).click();
        $("#firstName").shouldBe(Condition.visible);
        $("#singup").shouldBe(Condition.disabled);
        $("#firstName").click();
        $("#lastName").click();
        $(byText("სახელი სავალდებულოა")).shouldBe(Condition.visible);
        $("#email").click();
        $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible);
        $("password").click();  /*ყველანაირად ვცადე და ვერაფრით ვერ დავაკლიკე პაროლზე :(*/
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible, Duration.ofMillis(2000));
        $("#confirmPassword").click();
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        $(byText("სწრაფი რეგისტრაცია")).click();
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);
        $("#email").setValue("ani.lomkatsi--yahoo.com");
        $("#password").setValue("banan");
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        $("#confirmPassword").setValue("banana");
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);
        sleep(6000);

    }


    @Test
    public void myTest3() {
        /*ტესტ მეთოდი 3*/
        open("https://ee.ge");
        $(".cart-count").click();
        $(".not_cart_items").shouldBe(Condition.visible);
        $("#search_list").setValue("ლეპტოპი").pressEnter();
        $(byText("დაამატე კალათში"), 0).click();
        $(".btn-cart").click();
        $(byText("დადასტურება")).shouldBe(Condition.visible);
}



    @Test
    public void myTes4() {
        /*ტესტ მეთოდი 4*/
        open("https://ee.ge");
        $(".cart-count").click();
        $(".not_cart_items").shouldBe(Condition.visible);
        $(By.xpath("//*[@id=\"__next\"]/div/div[1]/nav/div/ul/li[9]/a")).click();
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);
        $("#search_list").setValue("ლეპტოპი").pressEnter();
        $(byText("დაამატე კალათში"), 0).click();
        $(".cart-count").click();
        $(byText("შენახვა")).click();
        $(By.xpath("//*[@id=\"__next\"]/div/div[1]/nav/div/ul/li[9]/a")).click();
        $(byText("ყიდვა")).shouldBe(Condition.visible);
        $(".cart-count").click();
        $(".not_cart_items").shouldBe(Condition.visible);
        $(By.xpath("//*[@id=\"__next\"]/div/div[1]/nav/div/ul/li[9]/a")).click();
        $(".class=\"btn btn-darkred btn_round d-xs-none\"").click();
        $(".not_cart_items").shouldBe(Condition.visible);
        sleep(10000);


  }
}




