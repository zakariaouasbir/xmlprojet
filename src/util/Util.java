/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.io.File;
import javafx.scene.control.TreeItem;

/**
 *
 * @author Lenovo
 */
public class Util {
 
   
 //ArrayList<TreeItem> listtree=new ArrayList<>();
public ArrayList<TreeItem> listFilesForFolder(final File folder,ArrayList<TreeItem> listtree) {
   
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listtree.add(new TreeItem<>(fileEntry.getName()));
            System.out.println("="+fileEntry.getName());
            listFilesForFolder(fileEntry,listtree);
        } else {
        listtree.get(listtree.size()-1).getChildren().add(new TreeItem<>(fileEntry.getName()));
            System.out.println(fileEntry.getName());
        }
    }
 return listtree;
}
public void createtree(TreeItem root,ArrayList<TreeItem> list )
{
    for (int i = 0; i <list.size(); i++) {
       root.getChildren().add(list.get(i));
          
    } 
}

   
}
