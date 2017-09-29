package com.dto;

import com.pojo.Task;
import com.pojo.User;

/**
 * Created by chen on 2017/9/28.
 */
public class Taskdto {
    private User taskUser;
    private User taskAssigner;
    private Task task;

    public User getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(User taskUser) {
        this.taskUser = taskUser;
    }

    public User getTaskAssigner() {
        return taskAssigner;
    }

    public void setTaskAssigner(User taskAssigner) {
        this.taskAssigner = taskAssigner;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
