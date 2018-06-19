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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

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
        metas =         new ArrayList<Meta>();
    }

    /**
     * save the changes in all documents
     */
    public void saveAll()
    {
        html_construction.run();
        js_construction.run();
    }
    
    
    
    public static String getPage_title() {
        return page_title;
    }

    public static void setPage_title(String page_title) {
        Core.page_title = page_title;
    }

//GENERAL PROPIETIES____________________________________________________________
    
    public static boolean identation = true;
    
    public static ArrayList<HtmlComponent> components = new ArrayList();
    public static ArrayList<JsEvent> events = new ArrayList();
    public static ArrayList<Meta> metas = new ArrayList();
    
    private static String page_title;
    
    private static File html_document,
                        js_document,
                        project_document;

    private HtmlConstruction html_construction = new HtmlConstruction();
    private JsConstruction js_construction = new JsConstruction();
    
//SUB TRHEAD-CLASSES____________________________________________________________    
   
    /**
     *Html document saving and structure
     */
    class HtmlConstruction implements Runnable
    {
        @Override
        public void run() 
        {
            writeDocument();
        }
        
        /**
         * write all the html document
         */
        private void writeDocument()
        {
            Alert a = new Alert(AlertType.INFORMATION,"valor temporal");
            try 
            {
                startDocument(getPage_title());
                writeBody();
                closeDocument();
                a = new Alert(AlertType.CONFIRMATION,"proyecto guardado correctamente",ButtonType.CLOSE);
            }
            catch (FileNotFoundException fnfe)
            {
                System.out.println("uno de los archivos aún no existe:");
                fnfe.printStackTrace();
                a = new Alert(AlertType.ERROR,"Uno de los archivos no fué encontrado",ButtonType.CLOSE);
            }
            catch (IOException ioe) 
            {
                System.out.println("Error de archivo ya existente");
                ioe.printStackTrace();
                a = new Alert(AlertType.ERROR,"Error de archivo",ButtonType.CLOSE);
            }
            catch (NullPointerException npe)
            {
                System.out.println("un elemento aún no ha sido referenciado: npe");
                npe.printStackTrace();
                a = new Alert(AlertType.ERROR,"No fue posible guardar el proyecto, error interno",ButtonType.CLOSE);
            }
            finally
            {
                a.showAndWait();
            }
        }
        
        /**
         * write headers and initial structure
         * @throws IOException 
         */
        private void startDocument(String title) throws IOException
        {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(html_document)));
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            
            ident(1);
            writer.println("<head>");
            ident(1);
            writer.println("<title>"+title+"</title>");
            ident(1);
            writer.println("<meta charset=\"utf-8\">");
            for (Meta meta : metas) 
            {
                ident(2);
                writer.println(meta.getComand());
            }
            ident(1);
            writer.println("</head>");
            
            writer.close();
        }
        
        /**
         * write all the body structure
         * @throws IOException 
         */
        private void writeBody() throws IOException
        {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(html_document)));
            ident(1);
            writer.println("<body>");
            
            for (HtmlComponent component : components) 
            {
                ident(2);
                writer.println(component.getComand());
            }
            
            ident(1);
            writer.println("</body>");
            writer.close();
        }
        
        /**
         * close the html document structure
         * @throws IOException 
         */
        private void closeDocument() throws IOException
        {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(html_document)));
            writer.println("<!-- CREATED WHIT FinalConstructor, FIND US ON GITHUB -->");
            writer.println("</html>");
            writer.close();
        }
        
        /**
         * control of document identation
         * @throws IOException 
         */
        private void ident(int tab_indicator) throws IOException
        {
            if (identation) 
            {
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(html_document)));
                for (int i = 0; i < tab_indicator; i++) 
                {
                    writer.print("  ");
                }
                writer.close();
            }
        }
        
        
    }
    
    class JsConstruction implements Runnable
    {

        @Override
        public void run() 
        {
            
        }
    
        /**
         * control of document identation
         * @param tab_indicator
         * @throws IOException 
         */
        private void ident(int tab_indicator) throws IOException
        {
            if (identation) 
            {
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(js_document)));
                for (int i = 0; i < tab_indicator; i++) 
                {
                    writer.print("  ");
                }
                writer.close();
            }
        }
        
        private ArrayList<String> call_ready = new ArrayList<>();
        
    }
    
    //in case of implements propietary css
}
