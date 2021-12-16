package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet is ---");
        System.out.println(petController.whichPetIsTheBest());

        System.out.println("------------ i18nController");
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println("------------ Primary Bean");

        System.out.println(myController.sayHello());

        System.out.println("------------ Property");

        PropertyInjectedController propController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propController.getGreeting());

        System.out.println("------------ Setter");

        SetterInjectedController setterController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterController.getGreeting());

        System.out.println("------------ Constructor");

        ConstructorInjectedController constructorController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorController.getGreeting());
    }

}
