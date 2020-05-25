package com.epsi.poe.basis;

import java.util.Scanner;
import java.util.Vector;

import com.epsi.poe.basis.Customer;

enum Support
{
    K7,
    USB,
    Blueray,
    DVD
}

public class Main {
    static Vector boiteclient= new Vector();
    static Vector boitefilm= new Vector();

    public static void main(String[] args) {
        // write your code here
        boolean redo = true;
        do {
            // MENU
            System.out.println("-------------------------------------------------------------");
            System.out.println("|************BIENVENU DANS VOTRE VIDEOTHEQUE*****************|");
            System.out.println("-------------------------------------------------------------");
            System.out.println(" Que voulez-vous faire ? ");
            System.out.println(" ");
            System.out.println("1 - Gérer les films         |            2 - Gérer les clients");
            System.out.println(" ");

            //Saisie de 1 ou 2
            Scanner clavier = new Scanner(System.in);
            int choix = clavier.nextInt();

            switch (choix) {
                case 1:
                    afficherMenuFilm();
                    break;
                case 2:
                    afficherMenuClient();
                    break;
                default:
                    System.out.println("Choix inconnu");

            }
            System.out.println("Voulez svous recommencer (O/N)");
            Scanner boolReDoScan = new Scanner(System.in);
            char booRedo =boolReDoScan.nextLine().charAt(0);
            if (booRedo == 'O')
                redo= true;
            else
                redo=false;

        } while (redo);
    }

    public static void afficherMenuClient() {

        System.out.println(" Que voulez-vous faire ? ");
        System.out.println(" ");
        System.out.println("1 - Stocker liste de client ");
        System.out.println("2 - Ajouter un client ");
        System.out.println("3 - Affecter un film ");
        System.out.println("4 - afficher la liste des films loués. ");
        System.out.println(" ");
        //Saisie de 1 ou 2
        Scanner clavierClient = new Scanner(System.in);
        int choixClient = clavierClient.nextInt();

        switch (choixClient)
        {
            case 1:
                stockerClient();
                break;
            case 2:
                ajouterClient();
                break;
            case 3:
                affecterFilmToClient();
                break;
            case 4:
                afficherListeFilmLoue();
                break;
            default:
                System.out.println("Choix inconnu");

        }
        
        
    }

    private static void afficherListeFilmLoue() {
    }

    private static void affecterFilmToClient() {
    }

    private static void ajouterClient() {
        Scanner custScann = new Scanner(System.in);
        System.out.println("Saisir le nom du client");
        String nom = custScann.next();
        System.out.println("Saisir le prenom du client");
        String prenom = custScann.next();
        System.out.println("Renseigner l'adresse mail du client");
        String mail = custScann.next();
        Customer cli = new Customer(nom, prenom, mail);
        boiteclient.addElement(cli);
    }

    private static void stockerClient() {
        for (int i=0; i < boiteclient.size(); i++) {
            Customer cust = (Customer) boiteclient.elementAt(i);
            System.out.println(" Nom " + cust.getLastName());
            System.out.println(" Prenom " + cust.getFirstName());
            System.out.println(" Email " + cust.getEmail());

        }

    }

    public static void afficherMenuFilm() {
        System.out.println(" Que voulez-vous faire ? ");
        System.out.println(" ");
        System.out.println("1 - Stocker liste de film ");
        System.out.println("2 - Ajouter un film ");
        System.out.println("3 - Faire une recherche de film ");
        System.out.println("4 - Afficher la liste des film loué ");
        System.out.println("5 - Afficher le liste des films par support ");
        System.out.println("6 - Supprimer un film ");
        System.out.println(" ");

        //Saisie de 1 ou 2
        Scanner clavierFilm = new Scanner(System.in);
        int choixFilm = clavierFilm.nextInt();

        switch (choixFilm)
        {
            case 1:
                stockerFilm();
                break;
            case 2:
                ajouterFilm();
                break;
            case 3:
                rechercheFilm();
                break;
            case 4:
                afficherGlobalListeFilmLoue();
                break;
            case 5:
                afficherFilmParSupport();
                break;
            case 6:
                supprimerFilm();
                break;
            default:
                System.out.println("Choix inconnu");

        }
    }

