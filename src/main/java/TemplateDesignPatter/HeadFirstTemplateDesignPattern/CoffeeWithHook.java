package TemplateDesignPatter.HeadFirstTemplateDesignPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CoffeineBeverageWithHook{
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    /* Burada hook'u override eder ve kendi functionality'sini sağlarsınız. */
    @Override
    boolean customerWantsCondiments() {
        /* Kullanıcının condiment kararına ilişkin inputunu alın ve input'a bağlı olarak true veya false döndürün.*/
        String answer = getUserInput();
        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput() {
        String answer = null;

        System.out.println("Would you like milk and sugar with your coffee (y/n) ?");

        /* Bu kod kullanıcıya milk ve sugar isteyip istemediğini sorar ve command line'dan inputunu alır.*/
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException exception){
            System.err.println("IO error trying to read your answer");
        }

        if (answer==null){
            return "no";
        }

        return answer;
    }
}
