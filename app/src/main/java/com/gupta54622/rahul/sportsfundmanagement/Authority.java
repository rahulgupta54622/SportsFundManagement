package com.gupta54622.rahul.sportsfundmanagement;

import java.util.List;

public class Authority {

    // All data member should be public to use in firebase
    public String authorityId;
    public String userName;
    public String password;
    public String email;
    public String mobileNumber;

    List<Request> requestList;
    List<Complain> complainList;

    public Authority() {
    }

    public Authority(String authorityId, String userName, String password, String email, String mobileNumber, List<Request> requestList, List<Complain> complainList) {
        this.authorityId = authorityId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }


    boolean approveRequest(Request request, String authorityName){

        // Update the satus of coming request
        updateStatus(Status.APPROVED, request);
        request.approvedBy = authorityName;

        return true;
    }

    private void updateStatus(Status status, Request request) {



    }
}
