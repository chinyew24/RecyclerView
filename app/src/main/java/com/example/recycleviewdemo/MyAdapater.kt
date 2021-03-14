package com.example.recycleviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//a list of students to pass in = List<StudentItem>
class MyAdapater(private val studentList: List<StudentItem>): RecyclerView.Adapter<MyAdapater.MyViewHolder>() { //<> = tell adapter which one to refer

    //Ctrl + i to create abstract method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //to display
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //INDICATE WHICH COMPONENT TO DISPLAY RESULT
        val currentItem = studentList[position]
        holder.imgView.setImageResource(currentItem.imageResource) //passed from studentitem
        holder.tvName.setText(currentItem.name)
        holder.tvProgramme.setText(currentItem.programme)
    }

    override fun getItemCount(): Int {
        return studentList.size //return size of array studentlist
    }

    //pass itemview from item_view.xml
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imgView:ImageView = itemView.findViewById(R.id.imgPhoto)
        val tvName:TextView = itemView.findViewById(R.id.tvName)
        val tvProgramme:TextView = itemView.findViewById(R.id.tvProgramme)
    }
}