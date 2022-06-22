package com.example.demo


// Contructor default
class Test2(
    private val name: String = "Son",
    private val nickName: String = ""
) {

    private var fullName = name + nickName

    constructor(name: String, nickName: String, old: Int): this(name = name,nickName = "$nickName($old)"){
        "Name cuar Toi co ${name.length + nickName.length} ki tu"
    }
}