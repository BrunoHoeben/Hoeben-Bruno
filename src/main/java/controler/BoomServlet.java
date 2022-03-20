package controler;

import model.BomenDB;
import model.Boom;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BoomServlet", value = "/BoomServlet")
public class BoomServlet extends HttpServlet {
    private BomenDB bomen = new BomenDB();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String command = request.getParameter("command");
        if (null == command || command.equals("index")){
            request.setAttribute("meesteBomen", bomen.meesteBomen());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if (command.equals("voegToe")){
            request.getRequestDispatcher("voegToe.jsp").forward(request, response);
        }
        else if (command.equals("overzicht")){
            request.setAttribute("bomen", bomen.getBomen());
            request.setAttribute("meesteBomen", bomen.meesteBomen());
            request.getRequestDispatcher("overzicht.jsp").forward(request, response);
        }
        else if (command.equals("form")){
            String soortParam = request.getParameter("soort boom");
            String familieParam = request.getParameter("familie boom");
            int aantalParam = Integer.parseInt(request.getParameter("aantal"));

            Boom boom = new Boom(soortParam, familieParam, aantalParam);
            bomen.add(boom);
            ArrayList result = bomen.getBomen();
            request.setAttribute("bomen", result);
            String meesteBomen = bomen.meesteBomen();
            request.setAttribute("meesteBomen", meesteBomen);
            RequestDispatcher view = request.getRequestDispatcher("/overzicht.jsp");
            view.forward(request, response);
        }
        else throw new ServletException("jsp-file not found");
    }
}
