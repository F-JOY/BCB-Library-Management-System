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
         <img alt="" src="${basePath}/images/addEmprunt.png" height="30px" width="30px" data-bs-toggle="modal" data-bs-target="#exampleModal">
    </div>

    <table class="table  table-bordered">
        <thead>
        <tr>
            <th>ID </th>
           
            <th> Ouvrage</th>
           
            
            <th>Nom et Prénom</th>
            <th>Date Début</th>
            <th>Date Restitution</th>
            <th></th>
        </tr>
        </thead>
       <tbody>
    <% 
        List<Emprunt> emprunts = (List<Emprunt>) request.getAttribute("emprunts");
        if (emprunts != null) {
            for (Emprunt emprunt : emprunts) { 
                // Get the current date
                java.util.Date currentDate = new java.util.Date();

                // Compare the date of restitution with the current date
                boolean isDateInPast = emprunt.getDate_restitution().before(currentDate);

                // Set the CSS class based on the condition
                String cssClass = isDateInPast ? "text-danger" : "";

    %>
    <tr>
        <td class="align-middle"><%= emprunt.getId_emprunt() %></td>  
        <td class="align-middle">
            <div class="d-flex align-items-center">
                <h5 class=""><%= emprunt.getOuvrage().getId_ouvrage()+" :" %></h5>
                <p class="ms-3 mt-2 "> <%= emprunt.getOuvrage().getTitre() %></p>
            </div>
        </td>     
        <td class="align-middle"><%= emprunt.getAbonne().getNom() + " " + emprunt.getAbonne().getPrenom() %></td>
        <td class="align-middle"><%= emprunt.getDate_debut() %></td>
        <td class="<%= cssClass %> align-middle"><%= emprunt.getDate_restitution() %></td>
        <td class="align-middle">
            <button type="button" class="btn btn-primary ms-4">Restituer</button>
        </td>
    </tr>
    <% }
    } %>
</tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Ajouter Emprunt</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="">
        <div class="row mb-3">
      <label for="nom_utilisateur" class="col-sm-3 col-form-label">Nom d'utilisateur :</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="nom_utilisateur" name="nom_utilisateur" required>
      </div>
    </div>
	    <div class="row mb-3">
      <label for="password" class="col-sm-3 col-form-label">Code ouvrage :</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="password" name="password" required>
      </div>
    </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Ajouter</button>
      </div>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
