/*
 * Good Parts Engineered by Samurai.
 * Bad Parts Autogenerated by IDE
 * .
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.CategoryFacade;

/**
 *
 * @author trusty
 */
@WebServlet(name = "ControllerServelet", loadOnStartup = 1, urlPatterns = {"/category",
    "/addToCart",
    "/viewCart",
    "/updateCart",
    "/checkout",
    "/purchase",
    "/chooseLanguage"})
public class ControllerServelet extends HttpServlet {

    @EJB
    private CategoryFacade categoryFacade;

    @Override
    public void init() throws ServletException {
        //store category list in servelet context
        getServletContext().setAttribute("categories", categoryFacade.findAll());
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerServelet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerServelet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();

        //if category page is requested
        if (userPath.equals("/category")) {

        } else if (userPath.equals("/viewCart")) {
            userPath = "/cart";

        } else if (userPath.equals("/checkout")) {

        } else if (userPath.equals("/chooseLanguage")) {

        }
        String url = "/WEB-INF/view" + userPath + ".jsp";

        //use request dispatcher to forward request internally
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        if (userPath.equals("/category")) {
            //get categoryId from request
            String categoryId = request.getQueryString();
            
            //if addToCart action is called 
        } else if (userPath.equals("/addToCart")) {

            //if updateCart action is called  
        } else if (userPath.equals("/updateCart")) {

            //if purchase action is called
        } else if (userPath.equals("/purchase")) {

            userPath = "/confirmation";
        }
        String url = "/WEB-INF/view" + userPath + ".jsp";

        //use request dispatcher to forward request internally
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
