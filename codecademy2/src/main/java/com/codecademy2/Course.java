package com.codecademy2;

public class Course {
    private String courseName;
    private String courseTopic;
    private String CourseIntroText;
    private String courseTag;
    private Difficulty difficulty;
    private int moduleId;

    public Course(String courseName, int ModuleId, String courseTopic, String courseIntroText, String courseTag, Difficulty difficulty) {
        this.courseName = courseName;
        this.moduleId = ModuleId;
        this.courseTopic = courseTopic;
        CourseIntroText = courseIntroText;
        this.courseTag = courseTag;
        this.difficulty = difficulty;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTopic() {
        return courseTopic;
    }

    public void setCourseTopic(String courseTopic) {
        this.courseTopic = courseTopic;
    }

    public String getCourseIntroText() {
        return CourseIntroText;
    }

    public void setCourseIntroText(String courseIntroText) {
        CourseIntroText = courseIntroText;
    }

    public String getCourseTag() {
        return courseTag;
    }

    public void setCourseTag(String courseTag) {
        this.courseTag = courseTag;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        moduleId = moduleId;
    }

    
}
