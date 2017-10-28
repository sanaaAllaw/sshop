/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sshop;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author skynete
 */
public class Currency extends Application{
    private final TableView<currencyclass> table = new TableView<>();
    private final ObservableList<currencyclass> data =
        FXCollections.observableArrayList(new currencyclass("asdasd", STYLESHEET_MODENA, 
                STYLESHEET_MODENA, Double.NaN, Double.NaN, STYLESHEET_MODENA));
    @Override
    public void start(Stage primaryStage) {
        //===========================================
        VBox v1=new VBox();
        HBox h1=new HBox();
        
        GridPane buttonsMenu=new GridPane();
        buttonsMenu.setVgap(10);
        buttonsMenu.setHgap(10);
        Button btnMenu1=new Button("Accept");btnMenu1.setPrefWidth(150);btnMenu1.setId("rich-blue");
        btnMenu1.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/accept.png"))));
        Button btnMenu2=new Button("Cancel");btnMenu2.setPrefWidth(150);btnMenu2.setId("rich-blue");
        btnMenu2.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/cancel.png"))));
        Button btnMenu3=new Button("New");btnMenu3.setPrefWidth(150);btnMenu3.setId("rich-blue");
        btnMenu3.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/new.png"))));
        Button btnMenu4=new Button("First");btnMenu4.setPrefWidth(150);btnMenu4.setId("rich-colored");
        btnMenu4.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/first.png"))));
        Button btnMenu5=new Button("Previous");btnMenu5.setPrefWidth(150);btnMenu5.setId("rich-colored");
        btnMenu5.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/previous.png"))));
        Button btnMenu6=new Button("Next");btnMenu6.setPrefWidth(150);btnMenu6.setId("rich-colored");
        btnMenu6.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/next.png"))));
        Button btnMenu7=new Button("Last");btnMenu7.setPrefWidth(150);btnMenu7.setId("rich-colored");
        btnMenu7.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/pictures/last.png"))));
        buttonsMenu.add(btnMenu1, 1, 1);
        buttonsMenu.add(btnMenu2, 2, 1);
        buttonsMenu.add(btnMenu3, 3, 1);
        buttonsMenu.add(btnMenu4, 4, 1);
        buttonsMenu.add(btnMenu5, 5, 1);
        buttonsMenu.add(btnMenu6, 6, 1);
        buttonsMenu.add(btnMenu7, 7, 1);
        //===================================================================================
        GridPane appendgrid=new GridPane();
        appendgrid.setVgap(10);
        appendgrid.setHgap(10);
        Label appendlbl1=new Label("Currency Code");
        Label appendlbl2=new Label("Currency Name");
        Label appendlbl3=new Label("Secondary Name");
        Label appendlbl4=new Label("Numeric Code");
        Label appendlbl5=new Label("Minimum Rate");
        Label appendlbl6=new Label("Maximum Rate");
        TextField appendtxt1=new TextField();
        TextField appendtxt2=new TextField();
        TextField appendtxt3=new TextField();
        TextField appendtxt4=new TextField();
        TextField appendtxt5=new TextField();
        TextField appendtxt6=new TextField();
        appendgrid.add(appendlbl1, 1, 1);appendgrid.add(appendtxt1, 2, 1);
        appendgrid.add(appendlbl2, 1, 5);appendgrid.add(appendtxt2, 2, 5);
        appendgrid.add(appendlbl3, 1, 9);appendgrid.add(appendtxt3, 2, 9);
        appendgrid.add(appendlbl4, 3, 1);appendgrid.add(appendtxt4, 4, 1);
        appendgrid.add(appendlbl5, 3, 5);appendgrid.add(appendtxt5, 4, 5);
        appendgrid.add(appendlbl6, 3, 9);appendgrid.add(appendtxt6, 4, 9);
        //===================================table view
        table.setPrefWidth(400);
        TableColumn CurrencyCodeCol = new TableColumn("Currency Code");
        CurrencyCodeCol.setMinWidth(100);
        CurrencyCodeCol.setCellValueFactory(new PropertyValueFactory<>("Currency_Code"));
        
        TableColumn CurrencyNameCol = new TableColumn("Currency Name");
        CurrencyNameCol.setMinWidth(100);
        CurrencyNameCol.setCellValueFactory(new PropertyValueFactory<>("Currency_Name"));
        
        TableColumn SecondaryNameCol = new TableColumn("Secondary Name");
        SecondaryNameCol.setMinWidth(200);
        SecondaryNameCol.setCellValueFactory(new PropertyValueFactory<>("Secondary_Name"));
        
        TableColumn MaxRateCol = new TableColumn("Max Rate");
        MaxRateCol.setMinWidth(200);
        MaxRateCol.setCellValueFactory(new PropertyValueFactory<>("Max_Rate"));
        
        TableColumn MinRateCol = new TableColumn("Min Rate");
        MinRateCol.setMinWidth(200);
        MinRateCol.setCellValueFactory(new PropertyValueFactory<>("Min_Rate"));
        
        TableColumn BaseOperCol = new TableColumn("Base Operator");
        BaseOperCol.setMinWidth(200);
        BaseOperCol.setCellValueFactory(new PropertyValueFactory<>("Base_Oper"));
        
        table.setItems(data);
        table.getColumns().addAll(CurrencyCodeCol, CurrencyNameCol, SecondaryNameCol,MaxRateCol,MinRateCol,BaseOperCol);
        //====================================end table view
        h1.getChildren().add(appendgrid);
        h1.getChildren().add(table);
        //===================================================================================
        v1.getChildren().addAll(buttonsMenu,h1);
        //============================================
        
        StackPane root = new StackPane();
        root.getChildren().add(v1);
        
        Scene scene = new Scene(root, Constantes.primScreenBounds.getWidth()-200-10,
                (Constantes.primScreenBounds.getHeight()-Constantes.taskBarHeight)/2);
        String cssURL = this.getClass().getResource("/css/supplier.css").toExternalForm();
        scene.getStylesheets().add(cssURL);
        primaryStage.setX(200+10);
        primaryStage.setY(0);
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    class currencyclass{
        private final SimpleStringProperty Currency_Code;
        private final SimpleStringProperty Currency_Name;
        private final SimpleStringProperty Secondary_Name;
        private final SimpleDoubleProperty Max_Rate;
        private final SimpleDoubleProperty Min_Rate;
        private final SimpleStringProperty Base_Oper;
        
        private currencyclass(String Currency_Code, String Currency_Name, String Secondary_Name,
                Double Max_Rate,Double Min_Rate,String Base_Oper) {
            this.Currency_Code = new SimpleStringProperty(Currency_Code);
            this.Currency_Name = new SimpleStringProperty(Currency_Name);
            this.Secondary_Name = new SimpleStringProperty(Secondary_Name);
            this.Max_Rate=new SimpleDoubleProperty(Max_Rate);
            this.Min_Rate=new SimpleDoubleProperty(Min_Rate);
            this.Base_Oper = new SimpleStringProperty(Base_Oper);
        }
        
        public String getCurrencyCode() {
            return Currency_Code.get();
        }
        public void setCurrencyCode(String CurrCode) {
            Currency_Code.set(CurrCode);
        }
        public String getCurrencyName() {
            return Currency_Name.get();
        }
        public void setCurrencyName(String CurrName) {
            Currency_Name.set(CurrName);
        }
        public String getSecondaryName() {
            return Secondary_Name.get();
        }
        public void setSecondaryName(String SecName) {
            Secondary_Name.set(SecName);
        }
        public Double getMaxRate() {
            return Max_Rate.get();
        }
        public void setMaxRate(Double MaxRa) {
            Max_Rate.set(MaxRa);
        }
        public Double getMinRate() {
            return Min_Rate.get();
        }
        public void setMinRate(Double MinRa) {
            Min_Rate.set(MinRa);
        }
        public String getBaseOper() {
            return Base_Oper.get();
        }
        public void setBaseOper(String BaseOp) {
            Base_Oper.set(BaseOp);
        }
    }
}
