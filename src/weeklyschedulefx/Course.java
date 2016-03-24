/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weeklyschedulefx;

import java.util.ArrayList;


/**
 *
 * @author Roberto Alvarez
 */
public class Course {
    private ArrayList<Course> currentCourses = new ArrayList<>();
    
    private String coursePrefix;
    private String courseNumber;
    private String courseName;
    private String location;
    private String from;
    private String to;
    private int courseCode;
    private boolean[] days;
  //...

    
    public Course(String coursePrefix, String courseNumber, String courseName, String location, String from, String to, int courseCode, boolean[] days) {
        this.coursePrefix = coursePrefix;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.location = location;
        this.from = from;
        this.to = to;
        this.courseCode = courseCode;
        this.days = days;
    }


    /**
     * @return the coursePrefix
     */
    public String getCoursePrefix() {
        return coursePrefix;
    }

    /**
     * @param coursePrefix the coursePrefix to set
     */
    public void setCoursePrefix(String coursePrefix) {
        this.coursePrefix = coursePrefix;
    }

    /**
     * @return the courseNumber
     */
    public String getCourseNumber() {
        return courseNumber;
    }

    /**
     * @param courseNumber the courseNumber to set
     */
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the days
     */
    public boolean[] getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(boolean[] days) {
        this.days = days;
    }

    /**
     * @return the courseCode
     */
    public int getCourseCode() {
        return courseCode;
    }

    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }
    
}
