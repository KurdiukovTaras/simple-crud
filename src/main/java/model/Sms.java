package model;

import java.sql.Timestamp;

public class Sms
{
    private Client client;
    private int clientId;
    private int id;
    private Timestamp datetime;
    private String message;
    private Boolean readed;
    private Boolean in_out;
    private String port;

    public Sms(){}
    public Sms(Timestamp datetime,String message,boolean readed, boolean in_out, String port)
    {
        this.datetime=datetime;
        this.message=message;
        this.readed=readed;
        this.in_out=in_out;
        this.port=port;
    }

    //Геттеры и сеттеры




//    public boolean isNew() {return (this.id == null);}
    public void setId(Integer id) {this.id = id;}
    public int getId() {return id;}
    public void setDatetime(Timestamp datetime) {this.datetime = datetime;}
    public Timestamp getDatetime() {return datetime;}
    public void setMessage(String message) {this.message = message;}
    public String getMessage() {return message;}
    public void setReaded(Boolean readed) {this.readed = readed;}
    public Boolean getReaded() {return readed;}
    public int getClientId() {return clientId;}
    public void setClientId(int clientId) {this.clientId = clientId;}
    public Client getClient() {return client;}
    public void setClient(Client client) {this.client = client;}
    public Boolean getIn_out() {return in_out;}
    public void setIn_out(Boolean in_out) {this.in_out = in_out;}
    public String getPort() {return port;}
    public void setPort(String port) {this.port = port;}

}
