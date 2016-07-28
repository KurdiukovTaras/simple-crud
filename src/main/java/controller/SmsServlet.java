package controller;

import dao.ClientDao;
import dao.SmsDao;
import model.Sms;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;



public class SmsServlet extends HttpServlet {
    private SmsDao dao;
    private int clientId;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao=new SmsDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("writesms")) {
            String message=request.getParameter("message");
            final Sms sms=new Sms(clientId,new Timestamp(new Date().getTime()),message,false,false,"output sms");
            dao.addSms(sms);
            request.getRequestDispatcher("writeSms.jsp").forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action == null) {
            request.setAttribute("smsList", dao.getAllSms());
            request.getRequestDispatcher("smsList.jsp").forward(request, response);
        }
        else if(action.equals("showsmsbyid")){
            int id = getId(request);
            clientId=id;
            request.setAttribute("smsList", dao.getSmsByClientId(id));
            request.getRequestDispatcher("smsList.jsp").forward(request, response);
        }

    }

    //чтоб не повторяться, чтение параметра id из request
    private int getId(HttpServletRequest request) {
        String paramId = request.getParameter("id");
        return Integer.valueOf(paramId);
    }
}
