package com.anu.todoretrofit.ui

import android.util.Log
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anu.todoretrofit.model.Todo
import com.anu.todoretrofit.model.TodoPost

@Composable
fun ScreenHome(innerPadding: PaddingValues, viewModel: TodoViewModel) {
    val todoList = viewModel.uiState.todoList
    Log.i("Todo List", todoList.toString())
    Column(modifier = Modifier.padding(innerPadding)) {
        var taskFieldValue by remember {
            mutableStateOf("")
        }
        OutlinedTextField(value = taskFieldValue, onValueChange = {taskFieldValue = it})
        Button(onClick = {
            val todo = TodoPost(title = taskFieldValue, description = "Hi", is_completed = false)
            viewModel.createTodo(todo)
            taskFieldValue = ""
        }) {
            Text(text = "Add", maxLines = 1)
        }
        LazyColumn(
            modifier = Modifier
        ) {
            items(
                items = todoList
            ) { todo ->
                Log.i("todo todo", todo.toString())
                Row(
                    Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Row(Modifier.padding(16.dp)){
                        Text(todo.title)
                        Checkbox(checked = todo.is_completed, onCheckedChange = null)
                    }
                    Button(onClick = { viewModel.deleteTodo(todo._id) }) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}