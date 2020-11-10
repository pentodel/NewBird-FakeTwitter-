public class Tweet {
    private String content;
    private User poster;

    public Tweet(String content, User poster) {
        this.content = content;
        this.poster = poster;
    }

    public String getContent() {
        return content;
    }

    public User getPoster() {
        return poster;
    }
}
