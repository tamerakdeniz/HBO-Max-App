package com.example.hbomaxapp

import java.io.Serializable

data class Movies (var id: Int,
                   var name: String,
                   var image: String,
                   var desc: String,
                   var cat: String) : Serializable {

}