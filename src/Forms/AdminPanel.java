package Forms;
import Admin.*;
import Users.*;
import Visitor.*;
import Tweets.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminPanel extends JFrame {
    Admin instance = Admin.getInstance();

    private JPanel mainPanel;
    private JTree tree;
    private JButton openUserViewButton;
    private JTextField userIdToAddTF;
    private JTextField groupIdTF;
    private JButton addGroupButton;
    private JButton addUserButton;
    private JButton showUserTotalButton;
    private JButton showMessagesTotalButton;
    private JButton posPercentageButton;
    private JButton showGroupTotalButton;




    public AdminPanel(String title) {
        super(title);
        final AdminPanel parent = this;

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new UserGroup("Root"));
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        model.setRoot(root);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(800,600);

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = userIdToAddTF.getText();
                if (id.length() == 0) {
                    JOptionPane.showMessageDialog(parent, "Please enter a UserID!");
                    return;
                }
                if (tree.getSelectionPath() == null) {
                    JOptionPane.showMessageDialog(parent, "A group must be selected to add a user.");
                    return;
                }

                userIdToAddTF.setText("");
                DefaultMutableTreeNode group = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                if (group.getUserObject() instanceof UserGroup) {
                    User newUser = instance.createUser(id, (UserGroup) group.getUserObject());
                    if (newUser == null) return;
                    DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
                    DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
                    group.add(new DefaultMutableTreeNode(newUser));
                    model.reload(root);
                    expandAllNodes(tree, 0, tree.getRowCount());
                } else {
                    JOptionPane.showMessageDialog(parent, "A group must be selected to add a user.");
                }
            }
        });

        addGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = groupIdTF.getText();
                if (id.length() == 0) {
                    JOptionPane.showMessageDialog(parent, "Please enter a GroupID!");
                    return;
                }
                if (tree.getSelectionPath() == null) {
                    JOptionPane.showMessageDialog(parent, "A group must be selected to add a new group.");
                    return;
                }

                groupIdTF.setText("");
                DefaultMutableTreeNode group = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                if (group.getUserObject() instanceof UserGroup) {
                    UserGroup newGroup = instance.createGroup(id, (UserGroup) group.getUserObject());
                    if (newGroup == null) return;
                    DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
                    DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
                    group.add(new DefaultMutableTreeNode(newGroup));
                    model.reload(root);
                    expandAllNodes(tree, 0, tree.getRowCount());
                } else {
                    JOptionPane.showMessageDialog(parent, "A group must be selected to add a new group.");
                }
            }
        });

        showUserTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Visitor v = new UserCountVisitor();
                User dummyUser = new User();
                int count = dummyUser.accept(v);
                JOptionPane.showMessageDialog(parent, "There are " + count + " users.");
            }
        });

        showGroupTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Visitor v = new GroupCountVisitor();
                UserGroup dummyGroup = new UserGroup();
                int count = dummyGroup.accept(v);
                JOptionPane.showMessageDialog(parent, "There are " + count + " groups.");
            }
        });

        showMessagesTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Visitor v = new TweetCountVisitor();
                Tweet dummyTweet = new Tweet();
                int count = dummyTweet.accept(v);
                JOptionPane.showMessageDialog(parent, "There are " + count + " tweets.");
            }
        });

        posPercentageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Visitor v = new PosPercentVisitor();
                PosTweets dummyPosTweets = PosTweets.getInstance();
                int count = dummyPosTweets.accept(v);
                JOptionPane.showMessageDialog(parent, count + "% of tweets are positive.");
            }
        });
        openUserViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tree.getSelectionPath() == null) {
                    JOptionPane.showMessageDialog(parent, "A user has not been selected.");
                    return;
                }
                DefaultMutableTreeNode user = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                if (user.getUserObject() instanceof User) {
                    JFrame frame = new UserPage((User) user.getUserObject());
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(parent, "You have selected a group. Please select a user.");
                }
            }
        });
    }

    private void expandAllNodes(JTree tree, int startingIndex, int rowCount){
        for(int i=startingIndex;i<rowCount;++i){
            tree.expandRow(i);
        }

        if(tree.getRowCount()!=rowCount){
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new AdminPanel("Admin Panel");
        frame.setVisible(true);
    }
}
