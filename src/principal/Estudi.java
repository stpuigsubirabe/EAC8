/*
 * Classe que defineix un estudi. Un estudi es defineix per un codi, un nom i adreça 
 * on està ubicat. A més, contindrà vectors amb dissenyadors, jardiners, torns 
 * i projectes.
 */
package principal;

import components.Dissenyador;
import components.Jardiner;
import components.Torn;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Estudi {

    private final static Scanner DADES = new Scanner(System.in);

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nom;
    private String adreca;
    private Dissenyador[] dissenyadors = new Dissenyador[10];
    private int posicioDissenyadors = 0; //Priemra posició buida del vector dissenyadors
    private Jardiner[] jardiners = new Jardiner[40];
    private int posicioJardiners = 0; //Priemra posició buida del vector jardiners    
    private Torn[] torns = new Torn[10];
    private int posicioTorns = 0; //Priemra posició buida del vector torns
    private Projecte[] projectes = new Projecte[100];
    private int posicioProjectes = 0; //Possició actual buida del vector projectes

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

    public Dissenyador[] getDissenyadors() {
        return dissenyadors;
    }

    public void setDissenyadors(Dissenyador[] dissenyadors) {
        this.dissenyadors = dissenyadors;
    }

    public int getPosicioDissenyadors() {
        return posicioDissenyadors;
    }

    public void setPosicioDissenyadors(int posicioDissenyadors) {
        this.posicioDissenyadors = posicioDissenyadors;
    }

    public Jardiner[] getJardiners() {
        return jardiners;
    }

    public void setJardiners(Jardiner[] jardiners) {
        this.jardiners = jardiners;
    }

    public int getPosicioJardiners() {
        return posicioJardiners;
    }

    public void setPosicioJardiners(int posicioJardiners) {
        this.posicioJardiners = posicioJardiners;
    }

    public Torn[] getTorns() {
        return torns;
    }

    public void setTorns(Torn[] torns) {
        this.torns = torns;
    }

    public int getPosicioTorns() {
        return posicioTorns;
    }

    public void setPosicioTorns(int posicioTorns) {
        this.posicioTorns = posicioTorns;
    }    

    public Projecte[] getProjectes() {
        return projectes;
    }

    public void setProjectes(Projecte[] projectes) {
        this.projectes = projectes;
    }

    public int getPosicioProjectes() {
        return posicioProjectes;
    }

    public void setPosicioProjectes(int posicioProjectes) {
        this.posicioProjectes = posicioProjectes;
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
    public void updateEstudi() {

        System.out.println("\nNom de l'estudi: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nAdreça de l'estudi: " + adreca);
        System.out.println("\nEntra la nova adreça:");
        adreca = DADES.next();
    }

    public void showEstudi() {
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

        if (selectDissenyador(nouDissenyador.getNif()) == -1) {
            dissenyadors[posicioDissenyadors] = nouDissenyador;
            posicioDissenyadors++;
        } else {
            System.out.println("\nEl dissenyador o dissenyadora ja existeix");
        }
    }

    public int selectDissenyador(String nif) {

        if (nif == null) {
            System.out.println("\nNIF del dissenyador o dissenyadora?:");
            nif = DADES.next();
        }

        for (int i = 0; i < posicioDissenyadors; i++) {
            if (dissenyadors[i].getNif().equals(nif)) {
                return i;
            }
        }

        return -1;
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

        if (selectJardiner(nouJardiner.getNif()) == -1) {
            jardiners[posicioJardiners] = nouJardiner;
            posicioJardiners++;
        } else {
            System.out.println("\nEl jardiner o jardinera ja existeix");
        }
    }

    public int selectJardiner(String nif) {

        if (nif == null) {
            System.out.println("\nNIF del jardiner o jardinera?:");
            nif = DADES.next();
        }

        for (int i = 0; i < posicioJardiners; i++) {
            if (jardiners[i].getNif().equals(nif)) {
                return i;
            }
        }

        return -1;
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

        if (selectTorn(nouTorn.getCodi()) == -1) {
            torns[posicioTorns] = nouTorn;
            posicioTorns++;
        } else {
            System.out.println("\nEl torn ja existeix");
        }
    }

    public int selectTorn(String codi) {

        if (codi == null) {
            System.out.println("\nCodi del torn?:");
            codi = DADES.next();
        }

        for (int i = 0; i < posicioTorns; i++) {
            if (torns[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
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

        if (selectProjecte(nouProjecte.getCodi()) == -1) {
            projectes[posicioProjectes] = nouProjecte;
            posicioProjectes++;
        } else {
            System.out.println("\nEl projecte ja existeix");
        }
    }

   public int selectProjecte(Integer codi) {

        if (codi == null) {
            System.out.println("\nCodi del Projecte?:");
            codi = DADES.nextInt();
        }

        for (int i = 0; i < posicioProjectes; i++) {
            if (projectes[i].getCodi()==(codi)) {
                return i;
            }
        }

        return -1;
    }

    public void addTornJardiner() {
        
        Jardiner jardinerSel = null;
        int pos = selectJardiner(null);

        if (pos >= 0) {

            jardinerSel = this.getJardiners()[pos];

            pos = selectTorn(null);

            if (pos >= 0) {
                jardinerSel.setTorn(getTorns()[pos]);
            } else {
                System.out.println("\nNo existeix aquest torn");
            }

        } else {
            System.out.println("\nNo existeix aquest jardiner o jardinera");
        }

    }


    public void addDissenyadorProjecte() {
        Projecte projecteSel = null;
        int pos = selectProjecte(null);

        if (pos >= 0) {

            projecteSel = this.getProjectes()[pos];

            pos = selectDissenyador(null);

            if (pos >= 0) {
                projecteSel.setDissenyador(getDissenyadors()[pos]);
            } else {
                System.out.println("\nNo existeix aquest dissenyador o dissenyadora");
            }

        } else {
            System.out.println("\nNo existeix aquest projecte");
        }
    }
    
    public void addJardinerProjecte() {
        Projecte projecteSel = null;
        int pos = selectProjecte(null);

        if (pos >= 0) {

            projecteSel = this.getProjectes()[pos];

            pos = selectJardiner(null);

            if (pos >= 0) {
                projecteSel.addJardiner(getJardiners()[pos]);
            } else {
                System.out.println("\nNo existeix aquest dissenyador o dissenyadora");
            }

        } else {
            System.out.println("\nNo existeix aquest projecte");
        }
    }
}
