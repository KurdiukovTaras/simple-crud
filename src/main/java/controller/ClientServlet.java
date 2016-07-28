package controller;


import dao.ClientDao;


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
       String phoneNumber=req.getParameter("phoneNumber");
       req.setAttribute("client", dao.getClientByPhoneNumber(phoneNumber));
       req.getRequestDispatcher("clientList.jsp").forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("clientList", dao.getAllClients());
            request.getRequestDispatcher("clientList.jsp").forward(request, response);


    }
    private String resetParam(String param, HttpServletRequest request) {
        String value = request.getParameter(param);
        request.setAttribute(param, value);
        return value;
    }
}
