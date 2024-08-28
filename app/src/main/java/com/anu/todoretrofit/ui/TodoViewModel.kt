package com.anu.todoretrofit.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anu.todoretrofit.model.Todo
import com.anu.todoretrofit.model.TodoPost
import com.anu.todoretrofit.network.RetrofitInstance
import kotlinx.coroutines.launch

data class AppUiState(
    val todoList: List<Todo>
)

class TodoViewModel : ViewModel() {
    var uiState: AppUiState by mutableStateOf(AppUiState(todoList = emptyList()))
        private set

    init {
        getTodoList()
    }

    private fun getTodoList() {
        viewModelScope.launch {
            Log.i("list result", "list result")
            try {
                val listResult = RetrofitInstance.api.getTodos()
                uiState = AppUiState(todoList = listResult.items)
            } catch (e: Exception) {
                Log.i("error aayo", "error aayo")
                uiState = AppUiState(todoList = emptyList())
            }
        }
    }

    fun createTodo(todo: TodoPost) {
        viewModelScope.launch {
            RetrofitInstance.api.createTodo(todo)
            getTodoList()
        }
    }

    fun deleteTodo(id: String){
        viewModelScope.launch {
            RetrofitInstance.api.deleteTodo(id)
            getTodoList()
        }
    }

    fun updateTodo(todo: TodoPost, id: String){
        viewModelScope.launch {
            RetrofitInstance.api.updateTodo(id = id, todo = todo)
        }
    }
}