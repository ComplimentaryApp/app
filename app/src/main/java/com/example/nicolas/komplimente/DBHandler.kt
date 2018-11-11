
package com.example.nicolas.komplimente

import android.content.Context
import android.preference.PreferenceManager
import com.beust.klaxon.Klaxon
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
                            done(String(response.data))
                        }
                        is Result.Failure -> {
                            println(response)
                            done(null)
                        }
                    }
                }
    }

    fun friends(token: String, done: (List<Friend>?) -> Unit) {
        println("TOKEN: $token")
        Fuel.get("$BASE/friends")
            .header("Token" to token)
            .responseString { _, response, result ->
                println("HERE")
                when (result) {
                    is Result.Success -> {
                        done(Klaxon().parseArray<Friend>(String(response.data)))
                    }
                    is Result.Failure -> {
                        println(response)
                        done(null)
                    }
                }
            }
    }
    fun sendCompliment(token: String, subject: String, body: String, done: () -> Unit) {
        println("TOKEN: $token")
        Fuel.post("$BASE/compliments",
            listOf("subject" to subject, "body" to body))
            .header("Token" to token)
            .responseString { _, response, result ->
                done()
            }
    }
    fun getCompliments(token: String, done: (List<ComplimentMessage>?) -> Unit) {
        Fuel.get("$BASE/compliments")
            .header("Token" to token)
            .responseString { _, response, result ->
                println("HERE")
                when (result) {
                    is Result.Success -> {
                        done(Klaxon().parseArray<ComplimentMessage>(String(response.data)))
                    }
                    is Result.Failure -> {
                        println(response)
                        done(null)
                    }
                }
            }
    }

    fun token(context: Context): String? {
        val token = PreferenceManager.getDefaultSharedPreferences(context).getString("token","")
        return if (token == "") null else token
    }
}

data class Friend(val id: String, val first: String, val last: String)
data class ComplimentMessage(val subject: String?, val body: String, val liked: Boolean)