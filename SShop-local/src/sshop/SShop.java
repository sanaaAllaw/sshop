/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

import java.awt.AWTException;
import java.sql.Connection;
import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author skynete
 */
public class SShop extends Application {
    
    static HashMap<String,String> CompListinfo;
    //Conn connectionvar=new Conn();
    JDBCMysql jdbcConn=new JDBCMysql();
    generalFunc generalfuncvar=new generalFunc();
    //static Connection conn ;
    static Connection connmysql ;
    @Override
    public void start(Stage primaryStage) throws AWTException {
       
        generalFunc.minimizeApps();
        //conn=connectionvar.connect();
        connmysql=JDBCMysql.connectmysql();
        //==============declare variables and components
        CompListinfo=new HashMap<>();
        //CompListinfo=generalFunc.GetCompanyInfo();
        BorderPane root = new BorderPane();
        VBox vbox1=new VBox();
        BorderPane border1=new BorderPane();
        GridPane grid1=new GridPane();
        grid1.setHgap(10);
        grid1.setVgap(10);
        HBox hbox1=new HBox();
        ImageView imgview1=new ImageView();
        ImageView imgview2=new ImageView();
        Label lb1=new Label("company name");
        Label lb2=new Label("address");
        Label lb3=new Label("phone");
        lb1.setId("titles");
        lb2.setId("titles");
        lb3.setId("titles");
        GridPane grid2=new GridPane();
        grid2.setHgap(10);
        grid2.setVgap(10);
        Label userlbl=new Label("Username");
        Label passlbl=new Label("Password");
        Label error=new Label("");
        error.setId("error");
        userlbl.setId("usr");
        passlbl.setId("usr");
        TextField usertxt=new TextField();
        PasswordField passtxt =new PasswordField();
        usertxt.setPrefWidth(200);
        passtxt.setPrefWidth(200);
        Button loginbtn=new Button("Login");
        loginbtn.setId("rich-blue");
         passtxt.setOnKeyPressed((KeyEvent ke) -> {
             if (ke.getCode().equals(KeyCode.ENTER))
             {
                 loginbtn.fire();
             }
        });
        //==============end declare variables and components
        //================assign items to parents
        root.setCenter(vbox1);
        vbox1.getChildren().add(border1);
        vbox1.getChildren().add(grid1);
        
        border1.setLeft(hbox1);
        border1.setRight(imgview1);
        hbox1.getChildren().add(imgview2);
        hbox1.getChildren().add(grid2);
        grid2.add(lb1, 1, 1);
        grid2.add(lb2, 1,2);
        grid2.add(lb3, 1, 3);
        grid1.add(userlbl, 5, 3);
        grid1.add(passlbl, 5, 4);
        grid1.add(usertxt, 6, 3);
        grid1.add(passtxt, 6, 4);
        grid1.add(loginbtn, 5, 8);
        grid1.add(error, 6, 8);
        //================end assign items to parents
        //=========add values to labels
        /*lb1.setText("Name: "+CompListinfo.get("name"));
        lb2.setText("Address: "+CompListinfo.get("address"));
        lb3.setText("Capital: "+CompListinfo.get("capital"));*/
        loginbtn.setOnAction((ActionEvent event) -> {
             if(generalFunc.checkLogin(usertxt.getText(), passtxt.getText())==true){
                 error.setText("Succeful login");
                 primaryStage.close();
                 Home h1=new Home();
                 h1.start(Constantes.StageMenu);
             }else{
                 error.setText("Wrong login");
             }
        });
        //===========end add values to labels
        imgview1.setImage(new Image("/pictures/Girls-Red-Dress-icon.png"));
        imgview2.setImage(new Image("/pictures/Girls-Blue-Dress-icon.png"));
        //CompListinfo=generalFunc.GetCompanyInfo();
        Scene scene = new Scene(root, 500, 350);
        String cssURL = this.getClass().getResource("/css/sshop.css").toExternalForm();
        scene.getStylesheets().add(cssURL);
        primaryStage.setMaximized(false);
        primaryStage.setResizable(false);
        primaryStage.setTitle("SShop");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/pictures/Girls-Blue-Dress-icon.png")));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }
    public boolean checkUserName(String usertext,String passtext){
        Boolean ResBool=true;
        return ResBool;
    }
}
