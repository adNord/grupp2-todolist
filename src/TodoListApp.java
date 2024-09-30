import javax.swing.*;
import java.awt.*;

public class TodoListApp {
    private JFrame frame;
    private JPanel topPanel;

    // Constructor
    public TodoListApp() {
        setupGUI();
    }

    private void setupGUI() {
        frame = new JFrame("Todolist APP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 280);
        frame.setLayout(new BorderLayout());
        
        // Make the frame visible
        frame.setVisible(true);

        topPanel = new JPanel();
        topPanel.setBackground(Color.BLUE);
        //topPanel.setBounds(20, 20, 100, 100);
        frame.add(topPanel, BorderLayout.NORTH);
    }



    public static void main(String[] args) {
        // Create an instance of TodoListApp
        new TodoListApp();
    }
}