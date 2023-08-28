package webelements;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


@RunWith(SerenityRunner.class)
public class HandlingLinks extends PageObject {

    @Managed
    WebDriver driver;

    @Test
    public void linksElementHandling() {
        openUrl("https://www.wikipedia.org/");

        ArrayList<WebElementFacade> linksElementOtherProjects = findAll(By.xpath("//a[@class='other-project-link']"));

        System.out.println("Start printing every link from other projects.");
        System.out.println("=====================================");

        int index = 1;
        for (WebElementFacade linkElement: linksElementOtherProjects) {
//            String textInLink = linkElement.getText();
            String link = linkElement.getAttribute("href");
            System.out.println(index + " " + link);
            index++;
        }

        System.out.println("=====================================");
        System.out.println("All other project link printed.");


        System.out.println("Another way to count");
        System.out.println("Printing links from other project method 2");
        System.out.println("=============================================");
//        using .then to chain call and find all element from element container
        WebElementFacade otherProjectsSection = find(By.xpath("//div[@class='other-projects']"));
        ArrayList<WebElementFacade> otherProject = otherProjectsSection.thenFindAll(By.tagName("a"));

        for (int i = 0; i < otherProject.size(); i++) {
//            get link in link element
            String link = otherProject.get(i).getAttribute("href");
            System.out.println(i+1 + " " + link);
        }

        System.out.println("=============================================");
        System.out.println("Printing links using method 2 done.");

    }


}









