<%@ page language="java" %>
<%@ page import="com.webshoppe.ecommerce.entity.Flower"%>
<%@ page import="java.util.List"%>

<%
List<Flower> flower_catalog = (List<Flower>) request.getAttribute("flower_catalog");
%>
<html>
    <head>
        <title>Webshoppe::Flower Catalog</title>
        <style type="text/css">
            body {
                margin: 50px;
            }
        </style>
    </head>
    <body>
        <h2>Flower Catalog</h2>
        <hr/>
        <%
        if(flower_catalog.isEmpty()) {
        %>
            <b>Empty Flower Catalog!</b>
        <%
        }
        %>
        
         <%
        if(!flower_catalog.isEmpty()) {
        %>
        <table>
            <thead>
                <tr>
	                <td>Flower ID</td>
	                <td>Flower Name</td>
	                <td>Flower Description</td>
	                <td>Flower Price</td>
                </tr>
            </thead>
            <tbody>
                <%
                for(Flower flower: flower_catalog) {
                %>
                    <tr>
	                    <td><%= flower.getFlowerId() %></td>
	                    <td><%= flower.getFlowerName() %></td>
	                    <td><%= flower.getFlowerDescription() %></td>
	                    <td><%= flower.getFlowerPrice() %></td>
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