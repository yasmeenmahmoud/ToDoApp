package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        todo_rec.adapter = todoAdapter
        addToDo_btn.setOnClickListener{
            var todoTitle=toDoTitle_edt.text.toString()
            if (todoTitle.isNotEmpty()){
                todoAdapter.addTodo(Todo(todoTitle))
                toDoTitle_edt.text.clear()
            }
        }
        deleteDone_btn.setOnClickListener{
            todoAdapter.deleteDoneTodos()
        }
    }

}