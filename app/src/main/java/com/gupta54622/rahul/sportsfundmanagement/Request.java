package com.gupta54622.rahul.sportsfundmanagement;

import android.media.Image;

import java.util.Date;

public class Request {

   public Image requestLetter;
   public Status status;
   public Date date;
   public String captainRollNumber;
   public String approvedBy;
   public String rejectedBy;
   public Integer requestNumber;
   public String captainId;

}


enum Status{

    APPROVED, REJECTED, PENDING
}