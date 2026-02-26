package com.CRUD_Application.Dto;

//Response structure should be like this
//status message
//status code
//data

//get is basically used to get or fetch the data from the server
//set is basically used to set the value of the data and are used while sending the postrequest to the server throught the api.
public class ResponseStructure<T> {
    private int statuscode;
    private String statusmessage;
    private T data;
    public int getStatusCode(){return statuscode;}
    public void setStatusCode(int statuscode){
        this.statuscode = statuscode;
    }
    public String getStatusmessage(){
        return statusmessage;
    }
    public void setStatusmessage(String statusmessage){
        this.statusmessage = statusmessage;
    }

    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }
}
