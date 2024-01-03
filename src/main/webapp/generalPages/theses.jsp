<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Models.Ouvrage" %>

<html>
<head>
    <title>Liste des Theses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
   <link rel="stylesheet" href="../assets/style2.css">
     <link rel="stylesheet" href="../assets/style.css">
</head>
<body>
<div class="container-fluid mt-5 ">

<h2 class="d-flex align-items-center justify-content-center home-hdr" style="margin: 0px; position: fixed; width: 100%">Liste des Theses disponibles</h2>


<div class="row">
 <div class="col-md-8 ">
 
    <table class="table table-hover  table-bordered mt-5 ms-4" border="1">
        <thead>
            <tr>
                <th>Code</th>
                
                <th>Titre</th>
                
            </tr>
        </thead>
         <tbody>
        <%
            List<Ouvrage> livres = (List<Ouvrage>) request.getAttribute("theses");
            for (Ouvrage livre : livres) {
        %>
            <tr>
                <td><%= livre.getId_ouvrage() %></td>
                
                <td><%= livre.getTitre() %></td>
            </tr>
             
           
        <%
            }
        %>
    </tbody>
    </table>
  
  </div>
</div>
</div>
 
  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script> 
</body>
</html>
