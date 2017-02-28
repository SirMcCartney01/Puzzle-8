import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    public Window(){
        super("Practica 2");
        components(this);
    }

    private void components(JFrame frame){
        frame.setSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        //Menu bar
        JMenuBar myMenu = new JMenuBar();
        JMenu statusMenu = new JMenu("Estado");
        JMenu executeMenu = new JMenu("Ejecutar");
        JMenuItem input = new JMenuItem("Inicio");
        JMenuItem output = new JMenuItem("Meta");
        JMenuItem execute = new JMenuItem("Resolver");


        MyPanel drawPanel = new MyPanel();
        drawPanel.setLayout(new FlowLayout());
        JScrollPane scroll = new JScrollPane(drawPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                             JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        statusMenu.add(input);
        statusMenu.add(output);
        executeMenu.add(execute);

        myMenu.add(statusMenu);
        myMenu.add(executeMenu);

        frame.setJMenuBar(myMenu);

        //Options
        InputWindow startWindow = new InputWindow();
        OutputWindow finalWindow = new OutputWindow();

        input.addActionListener(e -> startWindow.setVisible(true));
        output.addActionListener(e -> finalWindow.setVisible(true));

        container.add(scroll, BorderLayout.CENTER);
    }
}
