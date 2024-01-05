<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Models.Penalisation" %>
<%@ page import="Models.Abonné" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Pénalités</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<style type="text/css">
.image-buttons {
  border: none;
 
  padding: 0;
  background: none;
  cursor: pointer;
  display: inline-block; 
}


</style>
<body>

<div class="container-fluid mt-2">
    <div class="d-flex align-items-center justify-content-between">
        <h4>Liste des Pénalités</h4>
        <button class="btn  " onclick="validerTout()">
        <img alt="checkAll" src="${basePath}/images/check-all.png" height="40px" width="40px">
        Valider Tout</button>
    </div>

    <table class="table table-hover table-bordered">
        <thead>
        <tr>
            <th>ID Pénalité</th>
            <th>Nom d'utilisateur</th>
             <th>Type</th>
            <th>Nom et Prénom</th>
            <th>Date de Début</th>
            <th>Date de Fin</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% List<Penalisation> penalties = (List<Penalisation>) request.getAttribute("penalties");
            if (penalties != null) {
                for (Penalisation penalty : penalties) { %>
                    <tr id="penaltyRow_<%= penalty.getId_penalisation() %>"> 
                        <td><%= penalty.getId_penalisation() %></td>
                        <% Abonné abonne = penalty.getAbonne();%>
                        <td><%= abonne.getNom_utilisateur()%></td>
                        <td><%= abonne.getType()%></td>
                        <td><%= abonne.getNom() +" "+ abonne.getPrenom()%></td>
                        <td><%= penalty.getDate_debut() %></td>
                        <td><%= penalty.getDate_fin() %></td>
                        <td>
                            <button type="button" class="image-buttons ms-3" onclick="refuserPenalite(<%= penalty.getId_penalisation() %>)">
                               <img id="removeIcon" alt="remove" src="${basePath}/images/remove.png" height="30px" width="30px" >
                            </button>
                        </td>
                    </tr>
                <% }
            } %>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<!-- Add a script to handle the refuserPenalite function -->
<script>
    
</script>

</body>
</html>
