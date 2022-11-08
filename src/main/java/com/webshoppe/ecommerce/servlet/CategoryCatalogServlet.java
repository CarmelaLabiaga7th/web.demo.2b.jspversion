package com.webshoppe.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshoppe.ecommerce.entity.*;
import com.webshoppe.ecommerce.jdbc.JdbcConnectionManager;
import com.webshoppe.ecommerce.repository.BookRepository;
import com.webshoppe.ecommerce.repository.FlowerRepository;
import com.webshoppe.ecommerce.repository.ToyRepository;
import com.webshoppe.ecommerce.service.*;

/**
 * Servlet implementation class CategoryCatalogServlet
 */
@WebServlet("/CategoryCatalogServlet")
public class CategoryCatalogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ToyCatalogService toyCatalogService;
    private FlowerCatalogService flowerCatalogService;
    private BookCatalogService bookCatalogService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    public void init() throws ServletException {
        final JdbcConnectionManager jdbcConnectionManager = new JdbcConnectionManager();
        final ToyRepository toyRepository = new ToyRepository(jdbcConnectionManager);
        final FlowerRepository flowerRepository = new FlowerRepository(jdbcConnectionManager);
        final BookRepository bookRepository = new BookRepository(jdbcConnectionManager);
        toyCatalogService = new ToyCatalogService(toyRepository);
        flowerCatalogService = new FlowerCatalogService(flowerRepository);
        bookCatalogService = new BookCatalogService(bookRepository);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String catalogCategory = request.getParameter("name").toString();
        final StringBuilder stringBuilder = new StringBuilder();

        switch (catalogCategory) {
            case "toys":
                final List<Toy> toys = toyCatalogService.getToyCatalog();

                request.setAttribute("toy_catalog", toys);
                final RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/toy_catalog.jsp");
                dispatcher.forward(request, response);
                break;

            case "flowers":
                final List<Flower> flowers = flowerCatalogService.getFlowerCatalog();

                request.setAttribute("flower_catalog", flowers);
                final RequestDispatcher flower_dispatcher = request.getRequestDispatcher("/WEB-INF/flower_catalog.jsp");
                flower_dispatcher.forward(request, response);
                break;
            case "books":
                final List<Book> books = bookCatalogService.getBookCatalog();

                request.setAttribute("book_catalog", books);
                final RequestDispatcher book_dispatcher = request.getRequestDispatcher("/WEB-INF/book_catalog.jsp");
                book_dispatcher.forward(request, response);

        }

        PrintWriter out = response.getWriter();
        out.println(stringBuilder.toString());
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        final String minimumPriceParam = request.getParameter("minimum-price");
        final BigDecimal minimumPrice = new BigDecimal(minimumPriceParam);

        final String maximumPriceParam = request.getParameter("maximum-price");
        final BigDecimal maximumPrice = new BigDecimal(maximumPriceParam);

        final StringBuilder stringBuilder = new StringBuilder();
        String catalogCategory = request.getParameter("category").toString();
        switch (catalogCategory) {
            case "toy_category":
                final List<Toy> toys = toyCatalogService.getToyCatalog(minimumPrice, maximumPrice);

                request.setAttribute("toy_catalog", toys);
                final RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/toy_catalog.jsp");
                dispatcher.forward(request, response);
                break;
            case "flower_category":
                final List<Flower> flowers = flowerCatalogService.getFlowerCatalog(minimumPrice, maximumPrice);

                request.setAttribute("flower_catalog", flowers);
                final RequestDispatcher flower_dispatcher = request.getRequestDispatcher("/WEB-INF/flower_catalog.jsp");
                flower_dispatcher.forward(request, response);
                break;

            case "book_category":
                final List<Book> books = bookCatalogService.getBookCatalog(minimumPrice, maximumPrice);

                request.setAttribute("book_catalog", books);
                final RequestDispatcher book_dispatcher = request.getRequestDispatcher("/WEB-INF/book_catalog.jsp");
                book_dispatcher.forward(request, response);
        }

        PrintWriter out = response.getWriter();
        out.println(stringBuilder.toString());
        out.flush();
        out.close();

    }

}
