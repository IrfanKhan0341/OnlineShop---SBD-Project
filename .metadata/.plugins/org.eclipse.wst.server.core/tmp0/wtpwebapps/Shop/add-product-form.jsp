<!DOCTYPE html>
<html>

<head>
	<title>Add Product</title>
	<link type="text/css" rel="stylesheet" href="css/AdminConf.css">	
</head>

<body>

	<h2>Add Product</h2>
		
		<form action="ProductCreator" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nazwa produktu:</label></td>
						<td><input type="text" name="ProductName" /></td>
					</tr>

					<tr>
						<td><label>Marka:</label></td>
						<td><input type="text" name="Brand" /></td>
					</tr>

					<tr>
						<td><label>Kategoria:</label></td>
						<td><input type="text" name="Category" /></td>
					</tr>
					
					<tr>
						<td><label>Ilosc (sztuk):</label></td>
						<td><input type="text" name="Amount" /></td>
					</tr>
					
					<tr>
						<td><label>Cena:</label></td>
						<td><input type="text" name="Price" /></td>
					</tr>
					
					<tr>
						<td><label>Ilosc gramow produktu:</label></td>
						<td><input type="text" name="Ilosc" /></td>
					</tr>
					
					<tr>
						<td><label>Bialko:</label></td>
						<td><input type="text" name="Bialko" /></td>
					</tr>
					
					<tr>
						<td><label>Tluszcze:</label></td>
						<td><input type="text" name="Tluszcze" /></td>
					</tr>
					
					<tr>
						<td><label>Weglowodany:</label></td>
						<td><input type="text" name="Weglowodany" /></td>
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