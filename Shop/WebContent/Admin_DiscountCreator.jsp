<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta name="description" content="Shop"/>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="Wojciech" content="Zebrowski" />

	<title>Shop - wiecej niz sklep!</title>
    <link rel="stylesheet" href="AdminConf.css" media="screen" type="text/css"/>
</head>

<body>
<div id="header">
    <div class="container">
        
            <div>  
	            <div class="rejestracja">
	                <p>WITAJ admin !!!</p>
	            </div>
	            <div class="logOut">
	            	<a href="MainServlet">Wyloguj</a>
	            </div>
            </div>
            
        <div class="logo">
           <a href="Admin_Main.jsp"><img alt="LOGO" src="img/logo.png"/></a>
        </div>
        <div class="menu">
            <ul>
                <li><a href="ProductCreator">KREATOR PRODUKTOW</a></li>
                <li><a href="DiscountCreator">KREATOR PROMOCJI</a></li>
            </ul>
        </div>

    </div>
</div>

<div id="content">
    <div class="container">
        <table>
			<tr>
				<th>Nazwa</th>
				<th>Ilosc</th>
				<th>Stara_cena</th>
				<th>Nowa_cena</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempProduct" items="${DiscountList}">
			
					<c:url var="tempLink" value="DiscountCreator">
						<c:param name="command" value="LOAD" />
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
				<tr>
					<td>${tempProduct.nazwa} </td>
					<td>${tempProduct.ilosc} </td>
					<td>${tempProduct.stara_cena} </td>
					<td>${tempProduct.nowa_cena} </td>
					<td> 
							<a href="${tempLink}">Update</a>	
					</td>
				</tr>
			</c:forEach>
			
		</table>
	
    </div>
</div>

<div id="stopka">
    <div class="container">
        <p>Copyright &copy; 2017 Wojciech Zebrowski</p>
    </div>

</div>
</body>
</html>
