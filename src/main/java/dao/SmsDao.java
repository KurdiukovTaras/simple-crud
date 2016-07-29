package dao;

import model.Client;
import model.Sms;
import util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SmsDao {

    ClientDao clientDao=new ClientDao();
    private Connection connection;

    public SmsDao() {
        connection = DbUtil.getConnection();
    }

    public void addSms(Sms sms,int clientId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into sms(message,readed,in_out,date_time,port,client_id) values (?, ?, ?, ?,?,? )");
            // Parameters start with 1
            preparedStatement.setString(1, sms.getMessage());
            preparedStatement.setBoolean(2, sms.getReaded());
            preparedStatement.setBoolean(3, sms.getIn_out());
            preparedStatement.setTimestamp(4, sms.getDatetime());
            preparedStatement.setString(5, sms.getPort());
            preparedStatement.setInt(6, clientId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Sms> getAllSms() {
        List<Sms> smses = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from sms ORDER BY date_time DESC");
            while (rs.next()) {
                Sms sms = new Sms();
                sms.setClientId(rs.getInt("client_id"));
                sms.setMessage(rs.getString("message"));
                sms.setReaded(rs.getBoolean("readed"));
                sms.setIn_out(rs.getBoolean("in_out"));
                sms.setDatetime(rs.getTimestamp("date_time"));
                smses.add(sms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return smses;
    }

    public List<Sms> getSmsByClientId(int clientId) {
        List<Sms> smses = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from sms where client_id=?");
            preparedStatement.setInt(1, clientId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Sms sms = new Sms();
                sms.setClientId(rs.getInt("client_id"));
                sms.setMessage(rs.getString("message"));
                sms.setReaded(rs.getBoolean("readed"));
                sms.setIn_out(rs.getBoolean("in_out"));
                sms.setDatetime(rs.getTimestamp("date_time"));
                smses.add(sms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return smses;
    }
    public Client getClientByPhoneNumber(String phonenumber){
        return clientDao.getClientByPhoneNumber(phonenumber);
    }

}


