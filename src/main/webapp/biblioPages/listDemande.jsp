<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Models.reservation" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Reservations</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>

<div class="container-fluid mt-2">
    <div class="d-flex align-items-center justify-content-between">
        <a href="#" style="text-decoration: none"><h4>Demandes de Reservations</h4></a>
         <a href="#" style="text-decoration: none"><h4>Demandes de Prolongation</h4></a>
    </div>

    <table class="table table-bordered">
        <thead>
     <tr>
            <th>Abonne</th>
            <th>Nom et prenom</th>
            <th>Ouvrage</th>
            <th>Titre</th>
            <th>Disponible</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% List<reservation> reservations = (List<reservation>) request.getAttribute("reservationDetails");
            if (reservations != null) {
                for (reservation reservation : reservations) { %>
                    <tr>
                <td><%= reservation.getAbonne().getId_utilisateur() %></td>
                <td><%= reservation.getAbonne().getNom() +"  "+ reservation.getAbonne().getPrenom() %></td>
                <td><%= reservation.getOuvrage().getId_ouvrage() %></td>
                <td><%= reservation.getOuvrage().getTitre() %></td>
                <td> <%= reservation.getOuvrage().getDisponible() %></td>
                <td class="align-middle">
                <button type="button" class="btn btn-primary ms-4">Enregistrer</button>
                </td>
            </tr>
                <% }
            } %>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
