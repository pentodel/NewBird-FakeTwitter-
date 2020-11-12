import javax.swing.*;

// Observer pattern here??

public class UserPage extends JFrame {
    Admin instance = Admin.getInstance();

    private JPanel mainPanel;
    private JTextField userToFollowTF;
    private JButton followUserButton;
    private JTextField tweetContentTF;
    private JButton sendTweetButton;
    private JTextArea feedTA;
    private JTextArea FollowingListTA;
    private JButton refreshButton;

    public UserPage(User user) {
        super(user.getId());

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(500,500);
    }
}
