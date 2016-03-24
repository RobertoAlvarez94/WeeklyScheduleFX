/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weeklyschedulefx;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author Roberto Alvarez
 */
public class Calendar {
    
    private int time_from;
    private int time_to; // assume 24 hours
    
    private int timeIncrement;
    private String[] timeTicksStrings;
    private StackPane[] timeTicksString;
    
    private String[] weekDays ={"Monday", "Tuesday", "Wednesday","Thursday","Friday"}; 

    public Calendar() {
        time_from=8;  // 8 am
        time_to  =22; // 10 pm
    }
    

    public Calendar(int timeIncrement) {
        this.timeIncrement = timeIncrement;
        time_from=8;
        time_to  =22;
    }

    public Calendar(int time_from, int time_to, int timeIncrement) {
        this.time_from = time_from;
        this.time_to = time_to;
        this.timeIncrement = timeIncrement;
    }
    
    public StackPane[] generateTicks(GridPane gPane, int rHeigth, int rWidth) { 
        
        
        int offset_hour,offset_subHour;
        int no_ofTicks = time_to - time_from ; // 8 am to 10 pm would be 8 8o 22
        int sub_ticks;
        String am_pm;
        
        if (timeIncrement !=0)
           sub_ticks=(60/timeIncrement);
        else
            sub_ticks=1;
            
        int totalTicks =no_ofTicks*sub_ticks +1;
        timeTicksStrings = new String[totalTicks];
        
        for (int i = 0; i < totalTicks; i++ ) {
            offset_hour= i/(sub_ticks) + time_from;
            am_pm= (offset_hour < 12 ? "AM" : "PM");
            
            offset_hour = offset_hour %12;
            if(offset_hour==0) offset_hour=12;
            
            offset_subHour = (i%sub_ticks)*timeIncrement;
            String formatted_offset_hour    = String.format("%02d", offset_hour);
            String formatted_offset_subHour = String.format("%02d", offset_subHour);
            
            timeTicksStrings[i]=formatted_offset_hour + ":"+ formatted_offset_subHour + " "+ am_pm;
        }
        
        timeTicksString = new StackPane[timeTicksStrings.length];
        
        for (int i = 1; i < timeTicksStrings.length; i++ ) {
            for (int j = 1; j < 2; j++) {
            timeTicksString[i]= new StackPane();    
            
             //create time rectangles
                
                Rectangle timeRect = new Rectangle(0, 0, rWidth, rHeigth);
                timeRect.setStroke(Color.ANTIQUEWHITE);
                timeRect.setFill(Color.VIOLET);
                Text timeText = new Text(timeTicksStrings[i]);
                
                
                timeTicksString[i].setPrefHeight(rHeigth);
                timeTicksString[i].setMaxHeight(rHeigth);
                timeTicksString[i].setMinHeight(rHeigth);
                timeTicksString[i].getChildren().addAll(timeRect, timeText);
                gPane.setRowIndex(timeTicksString[i], i);
                gPane.setColumnIndex(timeTicksString[i], j);
                gPane.getChildren().add(timeTicksString[i]);
           
            }
       
        }
        return timeTicksString;
    }
    
    public void printTicks()
    {
        for (int i = 0; i < timeTicksStrings.length; i++ ) 
        {
            System.out.println(timeTicksStrings[i]);
        }
    }
    

    /**
     * @return the time_from
     */
    public int getTime_from() {
        return time_from;
    }

    /**
     * @param time_from the time_from to set
     */
    public void setTime_from(int time_from) {
        this.time_from = time_from;
    }

    /**
     * @return the time_to
     */
    public int getTime_to() {
        return time_to;
    }

    /**
     * @param time_to the time_to to set
     */
    public void setTime_to(int time_to) {
        this.time_to = time_to;
    }

    /**
     * @return the timeIncrement
     */
    public int getTimeIncrement() {
        return timeIncrement;
    }

    /**
     * @param timeIncrement the timeIncrement to set
     */
    public void setTimeIncrement(int timeIncrement) {
        this.timeIncrement = timeIncrement;
    }

    /**
     * @return the timeTicksStrings
     */
    public String[] getTimeTicksStrings() {
        return timeTicksStrings;
    }

    /**
     * @param timeTicksStrings the timeTicksStrings to set
     */
    public void setTimeTicksStrings(String[] timeTicksStrings) {
        this.timeTicksStrings = timeTicksStrings;
    }

    /**
     * @return the weekDays
     */
    public String[] getWeekDays() {
        return weekDays;
    }

    /**
     * @param weekDays the weekDays to set
     */
    public void setWeekDays(String[] weekDays) {
        this.weekDays = weekDays;
    }
}
