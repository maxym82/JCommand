import frame.FrameMonitor;
import fs.Files;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main {

    private JPanel rootPanel;
    private JTable leftTable;
    private JTable rightTable;
    private JSplitPane tablePanel;

    public static void main(String... args) {
        Main main = new Main();

        JFrame frame = new JFrame("JCommand");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(main.rootPanel);
        frame.pack();
        frame.setVisible(true);

        main.leftTable.setModel(new DefaultTableModel(Files.getFiles(System.getProperty("user.dir")), Files.TABLE_COLUMNS));
        main.rightTable.setModel(new DefaultTableModel(Files.getFiles(System.getProperty("user.dir")), Files.TABLE_COLUMNS));

        FrameMonitor.registerFrame(frame, Main.class.getName(), 10, 10, 10, 10);
    }
}
