package controler;

import model.BomenDB;
import model.Boom;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        String command = "index";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }
        switch (command) {
            case "index":
                HttpSession session = request.getSession();
                if (session.getAttribute("zoektermen") == null){
                    List<String> zoektermen = new ArrayList<String>();
                    zoektermen.add("U zocht nog niet op");
                    session.setAttribute("zoektermen", zoektermen);
                }

                request.setAttribute("meesteBomen", bomen.meesteBomen());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case "voegToe":
                request.getRequestDispatcher("voegToe.jsp").forward(request, response);
                break;

            case "overzicht":
                request.setAttribute("bomen", bomen.getBomen());
                request.setAttribute("meesteBomen", bomen.meesteBomen());
                request.getRequestDispatcher("overzicht.jsp").forward(request, response);
                break;

            case "zoek":
                if (getCookieWithKey(request, "aantalZoekopdrachten") == null){
                    response.addCookie(new Cookie("aantalZoekopdrachten", "0"));
                }
                Cookie cookie = getCookieWithKey(request, "aantalZoekopdrachten");
                int aantalZoekopdrachten = Integer.parseInt(cookie.getValue());
                response.addCookie(new Cookie("aantalZoekopdrachten", Integer.toString(aantalZoekopdrachten)));
                request.getRequestDispatcher("zoek.jsp").forward(request, response);
                break;

            case "formVoegToe":
                try {
                    String soortParam = request.getParameter("soort boom");
                    String familieParam = request.getParameter("familie boom");
                    int aantalParam = Integer.parseInt(request.getParameter("aantal"));

                    Boom boom = new Boom(soortParam, familieParam, aantalParam);
                    bomen.add(boom);
                } catch (Exception e) {
                    request.setAttribute("foutmelding", e.getMessage());
                    RequestDispatcher view = request.getRequestDispatcher("voegToe.jsp");
                    view.forward(request, response);
                }
                request.setAttribute("bomen", bomen.getBomen());
                request.setAttribute("meesteBomen", bomen.meesteBomen());
                RequestDispatcher view = request.getRequestDispatcher("overzicht.jsp");
                view.forward(request, response);
                break;

            case "zoekBoom":
                String zoekSoort = request.getParameter("zoek");
                session = request.getSession();
                List<String> zoektermen = (ArrayList)session.getAttribute("zoektermen");
                if (Objects.equals(zoektermen.get(0), "U zocht nog niet op")) {
                    zoektermen.set(0, zoekSoort);
                }
                else zoektermen.add(zoekSoort);
                session.setAttribute("zoektermen", zoektermen);

                ArrayList gevondenSoort = bomen.zoekSoortBomen(zoekSoort);
                String soortInLijst = "Er zijn geen bomen met deze soortnaam in de lijst";
                if (!gevondenSoort.isEmpty()){
                    cookie = getCookieWithKey(request, "aantalZoekopdrachten");
                    aantalZoekopdrachten = Integer.parseInt(cookie.getValue());
                    aantalZoekopdrachten++;
                    cookie.setValue(String.valueOf(aantalZoekopdrachten));
                    response.addCookie(cookie);
                    soortInLijst = "We hebben bomen met deze soortnaam gevonden <a href=\"BoomServlet?command=bekijkSoort\">bekijk</a>";
                }
                request.setAttribute("gevondenSoort", soortInLijst);
                String zoekFamilie = request.getParameter("zoek");
                ArrayList gevondenFamilie = bomen.zoekFamilieBomen(zoekFamilie);
                String familieInLijst = "Er zijn geen bomen met deze familienaam in de lijst";
                if (!gevondenFamilie.isEmpty()){
                    cookie = getCookieWithKey(request, "aantalZoekopdrachten");
                    aantalZoekopdrachten = Integer.parseInt(cookie.getValue());
                    aantalZoekopdrachten++;
                    cookie.setValue(String.valueOf(aantalZoekopdrachten));
                    response.addCookie(cookie);
                    familieInLijst = "We hebben bomen met deze familienaam gevonden <a href=\"BoomServlet?command=bekijkFamilie\">bekijk</a>";
                }
                request.setAttribute("gevondenFamilie", familieInLijst);
                request.getRequestDispatcher("zoekConfirmatie.jsp").forward(request, response);
                break;

            case "reset":
                cookie = getCookieWithKey(request, "aantalZoekopdrachten");
                cookie.setValue("0");
                response.addCookie(cookie);
                request.getRequestDispatcher("zoek.jsp").forward(request, response);
                break;

            case "bekijkSoort":
                request.setAttribute("bekijkSoort", bomen.getSoortBomen());
                request.getRequestDispatcher("bekijkSoort.jsp").forward(request, response);
                break;

            case "bekijkFamilie":
                request.setAttribute("bekijkFamilie", bomen.getFamilieBomen());
                request.getRequestDispatcher("bekijkFamilie.jsp").forward(request, response);
                break;

            case "verwijderbevestiging":
                request.setAttribute("boom", bomen.getBoom(Integer.parseInt(request.getParameter("verwijderID"))));
                request.getRequestDispatcher("verwijderbevestiging.jsp").forward(request, response);
                break;

            case "verwijder":
                bomen.verwijderBoom(Integer.parseInt(request.getParameter("ID")));
                request.setAttribute("bomen", bomen.getBomen());
                request.setAttribute("meesteBomen", bomen.meesteBomen());
                request.getRequestDispatcher("overzicht.jsp").forward(request, response);
                break;

            case "pasAan":
                request.setAttribute("boom", bomen.getBoom(Integer.parseInt(request.getParameter("ID"))));
                request.getRequestDispatcher("pasAan.jsp").forward(request, response);
                break;

            case "formPasAan":
                Boom boomPasAan = bomen.getBoom(Integer.parseInt(request.getParameter("ID")));
                boomPasAan.setSoortnaam(request.getParameter("soort boom"));
                boomPasAan.setFamilienaam(request.getParameter("familie boom"));
                boomPasAan.setAantal(Integer.parseInt(request.getParameter("aantal")));
                request.setAttribute("bomen", bomen.getBomen());
                request.setAttribute("meesteBomen", bomen.meesteBomen());
                request.getRequestDispatcher("overzicht.jsp").forward(request, response);
                break;

            default:
                session = request.getSession();
                if (session.getAttribute("zoektermen") == null){
                    zoektermen = new ArrayList<String>();
                    zoektermen.add("U zocht nog niet op");
                    session.setAttribute("zoektermen", zoektermen);
                }

                request.setAttribute("meesteBomen", bomen.meesteBomen());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
        }
    }
    private Cookie getCookieWithKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(key))
                return cookie;
        }
        return null;
    }
}
