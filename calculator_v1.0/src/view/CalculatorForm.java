package view;

import com.company.conversion.Conversion;
import com.company.conversion.Solve;

import javax.swing.*;
import javax.xml.stream.FactoryConfigurationError;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorForm {
    private JPanel mainPanel;
    private JButton button1;
    private JButton button3;
    private JButton button2;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button8;
    private JButton button9;
    private JButton button7;
    private JTextField mainField;
    private JButton buttonOBracket;
    private JButton buttonMultiply;
    private JButton buttonPlus;
    private JButton buttonCBracket;
    private JButton button0;
    private JButton buttonDot;
    private JButton buttonDelete;
    private JButton buttonDivide;
    private JButton buttonMinus;
    private JButton buttonEquals;

    private Solve solution;
    private Conversion conversion;

    private static CalculatorForm form;
    private Boolean newEquation = true;

    public CalculatorForm() {
        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String sVal = mainField.getText();
                    String onp;
                    Double output;
                    Conversion conversion = new Conversion();
                    onp = conversion.conversion(sVal);
                    Solve solution = new Solve();
                    output = solution.solve(onp);
                    mainField.setText(Double.toString(output));
                    newEquation = true;
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Input error!");

                }
            }
        });
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"0");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"1");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"2");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"5");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"6");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"7");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"8");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"9");
            }
        });
        buttonDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+".");
            }
        });
        buttonOBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"(");
            }
        });
        buttonCBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+")");
            }
        });
        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"*");
            }
        });
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"/");
            }
        });
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"+");
            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newEquation){
                    mainField.setText("");
                    newEquation = false;
                }
                String sVal = mainField.getText();
                mainField.setText(sVal+"-");
            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!mainField.getText().equals("")) {
                    String sVal = mainField.getText();
                    StringBuffer sb = new StringBuffer(sVal);
                    sb.deleteCharAt(sb.length() - 1);
                    mainField.setText(sb.toString());
                }
            }
        });
    }

    public static void initRates(CalculatorForm frm){
        frm.solution = new Solve();
        frm.conversion = new Conversion();
    }

    public static void main(String[] args){
        JFrame mainFrame = new JFrame("Calculator v1.0");
        form = new CalculatorForm();
        mainFrame.setContentPane(form.mainPanel);
        initRates(form);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

}
