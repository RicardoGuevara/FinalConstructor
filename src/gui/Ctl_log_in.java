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

import finalconstructor.FinalConstructor;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author RICARDO
 */
public class Ctl_log_in {

    public Ctl_log_in()
    {}
    
    @FXML
    public void logIn(ActionEvent ae) throws Exception
    {
        user_password.setOpacity(0.7);
        user_name.setOpacity(0.7);
        
        FinalConstructor.global_user = new finalconstructor.User(user_name.getText(),user_password.getText());
        FinalConstructor.global_user.logIn();
    }
    
    @FXML
    public void close(MouseEvent me) throws Exception
    {
        System.exit(0);
    }
    
    public void nameSelected(MouseEvent ae) throws Exception
    {
        user_password.setOpacity(0.7);
        user_name.setOpacity(1.0);
    }
    
    public void passSelected(MouseEvent ae) throws Exception
    {
        user_name.setOpacity(0.7);
        user_password.setOpacity(1.0);
    }
    
    public void didname(KeyEvent ke)
    {
        if (ke.getCode().equals(KeyCode.TAB)) 
        {
            user_name.setOpacity(0.7);
            user_password.setOpacity(1.0);
        }
    }
    
    public void didpass(KeyEvent ke)
    {
        if (ke.getCode().equals(KeyCode.TAB)) 
        {
            user_name.setOpacity(0.7);
            user_password.setOpacity(0.7);
        }
    }
    
    public void didreturn(KeyEvent ke)
    {
        if (ke.getCode().equals(KeyCode.TAB)) 
        {
            user_name.setOpacity(1.0);
            user_password.setOpacity(0.7);
        }
    }
    
    public TextField   user_name;
    public PasswordField user_password;
    
}
