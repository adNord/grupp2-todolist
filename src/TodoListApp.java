import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.BoxLayout;


public class TodoListApp {
    private JFrame frame = new JFrame("Todolist APP");
    private JPanel topPanel = new JPanel();
    private JPanel taskListContainer = new JPanel();
    private JPanel taskBox = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(taskBox);

    // Constructor
    public TodoListApp() {
        setupGUI();
    }

    private void setupGUI() {
        //Funktionalitet och standardstorlek till fönstret
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 480);
        frame.setLayout(new BorderLayout());
        ImageIcon appIcon = new ImageIcon("Pictures/AppIcon.png");
        frame.setIconImage(appIcon.getImage()); //Sätt Ikon för fönstret
        
        //Skapar och lägger till textfält och knapp till topPanel
        JButton addTaskButton = new JButton("Add Task");
        JTextField inputTaskText = new JTextField(20);
        topPanel.add(inputTaskText);
        topPanel.add(addTaskButton);
        
        addTaskButton.addActionListener(e -> {
            addTask(inputTaskText.getText());
            inputTaskText.setText("");
        });
        
        //Lägger till task när man klickar på enter
        inputTaskText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTask(inputTaskText.getText());
                    inputTaskText.setText("");
                }
            }
        });
        
        frame.add(topPanel, BorderLayout.NORTH);
        
        //taskBox är förälder till taskListContainer, som i sin tur är förälder till taskPanel(er) som skapas i addTask
        taskListContainer.setLayout(new BoxLayout(taskListContainer, BoxLayout.Y_AXIS));
        taskBox.setLayout(new BorderLayout());
        taskBox.add(taskListContainer, BorderLayout.NORTH);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        //lägger till deleteAll-knappen till frame så att den inte döljs när taskBox blir för stor
        JButton deleteAll = new JButton("Delete completed tasks");
        frame.add(deleteAll, BorderLayout.SOUTH);
        deleteAll.addActionListener(e -> {
            deleteAllCheckedTasks(taskListContainer);
        });

        frame.setVisible(true);
    }

    private void addTask(String taskText) {
        if (!taskText.isEmpty()) {
            JPanel taskPanel = new JPanel();
            taskPanel.setLayout(new BorderLayout());
            JLabel taskLabel = new JLabel(taskText);
            JCheckBox checkBox = new JCheckBox();
            checkBox.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (checkBox.isSelected()) {      
                taskLabel.setText("<html><strike>" + taskText + "</strike></html>");
                    } else {
                        taskLabel.setText(taskText);
                    }
                }
            });
            JButton deleteButton = new JButton("Delete Task");
            //BYT INTE ORDNIG PÅ DESSA (MYCKET VIKTIGT)
            taskPanel.add(taskLabel, BorderLayout.CENTER);
            taskPanel.add(checkBox, BorderLayout.WEST);
            taskPanel.add(deleteButton, BorderLayout.EAST);

            deleteButton.addActionListener(e -> {
                deleteTask(taskPanel);
            });

            taskListContainer.add(taskPanel);
            taskListContainer.revalidate();
            taskListContainer.repaint();
        }
    }

    //Funktionalitet till deleteButton, tar bort specifik taskPanel
    private void deleteTask(JPanel taskPanel){
        taskListContainer.remove(taskPanel);
        taskListContainer.revalidate();
        taskListContainer.repaint();
    }

    //Funktionalitet till deleteAll, tar bort alla markerade taskPanels.
    private void deleteAllCheckedTasks(JPanel taskListContainer){
        for (Component component : taskListContainer.getComponents()){
            if(component instanceof JPanel){
                JPanel taskPanel = (JPanel) component;
                JCheckBox checkBox = (JCheckBox) taskPanel.getComponent(1);
                if (checkBox.isSelected()) {
                    taskListContainer.remove(taskPanel);
                }
            }
        }
        taskListContainer.revalidate();
        taskListContainer.repaint();
    }

    public static void main(String[] args) {
        // Create an instance of TodoListApp
        new TodoListApp();
    }
}