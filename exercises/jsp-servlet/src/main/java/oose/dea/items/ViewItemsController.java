package oose.dea.items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by alexanderstenkoning on 28/03/17.
 */
@WebServlet(urlPatterns = {"/viewItems"}, name="lijstje van items")
public class ViewItemsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ItemService is = new ItemService();
//        PrintWriter pw = resp.getWriter();
//        pw.print("<ul>");
//        for(Item item : is.findAll()){
//            pw.printf("<li>%s %s</li>", item.getSku(), item.getTitle());
//        }
//        pw.print("</ul>");
        req.setAttribute("all", is.findAll());
        req.getRequestDispatcher("viewItems.jsp").forward(req, resp);
    }
}
