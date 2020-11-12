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

    public UserPage(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(800,600);
    }

    public void run(String userid) {
        JFrame frame = new AdminPanel("userid");
        frame.setVisible(true);
    }
}
