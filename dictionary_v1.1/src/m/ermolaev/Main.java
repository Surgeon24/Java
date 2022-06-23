package m.ermolaev;

import m.ermolaev.findWord.findWord;



/**
 * @author Mikhail Ermolaev
 * @version 1.1
 *
 *
 * This class will run the program in console mode.
 * To run it in GUI mod, choose src/m/ermolaev/view/TranslateForm/TranslateForm as a main file.
 *
 * To execute console mode, run main with three command line arguments: the word you want to translate,
 * the language you want to translate from and the language you want to translate into.
 * The result of the program will be translation of this word or comment "*Word not found*", if there is no such a word
 * in the dictionary.
 * */
public class Main {
    /**
     * Start point of the console mode.
     * */
    public static void main(String[] args) {
        if (args.length != 3){
            System.err.print("Wrong number of arguments. Expected 2 arguments representing links on dictionaries.\n");
            throw new IllegalArgumentException();
        }
        String word = args[0];
        String from = args[1];
        String to = args[2];
        String out = "";
        findWord fw = new findWord();
        out = fw.findWord(word, from, to);
        if (out != "")
            System.out.print("\nSuccess!\nTłumaczenie: " + out);
        else
            System.out.print("\nNapotkano błąd!\n");
    }
}

