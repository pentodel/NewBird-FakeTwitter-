// Composite

package sample;

public class UserGroup implements UserInterface {
    private String id;
    private UserGroup parent;

    @Override
    public String getId() {
        return id;
    }
}
