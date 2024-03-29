/*
 * Classe que defineix un estudi. Un estudi es defineix per un codi, un nom i adreça 
 * on està ubicat. A més, contindrà vectors amb dissenyadors, jardiners, torns 
 * i projectes.
 */
package principal;

import components.Component;
import components.Dissenyador;
import components.Jardiner;
import components.Torn;



/**
 *
 * @author root
 */
public class Estudi implements Component {


    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nom;
    private String adreca;
    private Component[] components = new Component[160];
    private int posicioComponents = 0;
   

    /* 
     TODO
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys els vectors i el
     codi.
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     */
    public Estudi(String nom, String adreca) {
        codi = properCodi;
        properCodi++;
        this.nom = nom;
        this.adreca = adreca;
    }

    /*
     TODO Mètodes accessors    
     */

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi() {
        properCodi++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }
   
    public Component[] getComponents() {
        return components;
    }

    public void setComponents(Component[] components) {
        this.components = components;
    }

    public int getPosicioComponents() {
        return posicioComponents;
    }

    public void setPosicioComponents(int posicioComponents) {
        this.posicioComponents = posicioComponents;
    }
    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou estudi. Les dades
     a demanar són les que li passem per paràmetre al constructor.
     - Heu de tenir en compte que el nom i adreça poden ser frases, per exemple, New Estudi
     o C/Gran Via, 4.
     Retorn: El nou estudi creat.
     */
    public static Estudi addEstudi() {

        String nom;
        String adreca;

        System.out.println("Nom de l'estudi:");
        nom = DADES.nextLine();
        System.out.println("Adreça de l'estudi:");
        adreca = DADES.nextLine();
        return new Estudi(nom, adreca);
    }

    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     no es pot modificar el contingut dels vectors, només els dels atributs 
     nom i adreca. Evidentment, tampoc podeu modificar el codi.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los.
     Retorn: cap
     */
    public void updateComponent() {

        System.out.println("\nNom de l'estudi: " + nom);
        System.out.println("\nPulsa ENTER: " );
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nAdreça de l'estudi: " + adreca);
        System.out.println("\nEntra la nova adreça:");
        adreca = DADES.next();
    }

    public void showComponent() {
        System.out.println("\nLes dades de l'estudi amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nAdreça: " + adreca);
    }

    /*
     DISSENYADOR
     */
    /*
     TODO
     Paràmetres: cap
     Accions:
     - afegeix un nou dissenyador o dissenyadora al vector de dissenyadors de l'estudi actual
     si aquest o aquesta no existeix. Per afegir-lo heu de fer servir el mètode de la classe 
     Dissenyador escaient i per comprovar la seva existència el mètode d'aquesta
     classe que ens ajuda en aquesta tasca.
     - actualitza la posició del vector de dissenyadors si s'afegeix el dissenyador o dissenyadora.
     - mostra el missatge "El dissenyador o dissenyadora ja existeix" si no s'ha afegit el
     dissenyador.
     Retorn: cap
     */
    public void addDissenyador() {

        Dissenyador nouDissenyador = Dissenyador.addDissenyador();

        if (selectComponent(1,nouDissenyador.getNif()) == -1) {
            components[posicioComponents] = nouDissenyador;
            posicioComponents++;
        }else{
            System.out.println("\nEl dissenyador o dissenyadora ja existeix ");
        }
    }
    /*
     JARDINER
     */
    /*
     TODO
     Paràmetres: cap
     Accions:
     - afegeix un nou jardiner o jardinera al vector de jardiners de l'estudi actual
     si aquest no existeix. Per afegir-lo heu de fer servir el mètode de la classe 
     Jardiner escaient i per comprovar la seva existència el mètode d'aquesta
     classe que ens ajuda en aquesta tasca.
     - actualitza la posició del vector de jardiners si s'afegeix el jardiner o jardinera.
     - mostra el missatge "El jardiner o jardinera ja existeix" si no s'ha afegit el
     jardiner o jardinera.
     Retorn: cap
     */
    public void addJardiner() {

        Jardiner nouJardiner = Jardiner.addJardiner();

        if (selectComponent(2,nouJardiner.getNif()) == -1) {
            components[posicioComponents] = nouJardiner;
            posicioComponents++;
        }else{
            System.out.println("\nEl jardiner o jardinera ja existeix ");
        }
    }

    /*
     TORN
     */
    /*
     TODO
     Paràmetres: cap
     Accions:
     - afegeix un nou torn al vector de torns de l'estudi actual si aquest no existeix. 
     Per afegir-lo heu de fer servir el mètode de la classe Torn escaient i per comprovar
     la seva existència el mètode d'aquesta classe que ens ajuda en aquesta tasca.
     - actualitza la posició del vector de torns si s'afegeix el torn.
     - mostra el missatge "El torn ja existeix" si no s'ha afegit el torn.
     Retorn: cap
     */
    public void addTorn() {

        Torn nouTorn = Torn.addTorn();

        if (selectComponent(3,nouTorn.getCodi()) == -1) {
            components[posicioComponents] = nouTorn;
            posicioComponents++;
        }else{
            System.out.println("\nAquest torn ja existeix ");
        }
    }
    /*
     PROJECTE
     */
 /*
     TODO
     Paràmetres: cap
     Accions:
     - afegeix un nou projecte al vector de projectes d'aquest estudi (estudi actual)
     si aquesta no existeix. Per afegir-lo heu de fer  servir el mètode de la classe 
     Projecte pertinent i per comprovar la seva existència el mètode d'aquesta classe 
     que ens ajuda en aquesta tasca.
     - actualitza la posició del vector de projectes si s'afegeix el projecte.
     - mostra el missatge "El projecte ja existeix" si no s'ha afegit el projecte.
     Retorn: cap
     */
    public void addProjecte() {

        Projecte nouProjecte = Projecte.addProjecte();

        if (selectComponent(4,nouProjecte.getCodi()) == -1) {
            components[posicioComponents] = nouProjecte;
            posicioComponents++;
        } else {
            System.out.println("\nEl projecte ja existeix ");
        }
        
    }
    
