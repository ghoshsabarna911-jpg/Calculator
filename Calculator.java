import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Calculator{
        int length=540;
        int width=520;

        Color customlightgrey = new Color(212, 212, 220);
        Color customtgrey = new Color(80, 80, 80);
        Color customblack = new Color(28, 28, 28);
        Color customorange = new Color(255, 149, 0);

    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};



    JFrame frame = new JFrame("calculator");
        JPanel displaypanel = new JPanel();
        JLabel displaylabel = new JLabel();
        JPanel numberpanel = new JPanel();

        String A = "0";
        String operator = null;
        String B = null;

        Calculator (){
            frame.setVisible(true);
            frame.setSize(width, length);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());
            displaylabel.setBackground(customblack);
            displaylabel.setForeground(Color.white);
            displaylabel.setFont(new Font("Arial", Font.PLAIN, 80));
            displaylabel.setHorizontalAlignment(JLabel.RIGHT);
            displaylabel.setText("0");
            displaylabel.setOpaque(true);

            displaypanel.setLayout(new BorderLayout());
            displaypanel.add(displaylabel);
            frame.add(displaypanel, BorderLayout.NORTH);

            numberpanel.setLayout(new GridLayout(5, 4));
            numberpanel.setBackground(customblack);
            frame.add(numberpanel);

            for (int i=0; i < buttonValues.length; i++) {
                JButton button = new JButton();
                String buttonvalue = buttonValues[i];
                button.setFont(new Font("Arial", Font.PLAIN, 30));
                button.setText(buttonvalue);
                button.setFocusable(false);
                button.setBorder(new LineBorder(customblack));

            if (Arrays.asList(topSymbols).contains(buttonvalue)){
                button.setBackground(customlightgrey);
                button.setForeground(customblack);
            }
            else if (Arrays.asList(rightSymbols).contains(buttonvalue)){
                button.setBackground(customorange);
                button.setForeground(Color.white);
            }
            else{
                button.setBackground(customtgrey);
                button.setForeground(Color.white);
            }
                numberpanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String buttonvalue = button.getText();
                    if (Arrays.asList(rightSymbols).contains(buttonvalue)){
                        if (buttonvalue=="="){
                            if(A!=null){
                                B = displaylabel.getText();
                                Double num1 = Double.parseDouble(A);
                                Double num2 = Double.parseDouble(B);
                                if (operator == "+"){
                                    displaylabel.setText(removedeci(num1+num2));
                                         continueAll();
                                }
                                else if (operator == "-"){
                                    displaylabel.setText(removedeci(num1-num2));
                                         continueAll();
                                }
                                else if (operator=="×"){
                                    displaylabel.setText(removedeci(num1*num2));
                                         continueAll();
                                }
                                else if (operator=="÷"){
                                    displaylabel.setText(removedeci(num1/num2));
                                         continueAll();
                                }
                            }

                        }
                        else if("+-×÷".contains(buttonvalue)){
                            if(operator== null){
                                A = displaylabel.getText();
                                displaylabel.setText("0");
                                B="0";
                            }
                            operator=buttonvalue;
                        }

                    }
                    else if(Arrays.asList(topSymbols).contains(buttonvalue)){
                        if (buttonvalue == "AC"){
                            ClearAll() ;
                            displaylabel.setText("0");

                        }
                        else if (buttonvalue == "+/-"){
                            Double numd = Double.parseDouble(displaylabel.getText());
                            numd *= -1;
                            displaylabel.setText(removedeci(numd));
                        }
                        else if(buttonvalue == "%"){
                            Double numd = Double.parseDouble(displaylabel.getText());
                            numd /= 100;
                            displaylabel.setText(removedeci(numd));
                        }

                    }
                    else {
                        if (buttonvalue == ".") {
                            if (!displaylabel.getText().contains(buttonvalue)) {
                                displaylabel.setText(displaylabel.getText() + buttonvalue);
                            }
                        }
                        else if (buttonvalue == "√") {
                            Double num = Double.parseDouble(displaylabel.getText());
                            num = Math.sqrt(num);
                            displaylabel.setText(removedeci(num));}

                        if ("0123456789".contains(buttonvalue)) {
                                if (displaylabel.getText() == "0") {
                                    displaylabel.setText(buttonvalue);
                                } else {
                                    displaylabel.setText(displaylabel.getText() + buttonvalue);
                                }
                            }

                    }

            }



        });
            }
        }

     void ClearAll(){
            A = "0";
            operator=null;
            B=null;;
     }
      void continueAll(){
            A= displaylabel.getText();
            operator=null;
            B=null;

     }
    String removedeci(double numd){
            if (numd%1 == 0){
                return Integer.toString((int) numd);

            }
            return Double.toString(numd);
    }



            }









