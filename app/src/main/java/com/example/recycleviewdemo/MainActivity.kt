package com.example.recycleviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.data.Student
import com.example.roomdemo.data.StudentDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var myStudentList = ArrayList<StudentItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //generateData()

        val btnAdd: Button = findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener(){
            val newRec: Student = Student(0,"Chin yew", "RSF")

            CoroutineScope(Dispatchers.IO).launch {
                val studentDAO = StudentDB.getDatabase(application).studentDao()
                studentDAO.addStudent(newRec)
            }

        }

        val btnOK: Button = findViewById(R.id.btnOK)
        btnOK.setOnClickListener(){

            CoroutineScope(Dispatchers.Main).launch {

                val studentDAO = StudentDB.getDatabase(application).studentDao()
                val studentList: Array<Student> = studentDAO.getAllStudent()

                myStudentList.clear()
                if(studentList != null){
                    for(s: Student in studentList) {
                        myStudentList.add(StudentItem(R.drawable.smile_face,s.name,s.programme))
                    }
                }

            }
            val recyclerView: RecyclerView =findViewById(R.id.myStudentView)

            recyclerView.adapter = MyAdapater(myStudentList)

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
        }
    }

    /*fun generateData(){
        val stud1 = StudentItem(R.drawable.smile_face, "Chin Yew","RSF")
        val stud2 = StudentItem(R.drawable.smile_face, "Alex","RDS")
        val stud3 = StudentItem(R.drawable.smile_face, "John","RST")
        val stud4 = StudentItem(R.drawable.smile_face, "Mark Yeow","RSF")
        val stud5 = StudentItem(R.drawable.smile_face, "Steven","RIT")

        myStudentList.add(stud1)
        myStudentList.add(stud2)
        myStudentList.add(stud3)
        myStudentList.add(stud4)
        myStudentList.add(stud5)
    }*/
}