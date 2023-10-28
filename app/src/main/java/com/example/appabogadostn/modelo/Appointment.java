package com.example.appabogadostn.modelo;

public class Appointment {
    String LawyerId, appointmentType, appointmentName, clientName, clientID;
    int clientPhone, id;

    public Appointment() {
        this.id = 0;
        this.LawyerId = "";
        this.appointmentType = "";
        this.appointmentName = "";
        this.clientName = "";
        this.clientID = "";
        this.clientPhone = 0;
    }

    public Appointment(int id, String lawyerId, String appointmentType, String appointmentName, String clientName, String clientID, int clientPhone) {
        this.id = id;
        this.LawyerId = lawyerId;
        this.appointmentType = appointmentType;
        this.appointmentName = appointmentName;
        this.clientName = clientName;
        this.clientID = clientID;
        this.clientPhone = clientPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLawyerId() {
        return LawyerId;
    }

    public void setLawyerId(String lawyerId) {
        LawyerId = lawyerId;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public int getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(int clientPhone) {
        this.clientPhone = clientPhone;
    }

    @Override
    public String toString() {
        return  "id = " + id + '\'' +
                "Appointment{" +
                "LawyerId='" + LawyerId + '\'' +
                ", appointmentType='" + appointmentType + '\'' +
                ", appointmentName='" + appointmentName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientID='" + clientID + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                '}';
    }

}
