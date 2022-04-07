import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Main extends JFrame {

    public Main(){
        super("My GUI app");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menu.add("Open");
        menu.add("Save");
        menu.add("Exit");
        menuBar.add(menu);

        setJMenuBar(menuBar);

        int mazeHeight = 5;
        int mazeWidth = 5;

        GridLayout mazeLayout = new GridLayout(mazeWidth, mazeHeight);

        setLayout(mazeLayout);

        ArrayList<JLabel> maze = new ArrayList<JLabel>();

        for (int i = 0; i < mazeHeight; i++){
            for (int j = 0; j < mazeWidth; j++){
                //System.out.println(i + ", " + j);\
                String location = i + " - " + j;
                JLabel cell = new JLabel(location);
                cell.setHorizontalAlignment(SwingConstants.CENTER);

                Border border = BorderFactory.createMatteBorder(1,1,1,1, Color.black);
                cell.setBorder(border);



                cell.addMouseMotionListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                    }

                    @Override
                    public void mouseMoved(MouseEvent e) {

                        int height = e.getComponent().getHeight();
                        int width = e.getComponent().getWidth();

                        if (e.getComponent().getMousePosition().getY() < (height * .10)){
                            Border topBorder = BorderFactory.createMatteBorder(3,0,0,0, Color.blue);
                            Border otherBorders =BorderFactory.createMatteBorder(0,1,1,1, Color.black);
                            Border border = BorderFactory.createCompoundBorder(topBorder, otherBorders);
                            cell.setBorder(border);
                        } else if (e.getComponent().getMousePosition().getY() > (height - (height * .10))){
                            Border topBorder = BorderFactory.createMatteBorder(0,0,3,0, Color.blue);
                            Border otherBorders =BorderFactory.createMatteBorder(1,1,0,1, Color.black);
                            Border border = BorderFactory.createCompoundBorder(topBorder, otherBorders);
                            cell.setBorder(border);
                        } else if (e.getComponent().getMousePosition().getX() < (width * .10)) {
                            Border topBorder = BorderFactory.createMatteBorder(0,3,0,0, Color.blue);
                            Border otherBorders =BorderFactory.createMatteBorder(1,0,1,1, Color.black);
                            Border border = BorderFactory.createCompoundBorder(topBorder, otherBorders);
                            cell.setBorder(border);
                        } else if (e.getComponent().getMousePosition().getX() > (width - (width * .10))) {
                            Border topBorder = BorderFactory.createMatteBorder(0,0,0,3, Color.blue);
                            Border otherBorders =BorderFactory.createMatteBorder(1,1,1,0, Color.black);
                            Border border = BorderFactory.createCompoundBorder(topBorder, otherBorders);
                            cell.setBorder(border);
                        } else {
                             Border border = BorderFactory.createMatteBorder(1,1,1,1, Color.black);
                             cell.setBorder(border);
                        }
                    }
                });

                cell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseExited(MouseEvent e) {
                        Border border = BorderFactory.createMatteBorder(1,1,1,1, Color.black);
                        cell.setBorder(border);
                    }
                });

                maze.add(cell);
            }
        }

        for ( JLabel cell : maze) {
            add(cell);
        }



        pack();

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args){
        new Main();
    }
}
