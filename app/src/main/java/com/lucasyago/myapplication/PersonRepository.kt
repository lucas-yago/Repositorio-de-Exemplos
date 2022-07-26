package com.lucasyago.myapplication

class PersonRepository {
    fun login(email: String, password: String): Boolean {
       return (email != "" && password != "")
    }

}