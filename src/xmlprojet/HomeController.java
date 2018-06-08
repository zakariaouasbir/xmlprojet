/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlprojet;

import static java.awt.SystemColor.menu;
import util.Util;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;





/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    private Menu menu=new  Menu();
    
    @FXML
    private TextArea area;
    @FXML
    private TextArea console;
    //treeprojects
    @FXML
    private TreeView treeview;
    Util u =new Util();
     ArrayList<TreeItem> it;
     File f =new File("C:/Users/Lenovo/Documents/NetBeansProjects/XMLprojet/fichiers");
        TreeItem<String> treeItemRoot ;
            
   File currentfile; 
   @FXML
   private TableView<Compenent> tv=new TableView<>();
    ObservableList<Compenent> comp=FXCollections.observableArrayList();
        TableColumn<Compenent, String> nameColumn = new TableColumn<>("Compenent");
        
     @FXML
     public void createxml(){
        try {
         DocumentBuilderFactory dbFactory =
         DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.newDocument();
          Element rootElement = doc.createElement("card");
            for (int i = 0; i <comp.size(); i++) {
                Element e = doc.createElement(comp.get(i).getName());
                e.appendChild(doc.createTextNode(comp.get(i).getName()));
         rootElement.appendChild(e);
         
            }
         doc.appendChild(rootElement);
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
          transformer.setOutputProperty(OutputKeys.INDENT, "yes");
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(new File("C:/Users/Lenovo/Documents/NetBeansProjects/XMLprojet/fichiers/projet1/projet1.xml"));
         
         transformer.transform(source, result);
         
      
          } catch (Exception e) {
         e.printStackTrace();
      }
            
         
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //console.setVisible(false);
        initmenyadd();
        it=new ArrayList<>();
        treeItemRoot = new TreeItem<> ("projects"); 
        u.createtree(treeItemRoot,u.listFilesForFolder(f,it));
        treeview.setRoot(treeItemRoot);
        treeview.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue != null){
                            area.setText(u.readefile("C:/Users/Lenovo/Documents/NetBeansProjects/XMLprojet/fichiers/"+u.getvaluedirectorie(u.getvalue(newValue.toString()))+"/"+u.getvalue(newValue.toString())));
                          //  System.out.println( treeview.getSelectionModel());
                    } });

        
       
       
       nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
      tv.setItems(comp);
      tv.getColumns().add(nameColumn);
    
    }    
        
    /**
     *
     * @throws MalformedURLException
     */
    public void initmenyadd()
    {
             MenuItem but=new MenuItem("button");
            menu.getItems().add(but);
           but.setOnAction(e -> comp.add( new Compenent("button")));
           
             MenuItem chk=new MenuItem("checkbox");
            menu.getItems().add(chk);
           chk.setOnAction(e -> comp.add( new Compenent("checkbox")));
           
             MenuItem radio=new MenuItem("radio button");
            menu.getItems().add(radio);
           radio.setOnAction(e -> comp.add( new Compenent("radiobutton")));
           
           
       // menu.getItems().add(newFile);
    }
    public void createprojet() throws InterruptedException, IOException
    { String A=AlertBox.display("Create project", "project name:");
        
       if(!A.equalsIgnoreCase(""))
       {
           // console.setVisible(true);
        
    String p="C:/Users/Lenovo/Documents/NetBeansProjects/XMLprojet/fichiers/"+A;
        File f=new File(p);
        
        if(!f.exists()){
            f.mkdir();
            console.appendText("creating empty project...\n");
             File t=new File(p+"/"+A+".dtd");
             File xml=new File(p+"/"+A+".xml");
             if(!t.exists()){
            console.appendText("creating empty XML files...\n");
             t.createNewFile();
              u.initdtd(p+"/"+A+".dtd");
               t.setReadOnly();
              xml.createNewFile();
        }
        }
            else
        {
          console.appendText("name already exist\n");  
        }
        
        //console.setVisible(true);
        
    }    //treeItemRoot=null;
         refreshtree(u.listFilesForFolder(f,it));
            
     
    }
public void refreshtree(ArrayList<TreeItem> list )
{    treeItemRoot = new TreeItem<> ("projects"); 
it=new ArrayList<>();
        u.createtree(treeItemRoot,u.listFilesForFolder(f,it));
        treeview.setRoot(treeItemRoot);
    treeview.refresh();
}}
