package com.Auteur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Noms {
    private Connection connexion;

    public List<Auteur> recupererUtilisateurs() {
        List<Auteur> auteurs = new ArrayList<Auteur>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();

        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT nom, prenom, email FROM utilisateur;");

            // Récupération des données
            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String email = resultat.getString("email");

                Auteur auteur = new Auteur();
                auteur.setNom(nom);
                auteur.setPrenom(prenom);
                auteur.setEmail(email);

                auteurs.add(auteur);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }

        return auteurs;
    }

    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterUtilisateur(Auteur auteur) {
        loadDatabase();

        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO utilisateur(nom, prenom, email) VALUES(?, ?, ?);");
            preparedStatement.setString(1, auteur.getNom());
            preparedStatement.setString(2, auteur.getPrenom());
            preparedStatement.setString(3, auteur.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
