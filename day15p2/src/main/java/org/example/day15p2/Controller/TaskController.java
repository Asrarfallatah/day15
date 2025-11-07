package org.example.day15p2.Controller;


import org.example.day15p2.ApiResponse.ApiResponse;
import org.example.day15p2.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {


    ArrayList <Task> tasks = new ArrayList<>();


    //get all tasks
    @GetMapping("/get")
    public  ArrayList <Task> getTasks (){
        return tasks;
    }

    // add task to the list
    @PostMapping("/add")
    public ApiResponse addTask(@RequestBody Task task){
        tasks.add(task);
        return new ApiResponse( " Task has been added Successfully ");
    }

    // edit task from list
    @PutMapping("/update/{index}")
    public ApiResponse addTask(@PathVariable int index , @RequestBody Task task){
        tasks.add(index, task);
        return new ApiResponse( " Task has been updated Successfully ");
    }

    //delete a task
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index ){
        tasks.remove(index);
        return new ApiResponse(" Task has been deleted Successfully ");
    }

    // search for a task by title
    @GetMapping("/find/{findTitle}")
    public Task getByTitle(@PathVariable String findTitle){
        for(Task task : tasks){
            if(task.getTaskTitle().equalsIgnoreCase(findTitle) ){
                return task;
            }
        }
        return null;
    }


}
