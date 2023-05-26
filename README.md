# User-MVC

The provided code demonstrates a servlet implementation for handling user login data from an HTML form.

## Usage
To use the User Controller Servlet, follow these steps:

Set up a Java web project and configure a Servlet container (e.g., Apache Tomcat) to run the servlet.

Create an HTML login form that collects the username and password. Make sure to specify the form action as /UserController to match the servlet URL mapping.

<form action="/UserController" method="post">
    <!-- Login form fields -->
</form>
Implement the doPost() method in the UserController servlet class to handle the form submission. The method retrieves the username and password parameters, performs authentication using a UserDAO, and redirects to appropriate pages based on the authentication result.

Create the UserDAO class to handle user data access and retrieval. The getUser() method in this class checks if the provided username and password match the stored user credentials.

Create the success.jsp and error.jsp pages to display the success and error messages respectively.

Deploy the servlet project to the Servlet container and access the login form through a web browser.

Servlet Mapping
The UserController servlet is mapped to the /UserController URL using the @WebServlet annotation.

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    // Servlet code
}
Make sure the servlet mapping matches the form action in your HTML login form.

## User Authentication
The servlet uses a UserDAO object to authenticate the user's login credentials. The getUser() method in the UserDAO class checks if the provided username and password match the stored user credentials. If the authentication is successful, the user is redirected to the success.jsp page; otherwise, they are redirected to the error.jsp page.

HTML Response
The servlet uses the sendRedirect() method to redirect the user to the appropriate page based on the authentication result. The success.jsp and error.jsp pages can be customized to display relevant messages or perform additional actions as needed.

## Dependencies
This project has the following dependencies:

Java Servlet API: Used for creating servlet classes and handling HTTP requests/responses.
