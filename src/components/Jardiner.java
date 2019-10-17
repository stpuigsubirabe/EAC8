/*
 * Classe que defineix un jardiner o jardinera. Un jardiner o jardinera es defineix 
 * pel seu NIF, nom, torn de feina i estat, és a dir, actiu si està treballant o no actiu si està 
 * de baixa o vacances.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class Jardiner extends Treballador implements Component{
    
    private final static Scanner DADES = new Scanner(System.in);
    
    private Torn torn;
    

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys l'atribut actiu
     Accions:
     - Assignar als atributs els valors passats com a paràmetres, menys a actiu,
     ja que quan es crea un nou jardiner o jardinera, el seu estat sempre és
     actiu, per tant li assignem verdader. I torn, ja que quan es crea un nou
     jardiner o jardinera aquest encara no té assignat cap torn, per tant li assignarem
     null.
     */
    public Jardiner(String nif, String nom) {
        
        super (nif ,nom);
        this.torn = null;
    }

    /*
     TODO Mètodes accessors    
     */
  
    public Torn getTorn() {
        return torn;
    }
    
    public void setTorn(Torn torn) {
        this.torn = torn;
    }

 


    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou jardiner o nova
     jardinera. Les dades a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que tant el nom pot ser una frase, per exemple, 
     Francesc Xavier.
     Retorn: El nou jardiner o nova jardinera creat/da.
     */
    public static Jardiner addJardiner() {

        String nif;
        String nom;
        Torn torn;

        System.out.println("NIF del jardiner o jardinera:");
        nif = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("Nom del jardiner o jardinera:");
        nom = DADES.nextLine();        

        return new Jardiner(nif, nom);
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte, menys de l'atribut torn.
     - En el cas de l'atribut actiu, li heu de demanar que si el jardiner o jardinera està en 
     actiu introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     En el cas de l'atribut actiu, li heu de mostrar el missatge: "\nEl jardiner o jardinera
     està en actiu", si el jardiner o jardinera està en actiu, i en cas contrari, el missatge 
     "\nEl jardiner o jardinera no està en actiu".
     Retorn: cap
     */
    public void updateJardiner() {
        System.out.println("\nNIF del jardiner o jardinera: " + nif);
        System.out.println("\nEntra el nou nif:");
        nif = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom jardiner o jardinera: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        
        if(actiu){
            System.out.println("\nEl jardiner o jardinera està en actiu");
        }else{
            System.out.println("\nEl jardiner o jardinera no està en actiu");
        }
        
        System.out.println("\nEntra el nou estat (1 si està en actiu o 0 en cas contrari):");
        
        int estat=DADES.nextInt();
        
        if(estat==1){
            actiu=true;
        }else{
            actiu=false;
        }
    }

    public void showJardiner() {
        System.out.println("\nLes dades del jardiner o jardinera amb nif " + nif + " són:");
        System.out.println("\nNom: " + nom);
        torn.showTorn();
        System.out.println("\nL'estat és: ");
        
        if(actiu){
            System.out.print("Actiu");
        }else{
            System.out.print("No actiu");
        }
    }
    public void showComponent(){}
    public void updateComponent(){}
} 
