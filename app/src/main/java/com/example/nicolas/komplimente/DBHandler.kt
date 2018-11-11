
package com.example.nicolas.komplimente

import android.content.Context
import android.preference.PreferenceManager
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result


object DBHandler {
    val BASE = "https://complimentary.herokuapp.com"
    fun createUser(username: String, firstName: String, lastName: String,
                          email: String, birth: String, gender: Char, done: (Boolean) -> Unit) {
        Fuel.post("$BASE/users",
                listOf("username" to username, "firstName" to firstName, "lastName" to lastName,
                        "email" to email, "birth" to birth, "gender" to gender))
                .responseString { req, response, result ->
            when (result) {
                is Result.Success -> {
                    done(true)
                }
                is Result.Failure -> {
                    println(response)
                    done(false)
                }
            }
        }
    }

    fun login(username: String, password: String, done: (String?) -> Unit) {
        Fuel.post("$BASE/login",
                listOf("username" to username))
                .responseString { _, response, result ->
                    when (result) {
                        is Result.Success -> {
                            done(response.data.contentToString())
                        }
                        is Result.Failure -> {
                            println(response)
                            done(null)
                        }
                    }
                }
    }

//    fun friends(username: String, password: String, token: String, done: (String?) -> Unit) {
//        Fuel.get("$BASE/friends")
//            .header("Token" to token)
//            .responseString { _, response, result ->
//                when (result) {
//                    is Result.Success -> {
//                        done(response.data.contentToString())
//                    }
//                    is Result.Failure -> {
//                        println(response)
//                        done(null)
//                    }
//                }
//            }
//    }

    private fun token(context: Context): String? {
        val token = PreferenceManager.getDefaultSharedPreferences(context).getString("token","")
        return if (token == "") null else token
    }
}


