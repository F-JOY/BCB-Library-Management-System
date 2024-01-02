<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Models.Gestionnair" %>   
<%
    Gestionnair gestionnaire = (Gestionnair) request.getAttribute("gestionnaire");
    String nom = "inconnu"; 
    if (gestionnaire != null) {
        nom = gestionnaire.getNom();
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Pannel</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${basePath}/assets/style.css">
</head>
<body>
<!--navBar-->
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <a class="navbar-brand" href="#">
    <img src="${basePath}/images/logo.png" alt="Logo" class="logo">
  </a>
  <a href="${basePath}/generalPages/home.html" class="ms-auto me-4">
		<img src="${basePath}/images/homeIcon.png" class="home-icon"/>
  </a> 
</nav>
<!--main-->

<h1>Bienvenue,  <%= nom %> !</h1>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script> 
</body>
</html>