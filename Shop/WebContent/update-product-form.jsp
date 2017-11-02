<!DOCTYPE html>
<html>

<head>
	<title>Update Product</title>
	<link type="text/css" rel="stylesheet" href="css/AdminConf.css">	
</head>

<body>

	<h2>Update Product</h2>
		
		<form action="ProductCreator" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="productId" value="${theProduct.id }" />
			<table>
				<tbody>
					<tr>
						<td><label>Nazwa produktu:</label></td>
						<td><input type="text" name="ProductName" 
									value="${theProduct.productName }"/></td>
					</tr>

					<tr>
						<td><label>Marka:</label></td>
						<td><input type="text" name="Brand" value="${theProduct.brand }"/></td>
					</tr>

					<tr>
						<td><label>Kategoria:</label></td>
						<td><input type="text" name="Category" value="${theProduct.category }" /></td>
					</tr>
					
					<tr>
						<td><label>Ilosc (sztuk):</label></td>
						<td><input type="text" name="Amount" value="${theProduct.sztuki }"/></td>
					</tr>
					
					<tr>
						<td><label>Cena:</label></td>
						<td><input type="text" name="Price" value="${theProduct.price }"/></td>
					</tr>
					
					<tr>
						<td><label>Ilosc gramow produktu:</label></td>
						<td><input type="text" name="Ilosc" value="${theProduct.ilosc }"/></td>
					</tr>
					
					<tr>
						<td><label>Bialko:</label></td>
						<td><input type="text" name="Bialko" value="${theProduct.bialko }"/></td>
					</tr>
					
					<tr>
						<td><label>Tluszcze:</label></td>
						<td><input type="text" name="Tluszcze" value="${theProduct.tluszcz }"/></td>
					</tr>
					
					<tr>
						<td><label>Weglowodany:</label></td>
						<td><input type="text" name="Weglowodany" value="${theProduct.weglowodany }"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
				
		<p>
			<a href="ProductCreator">Back to List</a>
		</p>
</body>

</html>