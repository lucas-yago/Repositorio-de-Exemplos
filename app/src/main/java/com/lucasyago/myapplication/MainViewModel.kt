package com.lucasyago.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var textWelcome = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()

    init {
        textWelcome.value = "Olá"
    }

    fun welcome(): LiveData<String> {
        return textWelcome
    }

    fun login(): LiveData<Boolean> {
        return login
    }

    fun doLogin(email: String, password: String) {
        login.value = PersonRepository().login(email, password)
    }


}