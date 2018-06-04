package com.dimkafpm.architecture.domain.model

class Country(val name: String,
              val nativeName: String,
              val region: String,
              val capital: String,
              val currencies: List<String>,
              val languages: List<String>,
              val population: Int)