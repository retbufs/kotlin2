package com.example.kotlinmvp.bean

import java.io.Serializable

class Category<T> : Serializable {
    var category: List<String>? = null
    var error: String? = null
    var results: T? = null

    constructor() {}
    constructor(category: List<String>, error: String, results: T) {
        this.category = category
        this.error = error
        this.results = results
    }
}
