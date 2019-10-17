/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author Stephan
 */
public abstract class Treballador {
     
    private final static Scanner DADES = new Scanner(System.in); 
    
    private String nif;
    private String nom;
    private boolean actiu;


    public Treballador(String nif,String nom){

        this.nif = nif;
        this.nom = nom;
        actiu = true;
    }
     public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getActiu() {
        return actiu;
    }

    public void setActiu(boolean actiu) {
        this.actiu = actiu;
    }
    
}