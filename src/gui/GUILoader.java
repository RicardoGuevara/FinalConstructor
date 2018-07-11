/*
 * Copyright 2018 RICARDO.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Clase encargada de cargar Fxmls encontrados en el paquete GUI
 *
 *
 * @author AlguienMoreInAsus
 */
public class GUILoader extends Application {

    // ALL CREDITS OVER THE CLASS IDEA FOR AlguienMore (José Hurtado)
    
    private String fxml;
    private String titulo;
    GUILoader lel;

    private double xOffset = 0;
    private double yOffset = 0;

    public static Stage antlog = new Stage(),
                        actlog;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("/gui/" + fxml + ".fxml"));

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        primaryStage.setTitle(titulo);
        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
        
        antlog = actlog;
        actlog= primaryStage;
        actlog.show();
        antlog.close();
        
    }

    
    public GUILoader(String fxml, String titulo) throws Exception {
        this.fxml = fxml;
        this.titulo = titulo;

//            HtmlConstructor.antlog = HtmlConstructor.actlog;
//            HtmlConstructor.antlog.close();
            
        start(new Stage());
        
    }
    
}
