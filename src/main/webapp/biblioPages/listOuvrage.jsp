<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Models.Ouvrage" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Ouvrages</title>
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
       <h4>Liste des Ouvrages</h4>
       <img alt="" src="${basePath}/images/add-book.png" height="30px" width="30px" data-bs-toggle="modal" data-bs-target="#exampleModal">
    </div>
    
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                 <th>Type</th>
                <th>Titre</th>
                <th>Faculté</th>
                <th>ISBN</th>
                <th>Prix</th>
                <th>Disponible</th>
               <th></th>                
            </tr>
        </thead>
        <tbody>
            <% List<Ouvrage> ouvrages = (List<Ouvrage>) request.getAttribute("ouvrages");
                if (ouvrages != null) {
                    for (Ouvrage ouvrage : ouvrages) { %>
                        <tr>
                            <td><%= ouvrage.getId_ouvrage() %></td>
                             <td><%= ouvrage.getType() %></td>
                            <td><%= ouvrage.getTitre() %></td>
                             <td><%= ouvrage.getFaculte() %></td>
                            <td><%= ouvrage.getIsbn() %></td>
                            <td><%= ouvrage.getPrix() %></td>
                            <td><%= ouvrage.getDisponible() %></td>
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
