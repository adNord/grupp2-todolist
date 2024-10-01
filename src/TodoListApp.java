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
        //frame.setSize(480, 280);
        frame.setLayout(new BorderLayout());
        
        // Make the frame visible
        frame.setVisible(true);

        topPanel = new JPanel();
        frame.add(topPanel, BorderLayout.NORTH);

        JTextField inputTaskText = new JTextField(20);
        topPanel.add(inputTaskText);

        JButton addTaskButton = new JButton("Add Task");
        topPanel.add(addTaskButton);
        frame.pack();

    }


    public static void main(String[] args) {
        // Create an instance of TodoListApp
        new TodoListApp();
    }
}