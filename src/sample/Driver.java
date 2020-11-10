package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Driver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ArrayList<UserInterface> treeRoot = new ArrayList<UserInterface>();
        TreeView treeView = new TreeView();
        for (UserInterface user : treeRoot) {
            if (user instanceof User) {

            }
        }

        VBox treeMenu = new VBox();
        VBox rightSize = new VBox();



        Scene scene = new Scene(treeMenu, 600, 400);
        primaryStage.setTitle("NewBird - Admin Panel");
        primaryStage.setScene(scene);



        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
