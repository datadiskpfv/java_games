package uk.co.datadisk.secretcode;

import uk.co.datadisk.mywindow.MyWindow;

import java.io.*;

/**
 * Created by vallep on 13/07/2017.
 *
 */
public class SecretCode extends MyWindow {


    public SecretCode() {
        String fileName = "key.txt";

        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
            String alphabet = in.readLine();
            String key = in.readLine();
            in.close();

            //String messageToEncode = promptForString("Enter a a message to encode: ");
            //String encodedMessage = encode(messageToEncode, alphabet, key);
            //print(encodedMessage);

            //String decodedMessage = encode(encodedMessage, key, alphabet);
            //print(decodedMessage);

            boolean quit = false;
            while(!quit) {
                String option = promptForString("Do you want to encode(e|E) or decode(d|D) a message, or quit(q|Q)? ");
                switch(option) {
                    case "Q":
                    case "q":
                        quit = true;
                        break;
                    case "E":
                    case "e":
                        String messageToEncode = promptForString("Enter a a message to encode: ");
                        String encodedMessage = encode(messageToEncode, alphabet, key);
                        print(encodedMessage + "\n");
                        break;
                    case "D":
                    case "d":
                        String messageToDecode = promptForString("Enter a a message to decode: ");
                        String decodedMessage = encode(messageToDecode, key, alphabet);
                        print(decodedMessage + "\n");
                        break;
                    default:
                        print(option + " is not a valid option");
                }
            }
            print("Bye!!");
            System.exit(0);

        }catch (FileNotFoundException e) {
            print("Error could not found file " + fileName);
        }
        catch (IOException e) {
            print("Error could not open file " + fileName);
        }
    }

    private String encode (String message, String fromAlphabet, String toAlphabet) {
        String newMessage = "";

        for (int i = 0; i < message.length(); i++) {
            // take the first letter of the message
            String letter = message.substring(i,i+1);
            System.out.println("Letter: " + letter);
            // find the index of that letter in the alphabet
            int letterPos = fromAlphabet.indexOf(letter);
            System.out.println("Letter Pos: " + letterPos);
            // get the letter from the key using the above index
            if (letterPos != -1 ) {
                newMessage += toAlphabet.substring(letterPos, letterPos + 1);
                System.out.println("newMessage: " + newMessage);
            } else {
                // if letter is not in the alphabet then add that letter
                newMessage += letter;
            }
        }
        return newMessage;
    }

    public static void main(String[] args) {
        new SecretCode();
    }
}
