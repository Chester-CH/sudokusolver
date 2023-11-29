package com.example.sudokusolver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    TextField[][] txtField = new TextField[9][9];
    @Override
    public void start(Stage stage) {
        GridPane gridp = new GridPane();
        gridp.setAlignment(Pos.CENTER);
        gridp.setHgap(10);
        gridp.setVgap(10);
        gridp.setPadding(new Insets(35,35,35,35));

        for(int x=0; x<9; x++) {
            for(int y=0; y<9; y++) {
                TextField temp = new TextField();
                temp.setAlignment(Pos.CENTER);
                txtField[y][x]= temp;
                gridp.add(temp, y, x);
            }
        }

        Button button = new Button("Clear");
        HBox hBox = new HBox(10);
        hBox.getChildren().add(button);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        gridp.add(hBox, 7,10,3,1);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(int y=0;y<9;y++) {
                    for(int x=0;x<9;x++) {
                        txtField[y][x].setText("");
                        txtField[y][x].setStyle("-fx-background-color:rgb(255,255,255)");
                    }
                }
            }
        });

        button = new Button("Solve!");
        hBox = new HBox(10);
        hBox.getChildren().add(button);
        hBox.setAlignment(Pos.BOTTOM_LEFT);
        gridp.add(hBox, 0,10,3,1);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SudokuSolver solver = new SudokuSolver();
                GameBoard temp = new GameBoard();
                for(int y=0;y<9;y++) {
                    for(int x=0;x<9;x++) {
                        try {
                            Integer index = Integer.valueOf(txtField[y][x].getText().trim());
                            temp.set(y, x, index);
                        }catch (NumberFormatException e) {
                        }
                    }
                }
                GameBoard help = solver.solve(temp);

                for(int y=0;y<9;y++) {
                    for(int x=0;x<9;x++) {
                        if(txtField[y][x].getText().trim().equals("")){
                            if(help == null) {
                                txtField[y][x].setStyle("-fx-background-color:rgb(255,204,204)");
                            }else {
                                txtField[y][x].setStyle("-fx-background-color:rgb(204,255,204)");
                                txtField[y][x].setText(""+help.get(y, x));
                            }
                        }else {
                            txtField[y][x].setStyle("-fx-background-color:rgb(255,255,255)");
                        }
                    }
                }
            }
        });

        var scene = new Scene(gridp, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}