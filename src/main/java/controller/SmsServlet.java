package controller;

import dao.SmsDao;
import model.Client;
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
        //создание исходящей СМСки (пока без отправки), сохранение в БД.
        if(action.equals("writesms")) {
            String message=request.getParameter("message");
            final Sms sms=new Sms(new Timestamp(new Date().getTime()),message,false,false,"output sms");
            dao.addSms(sms,clientId);
            request.getRequestDispatcher("writeSms.jsp").forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action == null) {
            //GSM шлюз отправляет СМСку так : http://127.0.0.1:8088/sms?phonenumber=XXX&port=XXX&message=XXX&time=XXX
            //Ловим СМС:
            String time=request.getParameter("time"); //перевод полученной Строки в Строку понятную для таймштамп
            char[] chars = time.toCharArray();
            chars[10] = ' ';
            time=new String(chars);
            Timestamp t=Timestamp.valueOf(time);
            //Получение номера, добавление к строке '+'
            String phonenumber=request.getParameter("phonenumber");
            char[] chars2 = phonenumber.toCharArray();
            chars2[0] = '+';
            phonenumber=new String(chars2);
            //создание клиента если номера телефона нет в базе данных. Если есть - вытягиваем его.
            final Client client=dao.getClientByPhoneNumber(phonenumber);
            //создание входящей СМСки с полученными параметрами.
            final Sms sms=new Sms(
                  t,
                  request.getParameter("message"),
                  true,
                  true,
                  request.getParameter("port")
            );
        dao.addSms(sms,client.getId());
        }
        else if(action.equals("showsmsbyid")){
            int id = getId(request);
            clientId=id;
            request.setAttribute("smsList", dao.getSmsByClientId(id));
            request.getRequestDispatcher("smsList.jsp").forward(request, response);
        }
        else if(action.equals("getAll")){
            request.setAttribute("smsList", dao.getAllSms());
            request.getRequestDispatcher("smsList.jsp").forward(request, response);
        }
    }

    //чтоб не повторяться, чтение параметра id из request
    private int getId(HttpServletRequest request) {
        String paramId = request.getParameter("id");
        return Integer.valueOf(paramId);
    }
}
