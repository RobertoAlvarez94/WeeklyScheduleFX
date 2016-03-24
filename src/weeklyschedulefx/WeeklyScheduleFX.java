/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weeklyschedulefx;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Roberto Alvarez
 */
public class WeeklyScheduleFX extends Application {
    private int rWidth = 140;
    private int rHeigth = 30;
    private int BtnHeigth = 30;
    GridPane gPane = new GridPane();
    VBox vbox = new VBox();
    Calendar calendar;
    Course course;
    
    @Override
    public void start(Stage myStage) {
        
        //create button for add/change user
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                Button AddUser = new Button();
                AddUser.setText("Add/Change New User");
                AddUser.setOnAction((ActionEvent event) -> {
                    System.out.println("User Changed/Added");
                });
                
                StackPane UserBox = new StackPane();
                UserBox.setPrefHeight(BtnHeigth);
                UserBox.setMaxHeight(BtnHeigth);
                UserBox.setMinHeight(BtnHeigth);
                UserBox.getChildren().add(AddUser);
                gPane.setRowIndex(UserBox, i);
                gPane.setColumnIndex(UserBox, j);
                gPane.getChildren().addAll(UserBox);
            }
        }
        
        //create button for add new course
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 1; j++) {
                Button Change = new Button();
                Change.setText("     Add New Course     ");
                Change.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Class Added");
                    }
                });
                
                StackPane ChangeBox = new StackPane();
                ChangeBox.setPrefHeight(BtnHeigth);
                ChangeBox.setMaxHeight(BtnHeigth);
                ChangeBox.setMinHeight(BtnHeigth);
                ChangeBox.getChildren().add(Change);
                gPane.setRowIndex(ChangeBox, i);
                gPane.setColumnIndex(ChangeBox, j);
                gPane.getChildren().addAll(ChangeBox);
            }
        }
        
        //create button to change time interval
        for (int i = 2; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                Button TimeChange = new Button();
                TimeChange.setText(" Change Time Interval  ");
                TimeChange.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Time Changed!");
                    }
                });
                
                StackPane TimeChangeBox = new StackPane();
                TimeChangeBox.setPrefHeight(BtnHeigth);
                TimeChangeBox.setMaxHeight(BtnHeigth);
                TimeChangeBox.setMinHeight(BtnHeigth);
                TimeChangeBox.getChildren().add(TimeChange);
                gPane.setRowIndex(TimeChangeBox, i);
                gPane.setColumnIndex(TimeChangeBox, j);
                gPane.getChildren().addAll(TimeChangeBox);
            }
        }
        
        
        
        
        //create rectangle header for time
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < 2; j++) {
                Rectangle timeHRect = new Rectangle(0, 0, rWidth, rHeigth);
                timeHRect.setStroke(Color.ANTIQUEWHITE);
                timeHRect.setFill(Color.MEDIUMORCHID);
                Text timeHeader = new Text("Time");
                
                StackPane timeBox = new StackPane();
                timeBox.setPrefHeight(rHeigth);
                timeBox.setMaxHeight(rHeigth);
                timeBox.setMinHeight(rHeigth);
                timeBox.getChildren().addAll(timeHRect, timeHeader);
                gPane.setRowIndex(timeBox, i);
                gPane.setColumnIndex(timeBox, j);
                gPane.getChildren().addAll(timeBox);
            }
            
        }
        
        /*//create time rectangles
        for (int i = 1; i < 24; i++) {
            for (int j = 1; j < 2; j++) {
                Rectangle timeRect = new Rectangle(0, 0, rWidth, rHeigth);
                timeRect.setStroke(Color.ANTIQUEWHITE);
                timeRect.setFill(Color.VIOLET);
                Text timeText = new Text("--------");
                
                StackPane boxTime = new StackPane();
                boxTime.setPrefHeight(rHeigth);
                boxTime.setMaxHeight(rHeigth);
                boxTime.setMinHeight(rHeigth);
                boxTime.getChildren().addAll(timeRect, timeText);
                gPane.setRowIndex(boxTime, i);
                gPane.setColumnIndex(boxTime, j);
                gPane.getChildren().add(boxTime);
            }
            
        }*/
        
        String[] WeekHeader = new String[5];
        WeekHeader[0] = "Monday";
        WeekHeader[1] = "Tuesday";
        WeekHeader[2] = "Wednesday";
        WeekHeader[3] = "Thursday";
        WeekHeader[4] = "Friday";
        
        //Monday
            for (int i = 0; i < 1; i++) {
                for (int j = 3; j < 4; j++) {
                    for (int k = 0; k < WeekHeader.length; k++) {
                        
                        
                    Rectangle Week = new Rectangle(0, 0, rWidth, rHeigth);
                    Week.setStroke(Color.ANTIQUEWHITE);
                    Week.setFill(Color.LIMEGREEN);


                    Text timeText = new Text(WeekHeader[0]);

                    StackPane boxTime = new StackPane();
                    boxTime.setPrefHeight(rHeigth);
                    boxTime.setMaxHeight(rHeigth);
                    boxTime.setMinHeight(rHeigth);
                    boxTime.getChildren().addAll(Week, timeText);
                    gPane.setRowIndex(boxTime, i);
                    gPane.setColumnIndex(boxTime, j);
                    gPane.getChildren().add(boxTime);
                }
            }
        }
            //Tuesday
            for (int i = 0; i < 1; i++) {
                for (int j = 4; j < 5; j++) {
                    for (int k = 0; k < WeekHeader.length; k++) {
                        
                        
                    Rectangle Week = new Rectangle(0, 0, rWidth, rHeigth);
                    Week.setStroke(Color.ANTIQUEWHITE);
                    Week.setFill(Color.LIMEGREEN);


                    Text timeText = new Text(WeekHeader[1]);

                    StackPane boxTime = new StackPane();
                    boxTime.setPrefHeight(rHeigth);
                    boxTime.setMaxHeight(rHeigth);
                    boxTime.setMinHeight(rHeigth);
                    boxTime.getChildren().addAll(Week, timeText);
                    gPane.setRowIndex(boxTime, i);
                    gPane.setColumnIndex(boxTime, j);
                    gPane.getChildren().add(boxTime);
                }
            }
        }
            //Wednesday
            for (int i = 0; i < 1; i++) {
                for (int j = 5; j < 6; j++) {
                    for (int k = 0; k < WeekHeader.length; k++) {
                        
                        
                    Rectangle Week = new Rectangle(0, 0, rWidth, rHeigth);
                    Week.setStroke(Color.ANTIQUEWHITE);
                    Week.setFill(Color.LIMEGREEN);


                    Text timeText = new Text(WeekHeader[2]);

                    StackPane boxTime = new StackPane();
                    boxTime.setPrefHeight(rHeigth);
                    boxTime.setMaxHeight(rHeigth);
                    boxTime.setMinHeight(rHeigth);
                    boxTime.getChildren().addAll(Week, timeText);
                    gPane.setRowIndex(boxTime, i);
                    gPane.setColumnIndex(boxTime, j);
                    gPane.getChildren().add(boxTime);
                }
            }
        }
        
            //Thursday
            for (int i = 0; i < 1; i++) {
                for (int j = 6; j < 7; j++) {
                    for (int k = 0; k < WeekHeader.length; k++) {
                        
                        
                    Rectangle Week = new Rectangle(0, 0, rWidth, rHeigth);
                    Week.setStroke(Color.ANTIQUEWHITE);
                    Week.setFill(Color.LIMEGREEN);


                    Text timeText = new Text(WeekHeader[3]);

                    StackPane boxTime = new StackPane();
                    boxTime.setPrefHeight(rHeigth);
                    boxTime.setMaxHeight(rHeigth);
                    boxTime.setMinHeight(rHeigth);
                    boxTime.getChildren().addAll(Week, timeText);
                    gPane.setRowIndex(boxTime, i);
                    gPane.setColumnIndex(boxTime, j);
                    gPane.getChildren().add(boxTime);
                }
            }
        }
       
            //Friday
            for (int i = 0; i < 1; i++) {
                for (int j = 7; j < 8; j++) {
                    for (int k = 0; k < WeekHeader.length; k++) {
                        
                        
                    Rectangle Week = new Rectangle(0, 0, rWidth, rHeigth);
                    Week.setStroke(Color.ANTIQUEWHITE);
                    Week.setFill(Color.LIMEGREEN);


                    Text timeText = new Text(WeekHeader[4]);

                    StackPane boxTime = new StackPane();
                    boxTime.setPrefHeight(rHeigth);
                    boxTime.setMaxHeight(rHeigth);
                    boxTime.setMinHeight(rHeigth);
                    boxTime.getChildren().addAll(Week, timeText);
                    gPane.setRowIndex(boxTime, i);
                    gPane.setColumnIndex(boxTime, j);
                    gPane.getChildren().add(boxTime);
                }
            }
        }
        
        
        
        
        //this creates fields for clases
        for (int i = 1; i < 15; i++) {
            for (int j = 3; j < 8; j++) {
                Rectangle Week = new Rectangle(0, 0, rWidth, rHeigth);
                Week.setStroke(Color.ANTIQUEWHITE);
                Week.setFill(Color.MEDIUMSEAGREEN);
                Text timeText = new Text("--------");
                
                StackPane boxTime = new StackPane();
                boxTime.setPrefHeight(rHeigth);
                boxTime.setMaxHeight(rHeigth);
                boxTime.setMinHeight(rHeigth);
                boxTime.getChildren().addAll(Week, timeText);
                gPane.setRowIndex(boxTime, i);
                gPane.setColumnIndex(boxTime, j);
                gPane.getChildren().add(boxTime);
            }
        }
        
        //CSCI 2333 Monday
        for (int i = 3; i < 5; i++) {
            for (int j = 3; j < 4; j++) {
                Rectangle Week = new Rectangle(0, 0, rWidth, rHeigth);
                Week.setStroke(Color.ANTIQUEWHITE);
                Week.setFill(Color.MEDIUMSEAGREEN);
                Text timeText = new Text("CSCI 2333 LHSB 1.420");
                
                StackPane boxTime = new StackPane();
                boxTime.setPrefHeight(rHeigth);
                boxTime.setMaxHeight(rHeigth);
                boxTime.setMinHeight(rHeigth);
                boxTime.getChildren().addAll(Week, timeText);
                gPane.setRowIndex(boxTime, i);
                gPane.setColumnIndex(boxTime, j);
                gPane.getChildren().add(boxTime);
            }
        }
        
        //CSCI 4318 Tuesday
        for (int i = 6; i < 8; i++) {
            for (int j = 4; j < 5; j++) {
                Rectangle Week = new Rectangle(0, 0, rWidth, rHeigth);
                Week.setStroke(Color.ANTIQUEWHITE);
                Week.setFill(Color.MEDIUMSEAGREEN);
                Text timeText = new Text("CSCI 4318 MAIN 1.518");
                
                StackPane boxTime = new StackPane();
                boxTime.setPrefHeight(rHeigth);
                boxTime.setMaxHeight(rHeigth);
                boxTime.setMinHeight(rHeigth);
                boxTime.getChildren().addAll(Week, timeText);
                gPane.setRowIndex(boxTime, i);
                gPane.setColumnIndex(boxTime, j);
                gPane.getChildren().add(boxTime);
            }
        }
        
        //CSCI 2333 Wednesday
        for (int i = 3; i < 5; i++) {
            for (int j = 5; j < 6; j++) {
                Rectangle Week = new Rectangle(0, 0, rWidth, rHeigth);
                Week.setStroke(Color.ANTIQUEWHITE);
                Week.setFill(Color.MEDIUMSEAGREEN);
                Text timeText = new Text("CSCI 2333 LHSB 1.420");
                
                StackPane boxTime = new StackPane();
                boxTime.setPrefHeight(rHeigth);
                boxTime.setMaxHeight(rHeigth);
                boxTime.setMinHeight(rHeigth);
                boxTime.getChildren().addAll(Week, timeText);
                gPane.setRowIndex(boxTime, i);
                gPane.setColumnIndex(boxTime, j);
                gPane.getChildren().add(boxTime);
            }
        }
        
        //CSCI 4318 Thursday
        for (int i = 6; i < 8; i++) {
            for (int j = 6; j < 7; j++) {
                Rectangle Week = new Rectangle(0, 0, rWidth, rHeigth);
                Week.setStroke(Color.ANTIQUEWHITE);
                Week.setFill(Color.MEDIUMSEAGREEN);
                Text timeText = new Text("CSCI 4318 MAIN 1.518");
                
                StackPane boxTime = new StackPane();
                boxTime.setPrefHeight(rHeigth);
                boxTime.setMaxHeight(rHeigth);
                boxTime.setMinHeight(rHeigth);
                boxTime.getChildren().addAll(Week, timeText);
                gPane.setRowIndex(boxTime, i);
                gPane.setColumnIndex(boxTime, j);
                gPane.getChildren().add(boxTime);
            }
        }
        
        //create button to change background color
        for (int i = 0; i < 1; i++) {
            for (int j = 8; j < 9; j++) {
                Button ColorBtn = new Button();
                ColorBtn.setText("Change Background Color");
                ColorBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Color Changed");
                    }
                });
                
                StackPane ColorBox = new StackPane();
                ColorBox.setPrefHeight(BtnHeigth);
                ColorBox.setMaxHeight(BtnHeigth);
                ColorBox.setMinHeight(BtnHeigth);
                ColorBox.getChildren().add(ColorBtn);
                gPane.setRowIndex(ColorBox, i);
                gPane.setColumnIndex(ColorBox, j);
                gPane.getChildren().addAll(ColorBox);
            }
        }
        
        //create button to show grid lines
        for (int i = 1; i < 2; i++) {
            for (int j = 8; j < 9; j++) {
                Button GridBtn = new Button();
                GridBtn.setText("        Show Grid Lines        ");
                GridBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Showing Grid Lines");
                    }
                });
                
                StackPane GridBox = new StackPane();
                GridBox.setPrefHeight(BtnHeigth);
                GridBox.setMaxHeight(BtnHeigth);
                GridBox.setMinHeight(BtnHeigth);
                GridBox.getChildren().add(GridBtn);
                gPane.setRowIndex(GridBox, i);
                gPane.setColumnIndex(GridBox, j);
                gPane.getChildren().addAll(GridBox);
            }
        }
        
        //create button for add/change user
        for (int i = 2; i < 3; i++) {
            for (int j = 8; j < 9; j++) {
                Button FullBtn = new Button();
                FullBtn.setText("    Switch to Full Screen    ");
                FullBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Full Screen On");
                    }
                });
              
                StackPane FullBox = new StackPane();
                FullBox.setPrefHeight(BtnHeigth);
                FullBox.setMaxHeight(BtnHeigth);
                FullBox.setMinHeight(BtnHeigth);
                FullBox.getChildren().add(FullBtn);
                gPane.setRowIndex(FullBox, i);
                gPane.setColumnIndex(FullBox, j);
                gPane.getChildren().addAll(FullBox);
            }
        }
        
        Calendar cal = new Calendar();
        cal.generateTicks(gPane, rHeigth, rWidth);
        
        
        
        
        StackPane root = new StackPane();
        root.getChildren().add(gPane);
        gPane.getChildren().addAll();
        Scene scene = new Scene(root, 1200, 800);
        myStage.setScene(scene); 
        myStage.show();
    }
    
 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
