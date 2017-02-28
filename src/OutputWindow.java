import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cesar on 4/02/17.
 */
public class OutputWindow extends JFrame{

    public OutputWindow(){
        super("Meta deseada");
        OutputMatrixComponents(this);
    }

    private JLabel outputLabel = new JLabel();
    private JTextField a1 = new JTextField();
    private JTextField a2 = new JTextField();
    private JTextField a3 = new JTextField();
    private JTextField b1 = new JTextField();
    private JTextField b2 = new JTextField();
    private JTextField b3 = new JTextField();
    private JTextField c1 = new JTextField();
    private JTextField c2 = new JTextField();
    private JTextField c3 = new JTextField();
    private JButton classic = new JButton();
    private JButton impossible = new JButton();
    private JButton clear = new JButton();
    private JButton accept = new JButton();

    private void OutputMatrixComponents(JFrame outputframe){

        outputframe.setSize(new Dimension(400, 400));
        outputframe.setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        outputLabel.setBounds(new Rectangle(130, 15, 220, 21));
        outputLabel.setText("Ingrese la solucion deseada");
        classic.setBounds(new Rectangle(1, 300, 100, 30));
        classic.setText("Clasico");
        impossible.setBounds(new Rectangle(100, 300, 100, 30));
        impossible.setText("Imposible");
        clear.setBounds(new Rectangle(200, 300, 100, 30));
        clear.setText("Limpiar");
        accept.setBounds(new Rectangle(300, 300, 100, 30));
        accept.setText("Aceptar");

        //Output matrix
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
        outputframe.add(outputLabel);
        outputframe.add(classic);
        outputframe.add(impossible);
        outputframe.add(clear);
        outputframe.add(accept);

        //Adding text fields
        outputframe.add(a1);
        outputframe.add(a2);
        outputframe.add(a3);

        outputframe.add(b1);
        outputframe.add(b2);
        outputframe.add(b3);

        outputframe.add(c1);
        outputframe.add(c2);
        outputframe.add(c3);


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

        //Classic
        classic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //Clean boxes first
                a1.setText(null);
                a2.setText(null);
                a3.setText(null);
                b1.setText(null);
                b2.setText(null);
                b3.setText(null);
                c1.setText(null);
                c2.setText(null);
                c3.setText(null);

                //Writes classic
                a1.setText("1");
                a2.setText("2");
                a3.setText("3");
                b1.setText("4");
                b2.setText("5");
                b3.setText("6");
                c1.setText("7");
                c2.setText("8");
                c3.setText(" ");
            }
        });

        //Impossible
        impossible.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //Clean boxes first
                a1.setText(null);
                a2.setText(null);
                a3.setText(null);
                b1.setText(null);
                b2.setText(null);
                b3.setText(null);
                c1.setText(null);
                c2.setText(null);
                c3.setText(null);

                //Writes classic
                a1.setText(" ");
                a2.setText("8");
                a3.setText("7");
                b1.setText("6");
                b2.setText("5");
                b3.setText("4");
                c1.setText("3");
                c2.setText("2");
                c3.setText("1");
            }
        });

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
                        //break;
                    }
                }
                catch (Exception e){
                    failure = true;
                }

                if(failure){
                    JOptionPane.showMessageDialog(null,"Los valores no son correctos, deben ser enteros positivos entre 1 y 8 con solo un espacio vacio", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    outputframe.setVisible(false);
                }
            }
        });


    }
}

