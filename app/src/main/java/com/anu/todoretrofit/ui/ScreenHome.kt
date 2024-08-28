package com.anu.todoretrofit.ui

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
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
        OutlinedTextField(value = taskFieldValue, onValueChange = { taskFieldValue = it })
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
                    Modifier.padding(10.dp)
                        .border(width = 1.dp, color = Color.Gray)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(Modifier.padding(16.dp)) {
                        var isChecked by remember {
                            mutableStateOf(false)
                        }
                        if (isChecked) {
                            Text(
                                todo.title,
                                style = TextStyle(textDecoration = TextDecoration.LineThrough)
                            )
                        } else {
                            Text(
                                todo.title
                            )
                        }
                        Checkbox(checked = isChecked, onCheckedChange = {
                            isChecked = it
                            viewModel.updateTodo(
                                TodoPost(
                                    title = todo.title,
                                    description = "desc",
                                    is_completed = it
                                ),
                                id = todo._id
                            )
                        })
                    }
                    Button(onClick = { viewModel.deleteTodo(todo._id) }) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}