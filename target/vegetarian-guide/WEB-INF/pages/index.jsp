<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"			prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"			prefix="fmt"%>
<html> 
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    
    <body class="container">
        <div class="page-header">
          <h1>Bazar</h1>
        </div>
        
        <div class="row">
        	<c:forEach items="${products}" var="p" varStatus="i">
				<div class="box">
	                <div class="thumbnail">
	                    <a href="${p.image}" target="_blank">
	                        <img src="${p.image}">
	                    </a>
	                    <div class="caption">
	                    	<fmt:setLocale value="pt-BR" scope="session"/>
	                        <h4><fmt:formatNumber type="currency" value="${p.price}" currencySymbol="&#8364; " minFractionDigits="2"/></h4>
	                        <p>${p.ptName}</p>
	                        <p>${p.enName}</p>
	                    </div>
	                </div>
	            </div>  
			</c:forEach>
		</div>
    </body>
</html>