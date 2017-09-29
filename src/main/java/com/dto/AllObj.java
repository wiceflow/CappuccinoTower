package com.dto;

import com.pojo.*;

/**
 * Created by chen on 2017/9/27.
 */


public class AllObj {
    private Comment comment;
    private Discus discus;
    private File file;
    private Folder folder;
    private Groupofteam groupofteam;
    private Project project;
    private Task task;
    private Taskinfo taskinfo;
    private Team team;
    private Weekly weekly;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Discus getDiscus() {
        return discus;
    }

    public void setDiscus(Discus discus) {
        this.discus = discus;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public Groupofteam getGroupofteam() {
        return groupofteam;
    }

    public void setGroupofteam(Groupofteam groupofteam) {
        this.groupofteam = groupofteam;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Taskinfo getTaskinfo() {
        return taskinfo;
    }

    public void setTaskinfo(Taskinfo taskinfo) {
        this.taskinfo = taskinfo;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Weekly getWeekly() {
        return weekly;
    }

    public void setWeekly(Weekly weekly) {
        this.weekly = weekly;
    }
}
