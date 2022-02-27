package controler;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BoomServlet", value = "/BoomServlet")
public class BoomServlet extends HttpServlet {
    private Bomen bomen = new Bomen();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String soortParam = request.getParameter("soort boom");
        String familieParam = request.getParameter("familie boom");
        int aantalParam = Integer.parseInt(request.getParameter("aantal"));

        Boom boom = new Boom(soortParam, familieParam, aantalParam);
        bomen.add(boom);
        String result = bomen.bomenToString();

        request.setAttribute("result", result);
        RequestDispatcher view = request.getRequestDispatcher("/overzicht.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
