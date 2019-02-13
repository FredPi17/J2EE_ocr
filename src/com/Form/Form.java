package com.Form;

import com.Auteur.Auteur;
import com.Auteur.Noms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Form")
public class Form extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Form() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Noms tableNoms = new Noms();
        request.setAttribute("auteur", tableNoms.recupererUtilisateurs());
        this.getServletContext().getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");

        Auteur auteur = new Auteur();
        auteur.setNom(nom);
        auteur.setPrenom(prenom);
        auteur.setEmail(email);

        Noms tableNoms = new Noms();
        tableNoms.ajouterUtilisateur(auteur);

        request.setAttribute("auteur", tableNoms.recupererUtilisateurs());

        this.getServletContext().getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
    }
}
