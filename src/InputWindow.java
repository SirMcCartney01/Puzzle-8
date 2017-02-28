import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by cesar on 4/02/17.
 */
public class InputWindow extends JFrame{

    public InputWindow(){
        super("Problema de entrada");
        inputMatrixComponents(this);
    }

    private JLabel inputLabel = new JLabel();
    private JTextField a1 = new JTextField();
    private JTextField a2 = new JTextField();
    private JTextField a3 = new JTextField();
    private JTextField b1 = new JTextField();
    private JTextField b2 = new JTextField();
    private JTextField b3 = new JTextField();
    private JTextField c1 = new JTextField();
    private JTextField c2 = new JTextField();
    private JTextField c3 = new JTextField();
    private JButton randGen = new JButton();
    private JButton clear = new JButton();
    private JButton accept = new JButton();

    private void inputMatrixComponents(JFrame inputFrame){

        inputFrame.setSize(new Dimension(400, 400));
        inputFrame.setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        inputLabel.setBounds(new Rectangle(130, 15, 220, 21));
        inputLabel.setText("Ingrese los valores");
        randGen.setBounds(new Rectangle(30, 300, 100, 30));
        randGen.setText("Aleatorio");
        clear.setBounds(new Rectangle(150, 300, 100, 30));
        clear.setText("Limpiar");
        accept.setBounds(new Rectangle(280, 300, 100, 30));
        accept.setText("Aceptar");

        //Input matrix
        a1.setBounds(new Rectangle(130, 90, 30, 30));
        a2.setBounds(new Rectangle(180, 90, 30, 30));
        a3.setBounds(new Rectangle(230, 90, 30, 30));

        b1.setBounds(new Rectangle(130, 140, 30, 30));
        b2.setBounds(new Rectangle(180, 140, 30, 30));
        b3.setBounds(new Rectangle(230, 140, 30, 30));

        c1.setBounds(new Rectangle(130, 190, 30, 30));
        c2.setBounds(new Rectangle(180, 190, 30, 30));
        c3.setBounds(new Rectangle(230, 190, 30, 30));

        //Adding components
        inputFrame.add(accept);
        inputFrame.add(inputLabel);
        inputFrame.add(randGen);
        inputFrame.add(clear);

        //Adding text fields
        inputFrame.add(a1);
        inputFrame.add(a2);
        inputFrame.add(a3);

        inputFrame.add(b1);
        inputFrame.add(b2);
        inputFrame.add(b3);

        inputFrame.add(c1);
        inputFrame.add(c2);
        inputFrame.add(c3);

        //Clear button
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                a1.setText(null);
                a2.setText(null);
                a3.setText(null);
                b1.setText(null);
                b2.setText(null);
                b3.setText(null);
                c1.setText(null);
                c2.setText(null);
                c3.setText(null);
            }
        });

        //Random generation
        randGen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int values[] = new int[9];
                for(int i = 0; i < 9; i++){
                    values[i] = 10;
                }
                boolean fail = false;
                Random rand = new Random();
                for(int i = 0; i < 9; i++){
                    do{
                        int n = rand.nextInt(9);
                        for(int j = 0; j < 9; j++){
                            if(values[j] == n){
                                fail = true;
                                break;
                            }else{
                                fail = false;
                            }
                        }
                        if(!fail){
                            values[i] = n;
                        }
                    }while(fail);
                }

                //Clean boxes before displaying results
                a1.setText(null);
                a2.setText(null);
                a3.setText(null);
                b1.setText(null);
                b2.setText(null);
                b3.setText(null);
                c1.setText(null);
                c2.setText(null);
                c3.setText(null);


                //Fix this shit please
                String a1a = Integer.toString(values[0]);
                String a2a = Integer.toString(values[1]);
                String a3a = Integer.toString(values[2]);
                String b1b = Integer.toString(values[3]);
                String b2b = Integer.toString(values[4]);
                String b3b = Integer.toString(values[5]);
                String c1c = Integer.toString(values[6]);
                String c2c = Integer.toString(values[7]);
                String c3c = Integer.toString(values[8]);

                if(a1a.equals("0"))
                    a1a = " ";
                if(a2a.equals("0"))
                    a2a = " ";
                if(a3a.equals("0"))
                    a3a = " ";
                if(b1b.equals("0"))
                    b1b = " ";
                if(b2b.equals("0"))
                    b2b = " ";
                if(b3b.equals("0"))
                    b3b = " ";
                if(c1c.equals("0"))
                    c1c = " ";
                if(c2c.equals("0"))
                    c2c = " ";
                if(c3c.equals("0"))
                    c3c = " ";


                //Showing results
                a1.setText(a1a);
                a2.setText(a2a);
                a3.setText(a3a);
                b1.setText(b1b);
                b2.setText(b2b);
                b3.setText(b3b);
                c1.setText(c1c);
                c2.setText(c2c);
                c3.setText(c3c);

            }
        });

        //Accept
        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int values[] = new int[9];
                int solved[] = new int[9];

                if(a1.getText().equals(" "))
                    a1.setText("0");
                if(a2.getText().equals(" "))
                    a2.setText("0");
                if(a3.getText().equals(" "))
                    a3.setText("0");
                if(b1.getText().equals(" "))
                    b1.setText("0");
                if(b2.getText().equals(" "))
                    b2.setText("0");
                if(b3.getText().equals(" "))
                    b3.setText("0");
                if(c1.getText().equals(" "))
                    c1.setText("0");
                if(c2.getText().equals(" "))
                    c2.setText("0");
                if(c3.getText().equals(" "))
                    c3.setText("0");

                for(int i = 0; i < 9; i++){
                    solved[i] = i;
                }

                boolean failure = false;
                try{
                    values[0] = Integer.parseInt(a1.getText());
                    values[1] = Integer.parseInt(a2.getText());
                    values[2] = Integer.parseInt(a3.getText());
                    values[3] = Integer.parseInt(b1.getText());
                    values[4] = Integer.parseInt(b2.getText());
                    values[5] = Integer.parseInt(b3.getText());
                    values[6] = Integer.parseInt(c1.getText());
                    values[7] = Integer.parseInt(c2.getText());
                    values[8] = Integer.parseInt(c3.getText());

                    //Verifies if the values are between 0 and 8
                    for(int i = 0; i < 9; i++){
                        if(values[i] < 0 || values[i] > 8){
                            failure = true;
                            break;
                        }else{
                            failure = false;
                        }
                    }

                    //Checks if there aren't repeated values
                    boolean found = false;
                    for(int i = 0; i < 9; i++){
                        for(int j = 0; j < 9; j++){
                            if(values[i] == solved[j]){
                                found = true;
                                solved[j] = 10;
                                break;
                            }else {
                                found = false;
                            }
                        }
                        if(!found)
                            failure = true;
                    }
                }
                catch (Exception e){
                    failure = true;
                }

                if(failure){
                    JOptionPane.showMessageDialog(null,"Los valores no son correctos, deben ser enteros positivos entre 1 y 8 con solo un espacio vacio", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    inputFrame.setVisible(false);
                }
            }
        });
    }

    //Return input matrix
    public int[][] getAllValues(){
        int [][] values = new int[3][3];

        values[0][0] = Integer.parseInt(a1.getText());
        values[0][1] = Integer.parseInt(a2.getText());
        values[0][2] = Integer.parseInt(a3.getText());
        values[1][0] = Integer.parseInt(b1.getText());
        values[1][1] = Integer.parseInt(b2.getText());
        values[1][2] = Integer.parseInt(b3.getText());
        values[2][0] = Integer.parseInt(c1.getText());
        values[2][1] = Integer.parseInt(c2.getText());
        values[2][2] = Integer.parseInt(c2.getText());

        return values;
    }
}