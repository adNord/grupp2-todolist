import javax.swing.*;
import java.awt.*;

public class TodoListApp {
    private JFrame frame;

    public static void main(String[] args) {
      
        TodoListApp app = new TodoListApp();
     
        app.setupGUI();
    }

    private void setupGUI() {
      
        frame = new JFrame("Todolist APP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 280);
        frame.setLayout(new BorderLayout());

       
        frame.setVisible(true);
    }
       

