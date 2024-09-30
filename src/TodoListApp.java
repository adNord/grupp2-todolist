import javax.swing.*;
import java.awt.*;

public class TodoListApp {
    private JFrame frame;

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
    }

    public static void main(String[] args) {
        // Create an instance of TodoListApp
        new TodoListApp();
    }
}