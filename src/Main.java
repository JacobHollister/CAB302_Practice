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

        ArrayList<Block> maze = new ArrayList<Block>();

        for (int i = 0; i < mazeHeight; i++){
            for (int j = 0; j < mazeWidth; j++){
                int[] location = new int[]{i, j};
                Block block = new Block(location, (i * mazeHeight + j));

                JLabel cell = block.getLabel();

                maze.add(block);
            }
        }

        for (Block block : maze) {

            block.label.addMouseMotionListener(new MouseAdapter() {
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

                    Block northBlock = maze.get(maze.indexOf(block) - mazeWidth);
                    Block southBlock = maze.get(maze.indexOf(block) + mazeWidth);
                    Block westBlock = maze.get(maze.indexOf(block) - 1);
                    Block eastBlock = maze.get(maze.indexOf(block) + 1);

                    Border northBorder = BorderFactory.createCompoundBorder(
                            BorderFactory.createMatteBorder(3,0,0,0, Color.blue),
                            BorderFactory.createMatteBorder(0,1,1,1, Color.black)
                    );
                    Border southBorder = BorderFactory.createCompoundBorder(
                            BorderFactory.createMatteBorder(0,0,3,0, Color.blue),
                            BorderFactory.createMatteBorder(1,1,0,1, Color.black)
                    );
                    Border westBorder = BorderFactory.createCompoundBorder(
                            BorderFactory.createMatteBorder(0,3,0,0, Color.blue),
                            BorderFactory.createMatteBorder(1,0,1,1, Color.black)
                    );
                    Border eastBorder = BorderFactory.createCompoundBorder(
                            BorderFactory.createMatteBorder(0,0,0,3, Color.blue),
                            BorderFactory.createMatteBorder(1,1,1,0, Color.black)
                    );

                    if (e.getComponent().getMousePosition().getY() < (height * .05)){
                        block.setNorthWall();
                        northBlock.setSouthWall();
                    } else if (e.getComponent().getMousePosition().getY() > (height - (height * .05))){
                        block.setSouthWall();
                        southBlock.setNorthWall();
                    } else if (e.getComponent().getMousePosition().getX() < (width * .05)) {
                        block.setWestWall();
                        westBlock.setEastWall();
                    } else if (e.getComponent().getMousePosition().getX() > (width - (width * .05))) {
                        block.setEastWall();
                        eastBlock.setWestWall();
                    } else {
                        Border border = BorderFactory.createMatteBorder(1,1,1,1, Color.black);
                        block.resetWalls();
                        northBlock.resetWalls();
                        southBlock.resetWalls();
                        westBlock.resetWalls();
                        eastBlock.resetWalls();
                    }
                }
            });

            block.label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    Block northBlock = maze.get(maze.indexOf(block) - mazeWidth);
                    Block southBlock = maze.get(maze.indexOf(block) + mazeWidth);
                    Block westBlock = maze.get(maze.indexOf(block) - 1);
                    Block eastBlock = maze.get(maze.indexOf(block) + 1);

                    Border border = BorderFactory.createMatteBorder(1,1,1,1, Color.black);

                    block.resetWalls();
                    northBlock.resetWalls();
                    southBlock.resetWalls();
                    westBlock.resetWalls();
                    eastBlock.resetWalls();

                }
            });
        }

        for ( Block block : maze) {
            add(block.label);
        }



        pack();

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}
