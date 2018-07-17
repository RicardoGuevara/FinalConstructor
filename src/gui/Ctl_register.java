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

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author RICARDO
 */
public class Ctl_register {

    public Ctl_register() 
    {}
    
    @FXML
    public void close(MouseEvent me) throws Exception
    {
        new GUILoader("log_in","Log");
    }
    
    public void tfselected(MouseEvent me)
    {
        if (started) 
        {
            TextField t = (TextField)me.getSource();
            for (TextField tf : tfs) 
            {
                tf.setOpacity((t.equals(tf)? 1.0 : 0.7));
            }    
        }
        else
        {
            started = true;
            tfs.add(user_mail);
            tfs.add(user_name);
            tfs.add(user_pass);
            
            tfselected(me);
        }
        
    }
    
    boolean started = false;
    
    TextField   user_mail,
                user_name,
                user_pass;
    
    ArrayList<TextField> tfs= new ArrayList<>();
}
