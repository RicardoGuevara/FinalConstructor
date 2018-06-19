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
package construction_tools;

/**
 *
 * @author RICARDO
 */
public class HtmlComponent implements finalconstructor.Debug{

    public String getComand()
    {
        return "prueba de escritura";
    }
    
//GETTERS & SETTERS_____________________________________________________________    
    
    public ComponentType getComponent_type() {
        return component_type;
    }

    public void setComponent_type(ComponentType component_type) {
        this.component_type = component_type;
    }

    public String getInitial_value() {
        return initial_value;
    }

    public void setInitial_value(String initial_value) {
        this.initial_value = initial_value;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLabel_indicator() {
        return label_indicator;
    }

    public void setLabel_indicator(int label_indicator) {
        this.label_indicator = label_indicator;
    }
    
    
    
//VARIABLES_____________________________________________________________________    
    
    private ComponentType component_type;
    private String  initial_value,
                    width,
                    height,
                    id;
    private int label_indicator;
    public static int indicator_control=0;
}
