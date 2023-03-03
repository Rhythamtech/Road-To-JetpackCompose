package com.example.lazycolumncompose.repository

import com.example.lazycolumncompose.model.Person

class PersonRepository {

    fun getAllData(): List<Person> {
        return listOf(
            Person(
                id = 0,
                firstName = "Rhytham",
                lastName = "Negi",
                age = 23
            ),
            Person(
                id = 1,
                firstName = "Paramjeet",
                lastName = "Singh",
                age = 24
            ),
            Person(
                id = 2,
                firstName = "Aman",
                lastName = "Rawat",
                age = 22
            ),
            Person(
                id = 3,
                firstName = "Vikas",
                lastName = "Charturvedi",
                age = 30
            ),
            Person(
                id = 4,
                firstName = "Vansh",
                lastName = "Charturvedi",
                age = 31
            ),
            Person(
                id = 5,
                firstName = "Vinay",
                lastName = "Kumar",
                age = 37
            ),
            Person(
                id = 6,
                firstName = "Sanjay",
                lastName = "Bhist",
                age = 30
            ),
            Person(
                id = 7,
                firstName = "Sanjay",
                lastName = "Singh",
                age = 30
            ),
            Person(
                id = 8,
                firstName = "Vijay",
                lastName = "Jha",
                age = 30
            ),

        )
    }
}