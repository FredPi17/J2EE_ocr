package com.sdzee.bdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class TestJDBC extends HttpServlet {
    private List<String> messages = new ArrayList<String>();

    public List<String> executerTests(HttpServletRequest request) {

        try {
            messages.add("Chargement du driver...");
            Class.forName("com.mysql.jdbc.Driver");
            messages.add("Driver chargé !");
        }
        catch(ClassNotFoundException e){
            messages.add("Erreur de chargement du driver");
        }

        String url = "jdbc:mysql://localhost:3306/java";
        String utilisateur = "root";
        String password = "password";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            messages.add("Connexion à la base de données...");
            connection = DriverManager.getConnection(url, utilisateur, password);
            messages.add("Connexion réussie");
            statement = connection.createStatement();
            messages.add("Objet requete crée");

            resultat = statement.executeQuery("SELECT id, email, mot_de_passe, nom FROM utilisateur;");
            messages.add("Requete \"SELECT id, email, mot_de_passe, nom FROM Utilisateur;\" effectuée !");

            while(resultat.next()){
                int idUtilisateur = resultat.getInt("id");
                String emailUtilisateur = resultat.getString("email");
                String motDePasse = resultat.getString("mot_de_passe");
                String nomUtilisateur = resultat.getString("nom");

                messages.add("Données retournées par la requete: id= "+ idUtilisateur + ", email = "+emailUtilisateur+", motdepasse = "+motDePasse+ ", nom = "+nomUtilisateur);
            }
        }
        catch (SQLException e){
            messages.add("Erreur lors de la connexion: <br/>" +e.getMessage());
        }
        finally {
            messages.add("Fermeture de l'objet statement");
            if(statement != null ){
                try {
                    statement.close();
                }
                catch (SQLException ignore)
                {
                }
            }
            messages.add("Fermeture de l'objet connexion");
            if(connection != null ){
                try {
                    connection.close();
                }
                catch (SQLException ignore){
                }
            }
        }
        return messages;
    }
}

