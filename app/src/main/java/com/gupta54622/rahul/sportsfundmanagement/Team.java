package com.gupta54622.rahul.sportsfundmanagement;

import java.util.List;

public class Team {

    public String teamName;
    public String captainName;
    public String viceCaptainName;
    public String coachName;
    public List<Request> requestList;
    public List<Complain> complainList;


    Team(){

    }

    public Team(String teamName, String captainName, String viceCaptainName, String coachName, List<Request> requestList, List<Complain> complainList) {
        this.teamName = teamName;
        this.captainName = captainName;
        this.viceCaptainName = viceCaptainName;
        this.coachName = coachName;
        this.requestList = requestList;
        this.complainList = complainList;
    }
}
