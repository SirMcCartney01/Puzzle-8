import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPanel extends JPanel{


    public MyPanel(){
        super();
        initPanel(this);
    }

    private void initPanel(JPanel panel)  {
        panel.setBackground(Color.DARK_GRAY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        FontMetrics fm = g.getFontMetrics();

        Dimension size = getPreferredSize();
        String text = "Pref: " + size.width + "x" + size.height;
        g.drawString(text, 0, fm.getAscent());

        size = getSize();
        text = "Size: " + size.width + "x" + size.height;
        g.drawString(text, 0, fm.getHeight() + fm.getAscent());


        Rectangle[][] recs = new Rectangle[3][3];

        int axisX = 355, axisY = 15;
        int aux = 0;

        for (int i = 0; i < recs.length; i++) {
            for (int j = 0; j < recs.length; j++) {

                //Drawing Squares
                g2.setColor(new Color(117, 35, 37));
                g2.setStroke(new BasicStroke(2));
                g2.fillRect(axisX, axisY, 30, 30);
                g2.setColor(Color.BLACK);
                g2.drawRect(axisX, axisY, 30, 30);

                //Painting labels
                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Monospaced", Font.BOLD, 12));
                if(aux == 0){
                    g2.drawString(" ", (axisX + 10), (axisY + 20));
                }else{
                    g2.drawString(""+aux, (axisX + 10), (axisY + 20));
                }


                axisY = axisY + 30;
                aux++;
            }
            axisY = axisY - 90;
            axisX = axisX + 30;
        }
    }
}
