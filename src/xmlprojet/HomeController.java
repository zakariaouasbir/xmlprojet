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
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
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
     ArrayList<TreeItem> it=new ArrayList<>();
     File f =new File("C:/Users/Lenovo/Documents/NetBeansProjects/XMLprojet/fichiers");
        TreeItem<String> treeItemRoot = new TreeItem<> ("projects"); 
   File currentfile; 
   @FXML
   private TableView<Compenent> tv=new TableView<>();
    ObservableList<Compenent> comp=FXCollections.observableArrayList();
        TableColumn<Compenent, String> nameColumn = new TableColumn<>("Compenent");
        
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //console.setVisible(false);
        initmenyadd();
        u.createtree(treeItemRoot,u.listFilesForFolder(f,it));
        treeview.setRoot(treeItemRoot);
       
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
           radio.setOnAction(e -> comp.add( new Compenent("radio button")));
           
           
       // menu.getItems().add(newFile);
    }
    public void createprojet() throws InterruptedException, IOException
    { String A=AlertBox.display("Create project", "project name:");
        System.out.println(""+A);
       if(!A.equalsIgnoreCase(""))
       {
            console.setVisible(true);
        
    String p="C:/Users/Lenovo/Documents/NetBeansProjects/XMLprojet/fichiers/"+A;
        File f=new File(p);
        if(!f.exists()){
            f.mkdir();
            console.appendText("creating project...\n");
            File t=new File(p+"/"+A+"dtd.xml");
              if(!t.exists()){
            console.appendText("creating XML files...\n");
             t.createNewFile();
             currentfile=t;
             // u.createtree(treeItemRoot,u.listFilesForFolder(f,it));
  
        }
        }
            else
        {
          console.appendText("name already exist\n");  
        }
        
        //console.setVisible(false);
        
    }
     
    }}
