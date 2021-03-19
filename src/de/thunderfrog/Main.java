package de.thunderfrog;

import javax.swing.*;
import java.awt.*;

public class Main {


    public Main(){

        // FRAME Config
        JFrame frame = new JFrame();
        frame.setTitle("Rechner mit Radio");
        frame.setSize(350,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // MAIN Layout
        frame.setLayout(new BorderLayout());

        //  WEST Components
        JPanel leftPanel = new JPanel();
        JTextField firstInput = new JTextField(10);
        JTextField secondInput = new JTextField(10);

        //  ADD INPUT TO PANEL
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(firstInput);
        leftPanel.add(secondInput);

        //  ADD PANEL TO FRAME
        frame.add(leftPanel,BorderLayout.WEST);

        //  EAST Components
        JTextField result = new JTextField(10);
        result.setEditable(false);
        frame.add(result, BorderLayout.EAST);

        //  CENTER Components
        JPanel centerPanel = new JPanel();
        ButtonGroup centerGroup = new ButtonGroup();
        JRadioButton rbAddi = new JRadioButton();
        rbAddi.setText("Plus");
        JRadioButton rbSubt = new JRadioButton();
        rbSubt.setText("Minus");
        JRadioButton rbMult = new JRadioButton();
        rbMult.setText("Mal");
        JRadioButton rbDivi = new JRadioButton();
        rbDivi.setText("Geteilt");

        //  ADD BUTTONS TO GROUP
        centerGroup.add(rbAddi);
        centerGroup.add(rbSubt);
        centerGroup.add(rbMult);
        centerGroup.add(rbDivi);

        //  ADD BUTTONS TO PANEL
        centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.Y_AXIS));
        centerPanel.add(rbAddi);
        centerPanel.add(rbSubt);
        centerPanel.add(rbMult);
        centerPanel.add(rbDivi);

        //  ADD PANEL TO FRAME
        frame.add(centerPanel,BorderLayout.CENTER);

        //  SOUTH Components
        JButton btnCalc = new JButton();
        btnCalc.setText("Berechnen");
        frame.add(btnCalc,BorderLayout.SOUTH);

        //  ACTIONLISTENER
        btnCalc.addActionListener(
                a -> {
                        String input1 = firstInput.getText();
                        String input2 = secondInput.getText();
                        double dInput1 = Double.parseDouble(input1);
                        double dInput2 = Double.parseDouble(input2);
                        double output = 0.0;

                        if(rbAddi.isSelected()){
                            output = dInput1 + dInput2;
                            result.setText(String.valueOf(output));
                        } else if (rbSubt.isSelected()) {
                            output = dInput1 - dInput2;
                            result.setText(String.valueOf(output));
                        } else if (rbMult.isSelected()){
                            output = dInput1 * dInput2;
                            result.setText(String.valueOf(output));
                        } else {
                            output = dInput1 / dInput2;
                            result.setText(String.valueOf(output));
                        }
                }
        );

        //  DISPLAY FRAME
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new Main();
    }
}
