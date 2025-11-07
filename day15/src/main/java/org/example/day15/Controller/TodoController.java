package org.example.day15.Controller;

import org.example.day15.Api.ApiResponse;
import org.example.day15.Model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {


    ArrayList<Todo> todos = new ArrayList<>();

    // it is an important concept you need to understand it : crud : create (get), request (post), update (put) , delete (delete)
    //                                                 Also : APIs
    // create
    @GetMapping("/get")
    public ArrayList<Todo> getTodos() {
        return todos;
    }

    //request
    @PostMapping("/add")
    public ApiResponse addTodo(@RequestBody Todo todo){
        todos.add(todo);
        return new ApiResponse("todo Added Successfully");
    }

    //updadte
    @PutMapping("/update/{index}")
    public ApiResponse updateTodo(@PathVariable int index, @RequestBody Todo todo){
        todos.set(index, todo);
        return new ApiResponse("todo updated Successfully");
    }

    //delete
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTodo(@PathVariable int index){
        todos.remove(index);
        return new ApiResponse("todo deleted Successfully");
    }

    // search the array by title
    @GetMapping("/find/{titlegeted}")
    public Todo getTodoByTitle(@PathVariable String titlegeted ){
        for (Todo todo : todos) {
           if (todo.getTitle().equalsIgnoreCase(titlegeted)){
               return todo;
           }
        }
        return null;
    }


}
