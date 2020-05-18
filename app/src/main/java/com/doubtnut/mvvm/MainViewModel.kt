package com.doubtnut.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.doubtnut.model.Article
import com.doubtnut.repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {

    fun getNewsData(): MutableLiveData<List<Article>> {
        return repository.getSuggestions()
    }
    fun getErrorMessage(): MutableLiveData<String> {
        return repository.getErrorMessage()
    }

    override fun onCleared() {
        repository.onCleared()
        super.onCleared()
    }
}
