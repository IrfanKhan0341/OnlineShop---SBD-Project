<!DOCTYPE html>
<html>

<head>
	<title>Update Product</title>
	<link type="text/css" rel="stylesheet" href="css/AdminConf.css">	
</head>

<body>

	<h2>Update Discount</h2>
		
		<form action="DiscountCreator" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="productId" value="${theDiscount.id }" />
			<table>
				<tbody>
					<tr>
						<td><label>Nazwa produktu:</label></td>
						<td><input type="text" name="ProductName" 
									value="${theDiscount.nazwa }"/></td>
					</tr>

					<tr>
						<td><label>Ilosc:</label></td>
						<td><input type="text" name="Amount" value="${theDiscount.ilosc }"/></td>
					</tr>

					<tr>
						<td><label>Stara cena:</label></td>
						<td><input type="text" name="old_price" value="${theDiscount.stara_cena }" /></td>
					</tr>
					
					<tr>
						<td><label>Nowa cena:</label></td>
						<td><input type="text" name="new_price" value="${theDiscount.nowa_cena }"/></td>
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
			<a href="DiscountCreator">Back to List</a>
		</p>
</body>

</html>