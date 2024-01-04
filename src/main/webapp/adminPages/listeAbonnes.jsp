<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Models.Abonné" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Abonnés</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<style type="text/css">
.image-buttons {
  border: none;
  padding: 0;
  background: none;
  cursor: pointer;
  display: inline-block; /* Ensures that the buttons appear side by side */
}


</style>
</head>
<body>


<div class="container-fluid mt-2">
     <div class="d-flex align-items-center-center justify-content-between">
       <h4>Liste des Abonnés</h4>
       <img alt="" src="${basePath}/images/add_user.png" height="30px" width="30px" data-bs-toggle="modal" data-bs-target="#exampleModal">
    </div>
    
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Type</th>
                <th>Nom d'utilisateur</th>
                <th>Nom et Prénom</th>
                <th>Date de Naissance</th>
                <th>Numéro de Téléphone</th>
                <th>Adresse</th>
                <th>Email</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <% List<Abonné> abonnés = (List<Abonné>) request.getAttribute("abonnes");
                if (abonnés != null) {
                    for (Abonné abonné : abonnés) { %>
                        <tr>
                            <td><%= abonné.getId_utilisateur() %></td>
                            <td><%= abonné.getType() %></td>
                            <td data-bs-toggle="tooltip" data-bs-placement="top" title="PSW : <%= abonné.getMot_de_pass() %>">
                            <%= abonné.getNom_utilisateur() %></td>
                            <td><%= abonné.getNom() + " " + abonné.getPrenom() %></td>
                            <td><%= abonné.getDate_naiss() %></td>
                            <td><%= abonné.getNum_tel() %></td>
                            <td><%= abonné.getAdresse() %></td>
                            <td><%= abonné.getEmail() %></td>
                            <td> 
                           <button class="image-buttons"><img alt="edit" src="${basePath}/images/edit.png" height="24px" width="24px"></button>
						<button class="image-buttons"><img alt="delete" src="${basePath}/images/delete.png" height="24px" width="24px"></button>
                            </td>
                            
                        </tr>
                    <% }
                } %>
        </tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" >
   <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addAbonneModalLabel">Ajouter Abonné</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
     

<div class="modal-body">
  
  <form id="addAbonneForm">
    <div class="row mb-3">
      <label for="nom_utilisateur" class="col-sm-3 col-form-label">Nom d'utilisateur :</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="nom_utilisateur" name="nom_utilisateur" required>
      </div>
    </div>
	    <div class="row mb-3">
      <label for="password" class="col-sm-3 col-form-label">Mot de pass :</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="password" name="password" required>
      </div>
    </div>
    <div class="row mb-3">
      <label for="nom" class="col-sm-3 col-form-label">Nom :</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="nom" name="nom" required>
      </div>
    </div>

    <div class="row mb-3">
      <label for="prenom" class="col-sm-3 col-form-label">Prénom :</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="prenom" name="prenom" required>
      </div>
    </div>

    <div class="row mb-3">
      <label for="date_naiss" class="col-sm-3 col-form-label">Date de Naissance :</label>
      <div class="col-sm-9">
        <input type="date" class="form-control" id="date_naiss" name="date_naiss" required>
      </div>
    </div>

    <div class="row mb-3">
      <label for="num_tel" class="col-sm-3 col-form-label">Numéro de Téléphone :</label>
      <div class="col-sm-9">
        <input type="tel" class="form-control" id="num_tel" name="num_tel" required>
      </div>
    </div>

    <div class="row mb-3">
      <label for="adresse" class="col-sm-3 col-form-label">Adresse :</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="adresse" name="adresse" required>
      </div>
    </div>

    <div class="row mb-3">
      <label for="email" class="col-sm-3 col-form-label">Email :</label>
      <div class="col-sm-9">
        <input type="email" class="form-control" id="email" name="email" required>
      </div>
    </div>

    <div class="row mb-3">
      <label for="type" class="col-sm-3 col-form-label">Type :</label>
      <div class="col-sm-9">
        <select class="form-select" id="type" name="type" required>
          <option value="etudiant_extern">Étudiant Externe</option>
          <option value="etudiant_intern">Étudiant Interne</option>
          <option value="enseignant">Enseignant</option>
        </select>
      </div>
    </div>

    <div class="row mb-3">
      <div class="col-sm-12 d-flex justify-content-center">
        <button type="button" class="btn btn-primary" onclick="addAbonne()">Enregistrer</button>
      </div>
    </div>
  </form>
</div>



    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
