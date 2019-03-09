package com.example.springbootweb.springbootfirstwebapp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Todo {
//    @Min(value = 1, message = "Id can't be less than 1 or bigger than 999")
//    @Max(999)
    private int id;

    @Size(min=5, message="Enter at least 5 characters...")
    private String user;

    @Size(min=5, message="Enter at least 5 characters...")
    private String desc;

    @NotNull
    private Date targetDate;

    @NotNull
    private boolean isDone;

    public Todo() {}

    @JsonCreator
    public Todo(@JsonProperty("id") int id,
                @JsonProperty("user") String user,
                @JsonProperty("desc") String desc,
                @JsonProperty("targetDate") Date targetDate,
                @JsonProperty("isDone") boolean isDone) {
        super();
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.targetDate = targetDate;
        this.isDone = isDone;
//        this.getClass().newInstance(); // new Todo();
//        this.getClass().getDeclaredConstructors().
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Todo other = (Todo) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo [id=%s, user=%s, desc=%s, targetDate=%s, isDone=%s]", id,
                user, desc, targetDate, isDone);
    }

}