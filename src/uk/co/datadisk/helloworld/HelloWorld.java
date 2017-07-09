package uk.co.datadisk.helloworld;

import com.godtsoft.diyjava.*;
/**
 * Created by vallep on 09/07/2017.
 *
 */
public class HelloWorld extends DIYWindow {
    public HelloWorld() {
        //setFontSize(18);
        String greeting = "Hello, Paul.\n\nHow are you?";
        String greeting2 = "Paul said to say \"Hi\" to you.";
        String javaProjectsFolder = "\\java_projects\\java_games";

        print(greeting);
        print(greeting2);
        print("The java projects: " + javaProjectsFolder);

    }

    public static void main(String[] args) {
        new HelloWorld();
    }
}