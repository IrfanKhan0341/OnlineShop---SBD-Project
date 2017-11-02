<%@ page import="java.util.*, shop.product.*, javax.servlet.http.HttpSession" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale }" scope="session" />
<fmt:setLocale value="${theLocale }"/>
<fmt:setBundle basename="shop.language.labels"/>

<% 	HttpSession sesja = request.getSession(); 
	String login = (String)sesja.getAttribute("login");
		%>

<!DOCTYPE HTML>
<html>
<head>
    <meta name="description" content="Shop"/>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="Wojciech" content="Zebrowski" />

	<title>Shop - wiecej niz sklep!</title>
    <link rel="stylesheet" href="Configuration.css" media="screen" type="text/css"/>
</head>

<body>
<div id="header">
    <div class="container">
        <div class="flag">
          <a href="Basket.jsp?theLocale=en_GB"> <img alt="English" src="img/en_GB_flag.png"/> </a>  
        </div>
        <div class="flag">
            <a href="Basket.jsp?theLocale=pl_PL"> <img alt="Polski" src="img/pl_PL_flag.png"/> </a>
        </div>
        
        <div class="strefa_klienta">
            <p>Witaj <%=login %> </p>
            <a href="MainServlet">Wyloguj</a>
        </div>
        <div class="logo">
           <a href="MainServletLog"><img alt="LOGO" src="img/logo.png"/></a>
        </div>
        <div class="menu">
            <ul>
                <li><a href="O_sklepieLog.jsp"> <fmt:message key="label.shop_about"/> </a></li>
                <li><a href="ProductControllerLog"> <fmt:message key="label.products"/> </a></li>
                <li><a href="KontaktLog.jsp"> <fmt:message key="label.contact"/> </a></li>
            </ul>
        </div>
        
        <div class="koszyk">
            <a href="Basket"> <img alt="KOSZYK" src="img/Koszyk.png"/></a>
        </div>

    </div>
</div>

<div id="content">
    <div class="container">
        <table>
			<tr>
				<th>Nazwa</th>
				<th>Marka</th>
				<th>Kategoria</th>
				<th>Ilosc</th>
				<th>Cena</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempProduct" items="${ProductList}">
				
					<c:url var="deleteLink" value="ProductCreator">
						<c:param name="command" value="DELETE" />
						<c:param name="p" value="${tempProduct.id}" />
					</c:url>
				<tr>
					<td>${tempProduct.productName} </td>
					<td>${tempProduct.brand} </td>
					<td>${tempProduct.category} </td>
					<td>${tempProduct.sztuki} </td>
					<td>${tempProduct.price} </td>
					<td> 	 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Jestes pewny ze chcesz usunac ten produkt?'))) return false">
							Delete</a>	
					</td>
				</tr>
			</c:forEach>
			
		</table>
		
		<input type="button" value="Confirm"
			onclick="window.location.href='Basket'; return false"
			class="confirm"
		/>
    </div>
</div>

<div id="stopka">
    <div class="container">
        <p>Copyright &copy; 2017 Wojciech Zebrowski</p>
    </div>

</div>
</body>
</html>
