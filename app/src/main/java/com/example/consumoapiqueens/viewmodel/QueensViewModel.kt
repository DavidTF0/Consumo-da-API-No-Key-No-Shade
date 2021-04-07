package com.example.consumoapiqueens.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.consumoapiqueens.model.QueensItem
import com.example.consumoapiqueens.repository.RepositoryQueens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QueensViewModel : ViewModel() {

    val listMutableQueen = MutableLiveData<List<QueensItem>>()
    private val repository = RepositoryQueens()

    fun getAllQueens() = CoroutineScope(Dispatchers.IO).launch {
        repository.getAllQueensService().let {queensResponse ->
            listMutableQueen.postValue(queensResponse)
        }
    }
}