package com.example.roomdemo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao //DATA ACCESS OBJECT - SQL QUERY
interface StudentDAO {

    @Insert
    suspend fun addStudent(student: Student) //parametername:classname //suspend - work in background

    @Query(value = "Select * from student_table")
    suspend fun getAllStudent() : Array<Student> //use array to return list of students

}