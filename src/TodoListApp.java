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
        taskBox.add(taskListContainer, BorderLayout.NORTH);
        frame.add(taskBox, BorderLayout.CENTER);

        JButton deleteAll = new JButton("Delete All");
        taskBox.add(deleteAll, BorderLayout.SOUTH);
        deleteAll.addActionListener(e -> deleteAllCheckedTasks(taskListContainer));

        JButton addTaskButton = new JButton("Add Task");
        topPanel.add(addTaskButton);
        addTaskButton.addActionListener(e -> {
            String taskText = inputTaskText.getText();
            if (taskText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Task cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            addTask(taskText);
            inputTaskText.setText("");
        });

        frame.setVisible(true);
    }

    private void addTask(String taskText) {
        if (!taskText.isEmpty()) {
            JPanel taskPanel = createTaskPanel(taskText);
            taskListContainer.add(taskPanel);
            taskListContainer.revalidate();
            taskListContainer.repaint();
        }
    }

    private JPanel createTaskPanel(String taskText) {
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BorderLayout());
        JLabel taskLabel = new JLabel(taskText);
        JCheckBox checkBox = new JCheckBox();
        JButton deleteButton = new JButton("Delete Task");

        // Listener for check box
        checkBox.addActionListener(e -> {
            if (checkBox.isSelected()) {
                taskLabel.setText("<html><strike>" + taskText + "</strike></html>");
            } else {
                taskLabel.setText(taskText);
            }
        });

        taskPanel.add(taskLabel, BorderLayout.CENTER);
        taskPanel.add(checkBox, BorderLayout.WEST);
        taskPanel.add(deleteButton, BorderLayout.EAST);

        deleteButton.addActionListener(e -> deleteTask(taskPanel));

        return taskPanel;
    }

    private void deleteTask(JPanel taskPanel) {
        taskListContainer.remove(taskPanel);
        taskListContainer.revalidate();
        taskListContainer.repaint();
    }

    private void deleteAllCheckedTasks(JPanel taskListContainer) {
        for (Component component : taskListContainer.getComponents()) {
            if (component instanceof JPanel) {
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
        new TodoListApp();
    }
}