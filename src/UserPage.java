import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// Observer pattern here??

public class UserPage extends JFrame {
    Admin instance = Admin.getInstance();

    private JPanel mainPanel;
    private JTextField userToFollowTF;
    private JButton followUserButton;
    private JTextField tweetContentTF;
    private JButton sendTweetButton;
    private JTextArea feedTA;
    private JTextArea followingListTA;
    private JButton refreshButton;
    private JLabel followingLabel;
    private JLabel followersLabel;

    public UserPage(final User user) {
        super(user.getId());

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(500,500);

        feedTA.setText(user.tweetFeedInText());
        followingListTA.setText(user.followingsInText());


        followUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = userToFollowTF.getText();
                if (id.length() == 0 || id.equals("Username...")) {
                    JOptionPane.showMessageDialog(null, "Please enter a username!");
                    return;
                }
                userToFollowTF.setText("");
                User u = instance.findUser(id);
                if (u == null) {
                    JOptionPane.showMessageDialog(null, "User not found.");
                    return;
                }
                boolean worked = instance.followUser(user, u);
                if (worked) JOptionPane.showMessageDialog(null, "Followed " + id + "!");
                refresh(user);
            }
        });

        sendTweetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = tweetContentTF.getText();
                if (content.length() == 0 || content.equals("Type a new tweet here...")) {
                    JOptionPane.showMessageDialog(null, "Please enter a new tweet!");
                    return;
                }
                tweetContentTF.setText("");
                instance.addTweet(content, user);
                JOptionPane.showMessageDialog(null, "Posted tweet!");

                refresh(user);
            }
        });



        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh(user);
            }
        });

    }

    public void refresh(User user) {
        feedTA.setText(user.tweetFeedInText());
        followingListTA.setText(user.followingsInText());
        followingLabel.setText("Following: " + user.followingCount());
        followersLabel.setText("Followers: " + user.followerCount());

    }
}
