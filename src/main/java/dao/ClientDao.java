package dao;

import model.Client;
import util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {


    private Connection connection;

    public ClientDao() {
        connection = DbUtil.getConnection();
    }


    public void addClient(Client client) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into client(name,descripment,phonenumber) values (?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getDescripment());
            preparedStatement.setString(3, client.getPhoneNumber());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(Client client) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update client set name=?, descripment=?, phonenumber=?" +
                            "where clientid=?");
            // Parameters start with 1
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getDescripment());
            preparedStatement.setString(3, client.getPhoneNumber());
            preparedStatement.setInt(4, client.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from client ORDER BY id DESC");
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setDescripment(rs.getString("descripment"));
                client.setPhoneNumber(rs.getString("phoneNumber"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public Client getClientById(int clientId) {
        Client client = new Client();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from client where id=?");
            preparedStatement.setInt(1, clientId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {

                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setDescripment(rs.getString("descripment"));
                client.setPhoneNumber(rs.getString("phoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public Client getClientByPhoneNumber(String phonenumber) {
        Client client = new Client();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from client where phonenumber=?");
            preparedStatement.setString(1, phonenumber);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setDescripment(rs.getString("descripment"));
                client.setPhoneNumber(rs.getString("phoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public List<Client> getClientsByName(String name) {
        List<Client> clients = new ArrayList<>();
        Client client = new Client();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from client where name=?");
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setDescripment(rs.getString("descripment"));
                client.setPhoneNumber(rs.getString("phoneNumber"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }







}
