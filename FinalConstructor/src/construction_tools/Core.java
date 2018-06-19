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

import java.io.File;
import java.util.ArrayList;

/**
 *Simplifies all the documents creation and management
 * @author RICARDO
 */
public class Core implements finalconstructor.Debug{

    public Core(String title)
    {
        Core.setPage_title(title);
        
        html_document =     new File(title+".html");
        js_document =       new File(title+".js");
        project_document =  new File(title+".hg");
        
        components =    new ArrayList<HtmlComponent>();
        events =        new ArrayList<JsEvent>();
    }

    public static String getPage_title() {
        return page_title;
    }

    public static void setPage_title(String page_title) {
        Core.page_title = page_title;
    }

    

//GENERAL PROPIETIES____________________________________________________________
    
    public static ArrayList components,
                            events;
    
    private static String page_title;
    private static File  html_document,
                        js_document,
                        project_document;

//SUB TRHEAD-CLASSES____________________________________________________________    
   
    /**
     *Referent  
     */
    class HtmlConstruction 
            implements Runnable
    {
        @Override
        public void run() 
        {
            
        }
    
    }
    
    class JsConstruction implements Runnable
    {

        @Override
        public void run() 
        {
            
        }
    
    }
    
    //in case of implements propietary css
}
