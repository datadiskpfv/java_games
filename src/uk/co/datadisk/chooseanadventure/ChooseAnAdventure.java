package uk.co.datadisk.chooseanadventure;

import com.godtsoft.diyjava.DIYWindow;

/**
 * Created by vallep on 09/07/2017.
 *
 */
public class ChooseAnAdventure extends DIYWindow {
    public ChooseAnAdventure() {

        startStory();
        String choice = input();

        switch(choice) {
            case "a":
                goUpTheHill();
                break;
            case "b":
                checkingTheCottage();
                break;
            case "c":
                plantingBeans();
                break;
            default:
                 startStory();
        }
    }

    public void goUpTheHill() {
        print("\nGoing up the hill.");

        String story = "\nOn my up the hill, a girl joined me. She told me her name was Jill.";
        story = story + "She was carrying a pail. There's also a trail of breadcrumbs going down another path.\n";
        print (story);

        print("Should I:");
        print("a) Ask Jill to join me?");
        print("b) Follow the trail of bread crumbs?");
        String choice = input();

        switch(choice) {
            case "a":
                goWithJill();
                break;
            case "b":
                followBreadCrumbs();
                break;
            default:
                goUpTheHill();
        }

    }

    public void checkingTheCottage() {
        print("Checking the cottage.");
    }

    public void plantingBeans() {
        print("Planting beans.");
    }

    public void startStory() {
        String story = "I woke up in infamilar woods.";
        story = story + " I was hungry and tired.";
        story = story + " I didn't know where I was.";
        story = story + " In my pocket were three beans.";
        story = story + " Up the hill was a well.";
        story = story + " To the right was a small cottage.";

        print(story);
        print("");

        print("Should I:");
        print("a) Go up the hill?");
        print("b) Check out the cottage?");
        print("c) Plant the beans?");
    }

    public void goWithJill() {
        String story = "I was so much enjoying listening to Jill's stories. I didn't notice the branch across the path.";
        story = story + "I fell down.";

        print("What happened next?");
        print("a) I broke my crown and Jill came tumbling after.");
        print("b) The beans fell out of my pocket and immediately sprouted a bean stalk.");

        String choice = input();

        switch(choice) {
            case "a":
                brokeMyCrown();
                break;
            case "b":
                sproutedABeanStalk();
                break;
        }
    }

    public void followBreadCrumbs() {
        print("Follow the trail of breadcrumbs.");
    }

    public void brokeMyCrown() {
        print("The crown broke but Jill was unhurt");
    }

    public void sproutedABeanStalk() {
        print("The bean stalk was so tall it went into the clouds.");

    }

    public static void main(String[] args) {
        new ChooseAnAdventure();
    }
}