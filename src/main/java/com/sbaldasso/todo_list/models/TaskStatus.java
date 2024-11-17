package com.sbaldasso.todo_list.models;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum TaskStatus {
    UNFINISHED("unfinished"),
    IN_PROGRESS("in_progress"),
    FINISHED("finished");

    public final String name;

    TaskStatus(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
