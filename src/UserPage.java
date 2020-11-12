import javax.swing.*;

// Observer pattern here??

public class UserPage extends JFrame {
    private JPanel mainPanel;
    private JTextField userToFollowTF;
    private JButton followUserButton;
    private JTextField tweetContentTF;
    private JButton sendTweetButton;
    private JTextArea feedTA;
    private JTextArea FollowingListTA;

    public UserPage(User user) {
        super(user.getId());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(800,600);
    }
}
