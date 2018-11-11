// Author: Paula Ruiz
// Microsoft Student Creative Hack with Netlight
// 10/11/2018 - 11/11/2018

package com.complementary.paularuiz.complementary

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result


object DBHandler {
    val BASE = "https://complimentary.herokuapp.com"
    fun createUser(username: String, firstName: String, lastName: String,
                          email: String, birth: String, gender: Char, done: (Boolean) -> Unit) {
        Fuel.post("$BASE/users",
                listOf("username" to username, "firstName" to firstName, "lastName" to lastName,
                        "email" to email, "birth" to birth, "gender" to gender))
                .responseString { req, response, result ->q
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
}


