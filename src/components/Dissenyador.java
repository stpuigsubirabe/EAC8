/*
 * Classe que defineix un dissenyador o dissenyadora. Un dissenyador o dissenyadora
 * es defineix pel seu nif, nom i estat, és a dir, actiu si està treballant o no 
 * actiu si està de baixa o vacances.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class Dissenyador extends Treballador implements Component {

  

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys l'atribut actiu
     Accions:
     - Assignar als atributs els valors passats com a paràmetres, menys a actiu,
     ja que quan es crea un nou dissenyador o dissenyadora, el seu estat sempre es
     actiu, per tant li assignem verdader.
     */
    public Dissenyador(String nif, String nom) {
        
        super (nif ,nom);
    }

    /*
     TODO Mètodes accessors    
     */
    

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou dissenyador o nova
     dissenyadora. Les dades a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que tant el nom pot ser una frase, per exemple, 
     Francesc Xavier.
     Retorn: El nou dissenyador o nova dissenyadora creat/da.
     */
    public static Dissenyador addDissenyador() {

        String nif;
        String nom;

        System.out.println("NIF del dissenyador o dissenyadora:");
        nif = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("Nom del dissenyador o dissenyadora:");
        nom = DADES.nextLine();

        return new Dissenyador(nif, nom);
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - En el cas de l'atribut actiu, li heu de demanar que si el dissenyador o dissenyadora està en 
     actiu introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     En el cas de l'atribut actiu, li heu de mostrar el missatge: "\nEl dissenyador
     o dissenyadora està en actiu", si el dissenyador o dissenyadora està en actiu,
     i en cas contrari, el misaatge "\nEl dissenyador o dissenyadora no està en actiu".
     Retorn: cap
     */
    /* METODE PER BORRAR
    --------------------------------------------------------------------------------
    public void updateDissenyador() {
        System.out.println("\nNIF del dissenyador o dissenyadora: " + nif);
        System.out.println("\nEntra el nou nif:");
        nif = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom dissenyador o dissenyadora: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        
        if(actiu){
            System.out.println("\nEl dissenyador o dissenyadora està en actiu");
        }else{
            System.out.println("\nEl dissenyador o dissenyadora no està en actiu");
        }
        
        System.out.println("\nEntra el nou estat (1 si està en actiu o 0 en cas contrari):");
        
        int estat=DADES.nextInt();
        
        if(estat==1){
            actiu=true;
        }else{
            actiu=false;
        }
    }
    --------------------------------------------------------------------------------------------------
*/
/* METODE PER BORRAR
--------------------------------------------------------------------------------
    public void showDissenyador() {
        System.out.println("\nLes dades del dissenyador o dissenyadora amb nif " + nif + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nL'estat és: ");
        
        if(actiu){
            System.out.print("Actiu");
        }else{
            System.out.print("No actiu");
        }
    }
*/
       
}
