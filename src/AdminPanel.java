import javax.swing.*;

public class AdminPanel extends JFrame {
    Admin instance = Admin.getInstance();

    private JPanel mainPanel;
    private JTree treeViewArea;
    private JButton openUserViewButton;
    private JTextField userIdToAddTF;
    private JTextField groupIdTF;
    private JButton addGroupButton;
    private JButton addUserButton;

    // Visitor for these ?
    private JButton showUserTotalButton;
    private JButton showMessagesTotalButton;
    private JButton posPercentageButton;
    private JButton showGroupTotalButton;

    public AdminPanel(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(800,600);
    }

    public static void main(String[] args) {
        JFrame frame = new AdminPanel("Admin Panel");
        frame.setVisible(true);
    }
}