    public void addTreballadorProjecte(int tipus){
        
        Projecte projecteSel ;
        int pos = selectComponent(4,null);

        if (pos >= 0) {

            projecteSel = ((Projecte)getComponents()[pos]);;
            /*
            Tipus pot ser tipus=1 → Dissenyador i tipus=2 → Jardiner   
                */ 
            switch (tipus){
                // En cas de que sigui un dissenyador

                case 1:
                // Primer comprovem que no hi hagi cap dissenyador assignat.    
                    if (!projecteSel.comprobarDissenyador()){
                        
                        pos = selectComponent(1,null);
                        Dissenyador disenyador = ((Dissenyador)getComponents()[pos]) ; 

                        if (pos >= 0) {
                            projecteSel.addTreballador(disenyador);
                        } else {
                            System.out.println("\nNo existeix aquest dissenyador o dissenyadora");
                        }
                    }else{
                            System.out.println("\nEl projecte ja té assignat un dissenyador o dissenyadora");
                    }
                    break;
                // En cas de que sigui un jardiner
                case 2:
                    pos = selectComponent(2,null);
                    Jardiner jardiner = ((Jardiner)getComponents()[pos]) ; 

                    if (pos >= 0) {
                        projecteSel.addTreballador(jardiner);
                    } else {
                        System.out.println("\nNo existeix aquest jardiner o jardinera");
                    }
                    break;
                }
            } else {
                System.out.println("\nNo existeix aquest projecte");
        }
    }
    public int selectComponent(int tipus, Object id){
        
        if (tipus == 0) {
            System.out.println("\nQuin tipus de component vols seleccionar ?:"
                                +"\n 1=Dissenyador, 2=Jardiner, 3=Torn o 4=Projecte");
            tipus = DADES.nextInt();
        }

        switch(tipus){
        
            case 1: 
                if (id == null) {
            
                    System.out.println("Introdueixi l’ id del dissenyador a seleccionar :");
                    id = DADES.next();
                }
                String idDissenyador =(String)id;
                    for (int i = 0; i <= posicioComponents; i++) {
                        if (components[i] instanceof Dissenyador) {
                            String nifDissenyador =((Dissenyador)components[i]).getNif();
                            if(nifDissenyador.equals(idDissenyador)){return i;}    
                        }
                            if (i == posicioComponents){return -1;}
                    }
            break;
            case 2: 
                if (id == null) {
                    
                    System.out.println("Introdueixi l’ id del jardiner a seleccionar :");                
                    id = DADES.next();
                }
                String idJardiner =(String)id;
                    for (int i = 0; i <= posicioComponents; i++) {
                        if (components[i] instanceof Jardiner) {
                            String nifJardiner =((Jardiner)components[i]).getNif();
                            if(nifJardiner.equals(idJardiner)){return i;}
                        }
                            if (i == posicioComponents){return -1;}                                    
                    }
            break;
            case 3: 
                if (id == null) {
            
                    System.out.println("Introdueixi l’ id del torn a seleccionar :");
                    id = DADES.next();
                }
                String idTorn =(String)id;
                    for (int i = 0; i <= posicioComponents; i++) {
                        if (components[i] instanceof Torn) {
                            String codiTorn =((Torn)components[i]).getCodi();
                            if(codiTorn.equals(idTorn) ){return i;}
                        }
                            if (i == posicioComponents){return -1;}                       
                    }
                break;
            case 4:
                
            if (id == null) {
                
                System.out.println("Introdueixi el codi del projecte a seleccionar :");
                id = DADES.nextInt();
            }
                Integer idObjecte =(Integer)id;
                    for (int i = 0; i <= posicioComponents; i++) {
                        if (components[i] instanceof Projecte) {
                            int codiprojecte =((Projecte)components[i]).getCodi();
                            if(codiprojecte == idObjecte){return i;}
                        }
                        if (i == posicioComponents){return -1;}
                    }
                break;
            default:
                break;
                
        }

        return -1;
    }
    
    /* Aquest métode el farem servir per cpmprovar si un projecte concret 
       es troba dins el vector components */
    
    public boolean verificarProjecte(){
    
    int posProjecte = selectComponent(4,null);
    
        if (posProjecte == -1 ){
           System.out.println("\nNo existeix aquest projecte"); 
           return false;    
           
        }else{
         return true;   
        }
    }
                    
}
