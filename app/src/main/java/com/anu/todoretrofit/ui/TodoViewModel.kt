package com.anu.todoretrofit.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anu.todoretrofit.model.Todo
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
            try {
                val listResult = RetrofitInstance.api.getTodos()
                uiState = AppUiState(todoList = listResult)
            } catch (e: Exception) {
                uiState = AppUiState(todoList = emptyList())
            }
        }
    }

    fun createTodo(todo: Todo) {
        viewModelScope.launch {
            RetrofitInstance.api.createTodo(todo)
            getTodoList()
        }
    }
}