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

	<title><fmt:message key="label.shop_title" /></title>
    <link rel="stylesheet" href="Configuration.css" media="screen" type="text/css"/>
</head>

<body>
<body>
<div id="header">
    <div class="container">
        <div class="flag">
          <a href="O_sklepieLog.jsp?theLocale=en_GB"> <img alt="English" src="img/en_GB_flag.png"/> </a>  
        </div>
        <div class="flag">
            <a href="O_sklepieLog.jsp?theLocale=pl_PL"> <img alt="Polski" src="img/pl_PL_flag.png"/> </a>
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
            <a href="Basket.jsp"> <img alt="KOSZYK" src="img/Koszyk.png"/></a>
        </div>

    </div>
</div>

<div id="content">
    <div class="container">
       
       <div id="o_sklepie">
            <p>
                1.<fmt:message key="label.firstDesc" /> 
                <br />
                <br />
                2.<fmt:message key="label.secondDesc" />
                <br />
                <br />
                3.<fmt:message key="label.thirdDesc" />
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