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
				<th>Name</th>
				<th>Brand</th>
				<th>Category</th>
				<th>Amount</th>
				<th>Price</th>
				<th>Ilosc</th>
				<th>Bialko</th>
				<th>Tluszcze</th>
				<th>Weglowodany</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempProduct" items="${ProductList}">
			
					<c:url var="tempLink" value="ProductCreator">
						<c:param name="command" value="LOAD" />
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>
					
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
					<td>${tempProduct.ilosc} </td>
					<td>${tempProduct.bialko} </td>
					<td>${tempProduct.tluszcz} </td>
					<td>${tempProduct.weglowodany} </td>
					<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Jestes pewny ze chcesz usunac ten produkt?'))) return false">
							Delete</a>	
					</td>
				</tr>
			</c:forEach>
			
		</table>
		
		<input type="button" value="Add_Product"
			onclick="window.location.href='add-product-form.jsp'; return false"
			class="add-product-button"
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
