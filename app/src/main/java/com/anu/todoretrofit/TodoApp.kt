package com.anu.todoretrofit

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.anu.todoretrofit.ui.ScreenHome
import com.anu.todoretrofit.ui.TodoViewModel

@Composable
fun TodoApp(innerPadding: PaddingValues) {
    val todoViewModel = TodoViewModel()
    Log.i("todoapp", "hi")
    ScreenHome(todoUiState = todoViewModel.uiState, innerPadding = innerPadding, viewModel = todoViewModel)
}