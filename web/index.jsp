<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : May 4, 2015, 1:48:00 PM
    Author     : trusty
--%>
<sql:query var="categories" dataSource="jdbc/etailer">
    SELECT  *  FROM category
</sql:query>

<div id="indexLeftColumn">
    <div id="welcomeText">
        <p>[ welcome text ]</p>
        categoryImagePath:${initParam.categoryImagePath}
        productImagePath:${initParam.productImagePath}
    </div>
</div>
<div id="indexRightColumn">
    <c:forEach var="category" items="${categories.rows}">
        <div class="categoryBox">
            <a href="category?${category.id}">
                <span class="categoryLabelText">${category.name}</span>
                <img src="${initParam.categoryImagePath}${category.name}.jpg"
                     alt="${category.name}">
            </a>
        </div>
    </c:forEach>    
</div>
