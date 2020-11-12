import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JLabel DisplayNumber;

    public AdminPanel(String title) {
        super(title);
        final AdminPanel parent = this;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(800,600);

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = userIdToAddTF.getText();
                if (id.length() == 0) return;
                if (treeViewArea.getSelectionPath() == null) {
                    JOptionPane.showMessageDialog(parent, "A group must be selected to add a user.");
                    return;
                }
                UserGroup group = (UserGroup) treeViewArea.getSelectionPath().getLastPathComponent();
                if (false) {
//                if (group instanceof UserGroup) {
                      instance.createUser(id, group);
                } else {
                    JOptionPane.showMessageDialog(parent, "A group must be selected to add a user.");
                }
            }
        });

        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = groupIdTF.getText();
                if (id.length() == 0) return;
                if (treeViewArea.getSelectionPath() == null) {
                    JOptionPane.showMessageDialog(parent, "A group must be selected to add a new group.");
                    return;
                }
                UserGroup group = (UserGroup) treeViewArea.getSelectionPath().getLastPathComponent();
                if (false) {
//                if (group instanceof UserGroup) {
                    instance.createUser(id, group);
                } else {
                    JOptionPane.showMessageDialog(parent, "A group must be selected to add a new group.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new AdminPanel("Admin Panel");
        frame.setVisible(true);
    }
}
