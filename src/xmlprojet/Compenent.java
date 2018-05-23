/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlprojet;

/**
 *
 * @author Lenovo
 */
public class Compenent {
    private String name;
    private String Xml;
    private String andoird;
    private String swift;

    public Compenent() {
    }

    public Compenent(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXml() {
        return Xml;
    }

    public void setXml(String Xml) {
        this.Xml = Xml;
    }

    public String getAndoird() {
        return andoird;
    }

    public void setAndoird(String andoird) {
        this.andoird = andoird;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }
    
    
    
}
