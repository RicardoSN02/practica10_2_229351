package com.example.practica10_10

data class User(var firstName : String ?= null , var lastName : String ?= null,
                var age : String ?= null){

    override fun toString() = firstName + "\t" + age
}
