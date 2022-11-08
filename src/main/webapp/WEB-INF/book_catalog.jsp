<%@ page language="java" %>
<%@ page import="com.webshoppe.ecommerce.entity.Book"%>
<%@ page import="java.util.List"%>

<%
List<Book> book_catalog = (List<Book>) request.getAttribute("book_catalog");
%>
<html>
    <head>
        <title>Webshoppe::Book Catalog</title>
        <style type="text/css">
            body {
                margin: 50px;
            }
        </style>
    </head>
    <body>
        <h2>Book Catalog</h2>
        <hr/>
        <%
        if(book_catalog.isEmpty()) {
        %>
            <b>Empty Book Catalog!</b>
        <%
        }
        %>
        
         <%
        if(!book_catalog.isEmpty()) {
        %>
        <table>
            <thead>
                <tr>
	                <td>Book ID</td>
	                <td>Book Title</td>
	                <td>Book Description</td>
	                <td>Book AID</td>
	                <td>Book Price</td>
                </tr>
            </thead>
            <tbody>
                <%
                for(Book book: book_catalog) {
                %>
                    <tr>
	                    <td><%= book.getBookId() %></td>
	                    <td><%= book.getBookTitle() %></td>
	                    <td><%= book.getBookDesc() %></td>
	                    <td><%= book.getBookAID() %></td>
	                    <td><%= book.getBookPrice() %></td>
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