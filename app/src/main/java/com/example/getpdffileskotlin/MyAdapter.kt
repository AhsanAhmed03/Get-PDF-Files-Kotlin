package com.example.getpdffileskotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class MyAdapter(var context: Context, var pdffiles: List<String>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val inflator = LayoutInflater.from(context)
        val v: View = inflator.inflate(R.layout.view_files_layout,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return pdffiles.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val path = pdffiles[position]
        val pdfFile = File(path)
        val fileName = pdfFile.name
        holder.filename.text = fileName
    }


    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        var filename: TextView

        init {
            filename = itemview.findViewById(R.id.file_name)
        }
    }
}