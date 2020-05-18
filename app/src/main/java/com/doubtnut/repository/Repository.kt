package com.doubtnut.repository

import androidx.lifecycle.MutableLiveData
import com.doubtnut.App
import com.doubtnut.R
import com.doubtnut.db.dao.NewsDao
import com.doubtnut.db.database.DatabaseCache
import com.doubtnut.model.Article
import com.doubtnut.network.ApiStatus.isCheckAPIStatus
import com.doubtnut.network.Const.api_key
import com.doubtnut.network.RestClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class Repository(private val restClient: RestClient) {

    private val userList = MutableLiveData<List<Article>>()
    private val errorMess = MutableLiveData<String>()
    private var job: Job? = null
    var mDao: NewsDao = DatabaseCache.getInstance().newsDao()
    init {
        loadListApi()
    }

    private fun loadListApi() {
        job=CoroutineScope(Dispatchers.IO).launch {
            try {
                restClient.webServices().getNewsListAsync(api_key).await().let {
                    if (it.isSuccessful && it.body()?.status == "ok") {
                        val result = it.body()!!.articles
                        result?.let {
                            mDao.deleteAllNews()
                            mDao.saveAndUpdate(result)
                            userList.postValue(result)
                        }

                    } else {
                        userList.postValue(mDao.getAllNews())
                        errorMess.postValue(isCheckAPIStatus(it.code(), it.errorBody()))
                    }
                }
            } catch (e: Exception) {
                userList.postValue(mDao.getAllNews())
                e.printStackTrace()
                errorMess.postValue(App.appContext?.getString(R.string.no_internet_available))
            }
        }
    }

    fun getSuggestions(): MutableLiveData<List<Article>> {
        return userList
    }

    fun getErrorMessage(): MutableLiveData<String> {
        return errorMess
    }
    fun onCleared(){
        job?.cancel()
    }
}

