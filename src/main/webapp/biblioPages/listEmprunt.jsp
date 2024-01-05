<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Models.Emprunt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Emprunts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>

<div class="container-fluid mt-2">
    <div class="d-flex align-items-center-center justify-content-between">
        <h4>Liste des Emprunts</h4>
    </div>

    <table class="table table-hover table-bordered">
        <thead>
        <tr>
            <th>ID Emprunt</th>
            <th>ID Ouvrage</th>
            <th>Titre Ouvrage</th>
            <th>ID Utilisateur</th>
            <th>Nom Utilisateur</th>
            <th>Nom et Prénom</th>
            <th>Date Début</th>
            <th>Date Restitution</th>
        </tr>
        </thead>
        <tbody>
        <% List<Emprunt> emprunts = (List<Emprunt>) request.getAttribute("emprunts");
            if (emprunts != null) {
                for (Emprunt emprunt : emprunts) { %>
                    <tr>
                        <td><%= emprunt.getId_emprunt() %></td>
                        <td><%= emprunt.getOuvrage().getId_ouvrage() %></td>
                        <td><%= emprunt.getOuvrage().getTitre() %></td>
                        <td><%= emprunt.getAbonne().getId_utilisateur() %></td>
                        <td><%= emprunt.getAbonne().getNom_utilisateur() %></td>
                        <td><%= emprunt.getAbonne().getNom() + " " + emprunt.getAbonne().getPrenom() %></td>
                        <td><%= emprunt.getDate_debut() %></td>
                        <td><%= emprunt.getDate_restitution() %></td>
                    </tr>
                <% }
            } %>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
