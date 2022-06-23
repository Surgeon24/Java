package view;

import m.ermolaev.findWord.findWord;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TranslateForm {
    private JComboBox FromLanguageComboBox;
    private JComboBox ToLanguageComboBox;
    private JTextField InputTextField;
    private JTextField OutputTextField;
    private JButton TranslateButton;
    private JPanel mainPanel;

    private static TranslateForm form;

    /**
     * @author Mikhail Ermolaev
     * @version 1.1
     *
     * This class will run the program in GUI mode.
     * To run it in GUI mod, choose src/m/ermolaev/view/TranslateForm/TranslateForm as a main file.
     *
     * */
    public TranslateForm() {
        TranslateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fVal = InputTextField.getText();
                    String from = (String) FromLanguageComboBox.getSelectedItem();
                    String to = (String) ToLanguageComboBox.getSelectedItem();
                    System.out.print(fVal + " , " + from + " , " + to + "\n\n");
                    findWord fw = new findWord();
                    String result = fw.findWord(fVal, from, to);
                    OutputTextField.setText(result);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Nipoprawny format wprowadzonego słowa!");
                }
            }
        });
    }

    public static void initRates(TranslateForm frm){
        //...
    }

    public static void requireDefault(TranslateForm frm){
        //String out = frm.provider
    }

    public static String removeFileExtension(String filename) {
        if (filename == null || filename.isEmpty()) {
            return filename;
        }

        String extPattern = "(?<!^)[.].*" ;
        return filename.replaceAll(extPattern, "");
    }

    public static void initForm(TranslateForm frm){
        File folder = new File("src/m/ermolaev/dictionary");
        File[] listOfFiles = folder.listFiles();
        String tmp[] = new String[2];
        String line;
        Set<String> sFrom = new HashSet<>();
        Set<String> sTo = new HashSet<>();
        for (int i = 0; i < listOfFiles.length; i++){
            line = removeFileExtension(listOfFiles[i].getName());
            tmp = line.split("-");
            sFrom.add(tmp[0]);
            sTo.add(tmp[1]);
        }
        for (String s : sFrom)
            frm.FromLanguageComboBox.addItem(s);
        for (String s : sTo)
            frm.ToLanguageComboBox.addItem(s);
    }

    public static void main(String[] args){
        JFrame mainFrame = new JFrame("Translator");
        form = new TranslateForm();
        mainFrame.setContentPane(form.mainPanel);
        initRates(form);
        requireDefault(form);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        initForm(form);
    }
}
