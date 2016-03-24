/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weeklyschedulefx;

import java.util.Hashtable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author Roberto Alvarez
 */
public class ScheduleGenerator {
 

    // Course Info
    Course[] currentCourses;
    int timeIncrment;

    // data structure for times
    int[][] weeklySlots;

    // Calendar
    Calendar calendar;

    WeeklyScheduleFX weekly;
    StackPane[] printWiik;
    
    //Hash tables to retrieve each course information from its code
    Hashtable codeToPrefix   = new Hashtable();
    Hashtable codeToNumber   = new Hashtable();
    Hashtable codeToLocation = new Hashtable();



    // Get courses for user
    public void getCoursesFromUser() {
        // fill the Course Array Course[] with data
        currentCourses    = new Course[4];
        currentCourses[0] = new Course("CSCI", "2333", "Asembly Language", "LHSB 1.420", "3:05 PM", "4:20 PM", 1, new boolean[]{true, false, true, false, false});
        currentCourses[1] = new Course("CSCI", "3340", "Software Engineering", "MAIN 1.514", "10:50 AM", "12:05 PM", 2, new boolean[]{false, true, false, true, false});
        currentCourses[2] = new Course("CSCI", "6368", "Computer Vision", "LHSB 2.312", "5:55 PM", "8:25 PM", 3, new boolean[]{false, false, true, false, false});
        currentCourses[3] = new Course("CSCI", "4310", "Computer Architecture", "LHSB 2.312", "08:00 AM", "9:25 AM", 4, new boolean[]{true, false, true, false, false});
    }

    // Get Time Intervals
    public int getTimeIncrmentFromUser() {
        // get the timeIncrment for hour from user; harded coded at 15 for now!
        return 15;
    }

    // This part is working! I implemented it for you
    public void generateTimeTicks() {
        timeIncrment = getTimeIncrmentFromUser();
        calendar = new Calendar(timeIncrment); // works for increments from 0-60
    }

    // Generate the Schedule
    public void generateSchedule() {
        // get all inputs
        generateTimeTicks();
        getCoursesFromUser();

        // Format the data and do firther processing!
        // For now only the time intervals show up!
        generateCourseTimes();

        //printweekDays(calendar.getWeekDays(), gPane, rWidth, rHeigth);
        String[] timeIntervals = calendar.getTimeTicksStrings();
        String prefix,number,location;
        for (int i = 0; i < weeklySlots.length; i++) {
            System.out.format("%-12s", timeIntervals[i]);
            for (int j = 0; j < weeklySlots[0].length; j++) {
                if (weeklySlots[i][j] == -1) {
                    System.out.format("%-20s", "");
                } 
                else 
                {
                    prefix= (String) codeToPrefix.get(Integer.toString(weeklySlots[i][j]));
                    number= (String) codeToNumber.get(Integer.toString(weeklySlots[i][j]));
                    location= (String) codeToLocation.get(Integer.toString(weeklySlots[i][j]));
                    System.out.format("%-20s", prefix+"-"+number+" "+location);
                }
            }
            System.out.format("%n");
        }
        courseDescription(currentCourses);
    }

    public void generateCourseTimes() {
        weeklySlots = new int[calendar.getTimeTicksStrings().length][5];
        for (int i = 0; i < weeklySlots.length; i++) {
            for (int j = 0; j < weeklySlots[0].length; j++) {
                weeklySlots[i][j] = -1;
            }
        }

        int reference = calendar.getTime_from();
        int time_increments = calendar.getTimeIncrement(); //  15 minutes
        
        int no_time_increments;
        
        if (calendar.getTimeIncrement() !=0)
            no_time_increments = 60 / calendar.getTimeIncrement(); // 4 for for the 15 minutes
        else
            no_time_increments=1;
        
        int from_index, to_index;
        int hourFrom, subHoursFrom, hourTo, subHoursTo;

        //.... go over each course and find the spots to cross with their code.
        String[] splitFrom;
        String[] splitTo;
        String AM_PM;
        int courseCode;
        
        // Clear the hash
        codeToPrefix.clear();
        codeToNumber.clear();
        codeToLocation.clear();
        
        for (int k = 0; k < currentCourses.length; k++) {
            //Generate hashtable
            codeToPrefix.put(Integer.toString(currentCourses[k].getCourseCode()), currentCourses[k].getCoursePrefix());
            codeToNumber.put(Integer.toString(currentCourses[k].getCourseCode()), currentCourses[k].getCourseNumber());
            codeToLocation.put(Integer.toString(currentCourses[k].getCourseCode()), currentCourses[k].getLocation());

            splitFrom = currentCourses[k].getFrom().split("[\\s|:]");

            hourFrom = Integer.parseInt(splitFrom[0]);
            subHoursFrom = Integer.parseInt(splitFrom[1]);
            AM_PM = splitFrom[2].toUpperCase();
            if (AM_PM.equals("PM") && hourFrom != 12) {
                hourFrom += 12;
            }

            splitTo = currentCourses[k].getTo().split("[\\s|:]");

            hourTo = Integer.parseInt(splitTo[0]);
            subHoursTo = Integer.parseInt(splitTo[1]);
            AM_PM = splitTo[2].toUpperCase();
            if (AM_PM.equals("PM") && hourTo != 12) {
                hourTo += 12;
            }

            courseCode = currentCourses[k].getCourseCode();
            from_index = (hourFrom - reference) * no_time_increments;
            if(time_increments !=0)
                to_index = (hourTo - reference) * no_time_increments + subHoursTo / time_increments;
            else
                to_index = (hourTo - reference) * no_time_increments; 
            
            boolean[] courseDays = currentCourses[k].getDays();

            for (int i = from_index; i <= to_index; i++) {
                for (int j = 0; j < weeklySlots[0].length; j++) {
                    
                    if (courseDays[j] == true) {
                        weeklySlots[i][j] = courseCode;
                    }
                }
            }
        }
    }

    public StackPane[] printweekDays(String[] weekDays, GridPane gPane, int rWidth, int rHeigth) {
        System.out.format("%-12s", "");
        
        printWiik = new StackPane[weekDays.length];
        
        for (int i = 0; i < weekDays.length; i++) {
            for (int j = 3; j < 8; j++) {
                Rectangle Week = new Rectangle(0, 0, rWidth, rHeigth);
                Week.setStroke(Color.ANTIQUEWHITE);
                Week.setFill(Color.MEDIUMSEAGREEN);
                Text timeText = new Text(weekDays[i]);
                
                printWiik[i] = new StackPane();
                printWiik[i].setPrefHeight(rHeigth);
                printWiik[i].setMaxHeight(rHeigth);
                printWiik[i].setMinHeight(rHeigth);
                printWiik[i].getChildren().addAll(Week, timeText);
                gPane.setRowIndex(printWiik[i], i);
                gPane.setColumnIndex(printWiik[i], j);
                gPane.getChildren().add(printWiik[i]);
            
        }
            System.out.format("%-20s", weekDays[i]);
        }
        return printWiik;
    }

    public void courseDescription(Course[] currentCourses) {
        System.out.println("------------------------------------------------------------------------------------------------------------");;
        for (int i = 0; i < currentCourses.length; i++) {
            System.out.println("Course: " + currentCourses[i].getCoursePrefix() + " " + currentCourses[i].getCourseNumber() + " " + currentCourses[i].getCourseName());
        }
    }
}
