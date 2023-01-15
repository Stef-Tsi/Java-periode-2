package com.codecademy2;

public class Course {
    private String courseName;
    private String courseTopic;
    private String CourseIntroText;
    private String courseTag;
    private Difficulty difficulty;

    public Course(String courseName, String courseTopic, String courseIntroText, String courseTag, Difficulty difficulty) {
        this.courseName = courseName;
        this.courseTopic = courseTopic;
        CourseIntroText = courseIntroText;
        this.courseTag = courseTag;
        this.difficulty = difficulty;
    }
}