    private static void supprimerFilm() {
        System.out.println("Film à supprimer");
        Scanner scDelete = new Scanner(System.in);
        String nomFilmASup = scDelete.nextLine();
        int i =0;
        boolean search = false;
        while (i < boitefilm.size() && (search == false)) {
            Film filmTest = (Film) boitefilm.elementAt(i);
            if (filmTest.getName().equals( nomFilmASup)) {
                System.out.println("Film Trouvé");
                boitefilm.remove(i);
                System.out.println("Film supprimé");
                search=true;
                stockerFilm();
            }
            else
                i++;
        }
    }

    private static void afficherFilmParSupport() {
        System.out.println("Support  à rechercher");
        Scanner scSupport = new Scanner(System.in);
        Support supportSearch = null;
        try
        {
            supportSearch = Support.valueOf(scSupport.nextLine());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Erreur Type non connu");
            supportSearch=Support.DVD;
        }

        int i =0;
        while (i < boitefilm.size() ) {
            Film filmTest = (Film) boitefilm.elementAt(i);
            String supportValue = filmTest.getSupport().toString();
            System.out.println("Valeur du support de l'objet "+ supportValue);
            if (supportValue.equals( supportSearch.toString())) {
                System.out.println("Film Trouvé");
                System.out.println("Film Nom " + filmTest.getName());
                System.out.println("Film Nom Acteur principal " + filmTest.getMainActor());
                System.out.println("Film Nom Réalisateur " + filmTest.getRealisator());
                System.out.println("Film Support " + filmTest.getSupport().toString());
                System.out.println("Film Année " + filmTest.getAnnee());
                i++;
            }

        }


    }

    private static void afficherGlobalListeFilmLoue() {
    }

    private static void rechercheFilm() {
        System.out.println("Film à recherche");
        Scanner scDelete = new Scanner(System.in);
        String nomFilmASup = scDelete.nextLine();
        int i =0;
        boolean search = false;
        while (i < boitefilm.size() && (search == false)) {
            Film filmTest = (Film) boitefilm.elementAt(i);
            if (filmTest.getName().equals( nomFilmASup)) {
                System.out.println("Film Trouvé");
                System.out.println("Film Nom " + filmTest.getName());
                System.out.println("Film Nom Acteur principal " + filmTest.getMainActor());
                System.out.println("Film Nom Réalisateur " + filmTest.getRealisator());
                System.out.println("Film Support " + filmTest.getSupport().toString());
                System.out.println("Film Année " + filmTest.getAnnee());
                search=true;

            }
            else
                i++;
        }

    }

    private static void ajouterFilm() {
        Scanner filmScann = new Scanner(System.in);
        System.out.println("Saisir le nom du film");
        String nom = filmScann.nextLine();
        System.out.println("Saisir le nom de l'acteur");
        String actor = filmScann.nextLine();
        System.out.println("Saisir le nom du réalisateur");
        String realisator = filmScann.nextLine();
        Support filmSupport = null;
        System.out.println("Entrer le type de support (K7, USB, Blueray, DVD) : ");
        while(filmSupport == null)
        {
            try
            {
                String value = filmScann.nextLine();
                System.out.println("Valeur rentrée"+value);
                filmSupport = Support.valueOf(value);

            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Erreur Type non connu");
                filmSupport=Support.DVD;
            }

        }
        System.out.println("Saisir l'année du film");
        int annee = filmScann.nextInt();
        Film filmToCreate;
        filmToCreate = new Film(nom, actor,annee,realisator,filmSupport );
        boitefilm.addElement(filmToCreate);
    }

    private static void stockerFilm() {

        for (int i=0; i < boitefilm.size(); i++) {
            Film film = (Film) boitefilm.elementAt(i);
            System.out.println(" Nom " + film.getName());
            System.out.println(" Acteur Principal " + film.getMainActor());
            System.out.println(" Réalisateur " + film.getRealisator());
            System.out.println(" Année " + film.getAnnee());
            System.out.println("Support" + film.getSupport().toString());
        }
    }

}
