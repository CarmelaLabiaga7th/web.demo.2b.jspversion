<%@ page language="java" %>
<%@ page import="com.webshoppe.ecommerce.entity.Toy"%>
<%@ page import="java.util.List"%>

<%
List<Toy> toy_catalog = (List<Toy>) request.getAttribute("toy_catalog");
%>
<html>
    <head>
        <title>Webshoppe::Toy Catalog</title>
        <style type="text/css">
            body {
                margin: 50px;
            }
        </style>
    </head>
    <body>
        <h2>Toy Catalog</h2>
        <hr/>
        <%
        if(toy_catalog.isEmpty()) {
        %>
            <b>Empty Toy Catalog!</b>
        <%
        }
        %>
        
         <%
        if(!toy_catalog.isEmpty()) {
        %>
        <table>
            <thead>
                <tr>
	                <td>ID</td>
	                <td>Name</td>
	                <td>Description</td>
	                <td>Price</td>
                </tr>
            </thead>
            <tbody>
                <%
                for(Toy toy: toy_catalog) {
                %>
                    <tr>
	                    <td><%= toy.getId() %></td>
	                    <td><%= toy.getName() %></td>
	                    <td><%= toy.getDescription() %></td>
	                    <td><%= toy.getPrice() %></td>
                    </tr>
                <%
                }
                %>
            </tbody>
        </table>
        <%
        }
        %>
    </body>
</html>