<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale }" scope="session" />
<fmt:setLocale value="${theLocale }"/>
<fmt:setBundle basename="shop.language.labels"/>

<!DOCTYPE HTML>
<html>
<head>
    <meta name="description" content="Shop"/>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="Wojciech" content="Żebrowski" />

	<title><fmt:message key="label.shop_title" /></title>
    <link rel="stylesheet" href="Configuration.css" media="screen" type="text/css"/>
</head>

<body>
<div id="header">
    <div class="container">
        <div class="flag">
          <a href="Kontakt.jsp?theLocale=en_GB"> <img alt="English" src="img/en_GB_flag.png"/> </a>  
        </div>
        <div class="flag">
            <a href="Kontakt.jsp?theLocale=pl_PL"> <img alt="Polski" src="img/pl_PL_flag.png"/> </a>
        </div>
        
          <div class="strefa_klienta">
            <div class="logowanie">
                <fmt:message key="label.client_side" />
                
                <form action="MainServletLog" method="GET">
                <input type="text" name="login" placeholder="<fmt:message key="label.login" />" onclick="placeholder=' '"/>
                <input type="password" name="haslo" placeholder="<fmt:message key="label.password" />" onclick="placeholder=' '" />
                <input type="submit" value="<fmt:message key="label.logButton"/>" />
                </form>
                
            </div>
            
            <div class="rejestracja">
                <p> <fmt:message key="label.registration_desc"/> <a href="add-user-form.jsp"><fmt:message key="label.registration" /></a></p>
            </div>
        </div>
        
        <div class="logo">
           <a href="MainServlet"><img alt="LOGO" src="img/logo.png"/></a>
        </div>
        <div class="menu">
            <ul>
                <li><a href="O_sklepie.jsp"> <fmt:message key="label.shop_about"/> </a></li>
                <li><a href="ProductController"> <fmt:message key="label.products"/> </a></li>
                <li><a href="Kontakt.jsp"> <fmt:message key="label.contact"/> </a></li>
            </ul>
        </div>
        
        <div class="koszyk">
            <a href="#"> <img alt="KOSZYK" src="img/Koszyk.png"/></a>
        </div>

    </div>
</div>

<div id="content">
    <div class="container">
       
       <div id="kontakt">
            <p>
                <fmt:message key="label.inviteToContact" />:
                <br />
                <br />
                <strong>kontakt@shop.pl</strong> 
                <br />
                <br />
                <fmt:message key="label.contactByPhone" />: 000-000-000
                <br />
                <br />
                <fmt:message key="label.companyAddress" />: 
                <br><strong>ul. xxxx 20, 00-000 MIASTO</strong> 
            </p>
       </div>  
	</div>
</div>   
    
<div id="stopka">
	<div class="container">
		<p>Copyright &copy; 2017 Wojciech Zebrowski</p>
	</div>
</div>
	
</body>
</html>