package model;

public class Client {

    private int id;
    private String name;
    private String descripment;
    private String phoneNumber;

    public Client(){}
    public Client(int id,String name,String descripment,String phoneNumber)
    {
        this.id=id;
        this.name=name;
        this.descripment=descripment;
        this.phoneNumber=phoneNumber;
    }
    public Client(String name,String descripment,String phoneNumber)
    {
        this.name=name;
        this.descripment=descripment;
        this.phoneNumber=phoneNumber;
    }

    @Override
    public String toString() {
        return getName()+" "+getDescripment()+" "+getPhoneNumber()+" "+getId();
    }
    //getter i setter
    public int getId() {return id;}
    public String getName() {return name;}
    public String getDescripment() {return descripment;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setId(int id) {this.id = id;}
//    public boolean isNew() {return (this.id == null);}
    public void setName(String name) {this.name = name;}
    public void setDescripment(String descripment) {this.descripment = descripment;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

}
