import java.awt.*;
import javax.swing.*;


public class TodoListApp {
    private JFrame frame;
    private JPanel topPanel;
    private JPanel taskListContainer = new JPanel();
    private JPanel taskBox = new JPanel();

    // Constructor
    public TodoListApp() {
        setupGUI();
    }

    private void setupGUI() {
        frame = new JFrame("Todolist APP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 480);
        frame.setLayout(new BorderLayout());

        topPanel = new JPanel();
        frame.add(topPanel, BorderLayout.NORTH);

        ImageIcon appIcon = new ImageIcon("Pictures/AppIcon.png");
        frame.setIconImage(appIcon.getImage());


        JTextField inputTaskText = new JTextField(20);
        topPanel.add(inputTaskText);

        taskBox.setLayout(new BorderLayout());

        taskListContainer.setLayout(new BoxLayout(taskListContainer, BoxLayout.Y_AXIS));
        //taskListContainer.setSize(200, 200);
        taskBox.add(taskListContainer, BorderLayout.NORTH);
        frame.add(taskBox, BorderLayout.CENTER);

        JButton deleteAll = new JButton("delete all");
        taskBox.add(deleteAll, BorderLayout.SOUTH);
        deleteAll.addActionListener(e -> {
            deleteAllCheckedTasks(taskListContainer);
        });

        JButton addTaskButton = new JButton("Add Task");
        topPanel.add(addTaskButton);
        addTaskButton.addActionListener(e -> {
            addTask(inputTaskText.getText());
            inputTaskText.setText("");
        });

        frame.setVisible(true);
    }

    private void addTask(String taskText) {
        if (!taskText.isEmpty()) {
            JPanel taskPanel = new JPanel();
            taskPanel.setLayout(new BorderLayout());
            //taskPanel.setPreferredSize(new Dimension(380,30));
            JLabel taskLabel = new JLabel(taskText);
            JCheckBox checkBox = new JCheckBox();
            taskPanel.add(taskLabel, BorderLayout.CENTER);
            taskPanel.add(checkBox, BorderLayout.WEST);
            taskPanel.add(deleteButton, BorderLayout.EAST);

            deleteButton.addActionListener(e -> {
                System.out.println("delete knapptryck");
                deleteTask(taskPanel);
            });

            //BYT INTE ORDNIG PÅ DESSA (MYCKET VIKTIGT)
            taskListContainer.add(taskPanel);
            taskListContainer.revalidate();
            taskListContainer.repaint();
            

        }
    }



    public static void main(String[] args) {
        // Create an instance of TodoListApp
        new TodoListApp();
    }
}