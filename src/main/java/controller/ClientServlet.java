package controller;


import dao.ClientDao;
import model.Client;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ClientServlet extends HttpServlet {

    private ClientDao dao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao=new ClientDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("searchClient")) {
            String phoneNumber=req.getParameter("phoneNumber");
            req.setAttribute("client", dao.getClientByPhoneNumber(phoneNumber));
            req.getRequestDispatcher("clientList.jsp").forward(req, resp);
        }
        else if (action.equals("update")){
            final Client client= new Client(getId(req),
                    req.getParameter("name"),
                    req.getParameter("descripment"),
                    req.getParameter("phonenumber")
                    );
            dao.updateClient(client);
            resp.sendRedirect("sms");
        }


    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("updateclientbyid")) {
            int id=getId(request);
            final Client client= dao.getClientById(id);
            request.setAttribute("client",client);
            request.getRequestDispatcher("updateClient.jsp").forward(request,response);
        }
        else if (action.equals("getAll")) {
            request.setAttribute("clientList", dao.getAllClients());
            request.getRequestDispatcher("clientList.jsp").forward(request, response);
        }

    }
    private String resetParam(String param, HttpServletRequest request) {
        String value = request.getParameter(param);
        request.setAttribute(param, value);
        return value;
    }
    private int getId(HttpServletRequest request) {
        String paramId = request.getParameter("id");
        return Integer.valueOf(paramId);
    }
}
