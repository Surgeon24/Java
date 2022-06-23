package findWord;

import m.ermolaev.findWord.findWord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class findWordTest {
    @Test
    void dictionaryExistAndWordExistEnToIt(){
        var fw = new findWord();
        assertEquals("palla", fw.findWord("ball", "English", "Italian"));
    }

    @Test
    void dictionaryExistAndWordExistPlToEn(){
        var fw = new findWord();
        assertEquals("ball", fw.findWord("piłka", "Polish", "English"));
    }

    @Test
    void dictionaryExistAndWordDoesntExistEnToIt(){
        var fw = new findWord();
        assertEquals("*Word not found*", fw.findWord("wordthatdoesntexist", "English", "Italian"));
    }

    @Test
    void dictionaryExistAndWordDoesntExistPlToEn(){
        var fw = new findWord();
        assertEquals("*Word not found*", fw.findWord("wordthatdoesntexist", "Polish", "English"));
    }

    @Test
    void dictionaryDoesntExist(){
        var fw = new findWord();
        assertEquals("", fw.findWord("ball", "Eng", "Italian")); //Eng != English
    }

    @Test
    void incorrectWord(){
        var fw = new findWord();
        assertEquals("*Word not found*", fw.findWord("ball|palla", "English", "Italian")); //Eng != English
    }

}