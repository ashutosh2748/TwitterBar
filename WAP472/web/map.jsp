<%-- 
    Document   : index
    Created on : Nov 20, 2016, 11:34:39 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WAP 472 Twitter Interactive WEBview </title>
        <link href="css/map.css" rel="stylesheet" type="text/css">
      

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="js/script.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
        <c:import url="menu.jsp"></c:import>
         <div ><img src="images/twitter-banner.png" alt="twitter-banner" class="banner"/></div>
        <button id="locate" style="display:none">Click me</button>
        <div style="display:none">Current Location</div>
        <div id="something" style="display:none">here</div>
        <div style="display:none">Clicked Location</div>
        <div id="morething" ></div>
             <div class="alert alert-info alert-dismissable">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    <strong>Info!</strong> Latest Trends are Shown Near the Clicked Location.
  </div>            
            
        <div id="trends"></div>
        <section id="maps">
           <!-- <h3>My Google Maps Section</h3>-->
<div id="map"></div>
<!-- Replace the value of the key parameter with your own API key. -->
<script async defer
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBbkLzxVwVpwde92WUw18JPcY1vPr1sHMk&callback=initMap">
</script>
</section>
                        <c:import url="footer.jsp"></c:import>

        </div>
    </body>
</html>
