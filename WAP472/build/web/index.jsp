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
      

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="js/scriptkris.js" type="text/javascript"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="js/jquery.cookie.js" type="text/javascript"></script>
  
  <script src="js/script.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
        <c:import url="menu.jsp"></c:import>
        <div ><img src="images/twitter-banner.png" alt="twitter-banner" class="banner"/></div>
        
        <button type="button" class="btn btn-default" id="comedy">Comedy</button>
<button type="button" class="btn btn-default" id="action">Action</button>
<button type="button" class="btn btn-default" id="java">Java</button>
<button type="button" class="btn btn-default" id="business">Business</button>
  
  
  <div id="tab-content" class="tabbox">
    
    </div>
<div class="clear"></div>
<div>
        <c:import url="footer.jsp"></c:import>
    </div>

  </div>
        

  
        
        
               

</body>
</html>
