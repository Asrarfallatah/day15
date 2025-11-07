package org.example.day15p2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String taskID;
    private String taskTitle;
    private String taskDescription;
    private boolean taskStatus;
}
