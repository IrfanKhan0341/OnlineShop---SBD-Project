<!DOCTYPE html>
<html>

<head>
	<title>Add User</title>
	<link type="text/css" rel="stylesheet" href="css/AdminConf.css">	
</head>

<body>

	<h2>Add User</h2>
		
		<form action="UserServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Login:</label></td>
						<td><input type="text" name="Login" /></td>
					</tr>

					<tr>
						<td><label>Haslo:</label></td>
						<td><input type="Password" name="Haslo" /></td>
					</tr>

					<tr>
						<td><label>Imie:</label></td>
						<td><input type="text" name="Imie" /></td>
					</tr>
					
					<tr>
						<td><label>Nazwisko:</label></td>
						<td><input type="text" name="Nazwisko" /></td>
					</tr>
					
					<tr>
						<td><label>Numer telefonu:</label></td>
						<td><input type="text" name="Tel" /></td>
					</tr>
					
					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="Email" /></td>
					</tr>
					
					<tr>
						<td><label>Ulica:</label></td>
						<td><input type="text" name="Ulica" /></td>
					</tr>
					
					<tr>
						<td><label>Numer domu:</label></td>
						<td><input type="text" name="Nr_domu" /></td>
					</tr>
					
					<tr>
						<td><label>Numer mieszkania:</label></td>
						<td><input type="text" name="Nr_mieszkania" /></td>
					</tr>
					
					<tr>
						<td><label>Kod pocztowy:</label></td>
						<td><input type="text" name="Post_code" /></td>
					</tr>
					
					<tr>
						<td><label>Miasto:</label></td>
						<td><input type="text" name="City" /></td>
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
			<a href="MainServlet">Back to List</a>
		</p>
</body>

</html>