package com.anu.todoretrofit.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anu.todoretrofit.model.Todo

@Composable
fun ScreenHome(todoUiState: AppUiState, innerPadding: PaddingValues, viewModel: TodoViewModel) {
    val todoList = todoUiState.todoList
    Column(modifier = Modifier.padding(innerPadding)) {
        var taskFieldValue by remember {
            mutableStateOf("")
        }
        OutlinedTextField(value = taskFieldValue, onValueChange = {taskFieldValue = it})
        Button(onClick = {
            val todo = Todo(title = taskFieldValue, completed = false, id = 123123, userId = 1)
            viewModel.createTodo(todo)
        }) {
            Text(text = "Add")
        }
        LazyColumn(
            modifier = Modifier
        ) {
            items(
                items = todoList
            ) { todo ->
                Log.i("todo todo", todo.toString())
                Row {
                    Text(todo.title)
                    Text(todo.completed.toString())
                }
            }
        }
    }
}