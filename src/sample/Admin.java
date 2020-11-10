package sample;

public class Admin {
    // Eager instantiation
    // Since an instance of this class must necessarily be created when the program is run
    // it is fine just to create the instance of it right off the bat.
    private static Admin instance = new Admin();

    private Admin(){}

    public static Admin getInstance() {
        return instance;
    }




}
