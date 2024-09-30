import javax.swing.*;
import java.awt.*;

public class TodoListApp {
    private JFrame frame;

    private TodoListApp() {
      
        frame = new JFrame("TodolistAPP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 280);
        frame.setLayout(new BorderLayout());

       
        frame.setVisible(true);
    }
    public static void main(String[] args) {
      
        new TodoListApp();
     
    }

    
       

