package com.hmei.nmrd.kanban

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var rvTodo: RecyclerView? = null
    private var rvInProgress: RecyclerView? = null
    private var rvDone: RecyclerView? = null
    private var tvEmptyListTodo: TextView? = null
    private var tvEmptyListInProgress: TextView? = null
    private var tvEmptyListDone: TextView? = null
    var fullList = arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        findViewById<TextView>(R.id.tvEmptyListTodo).visibility = View.VISIBLE
//        findViewById<TextView>(R.id.tvEmptyListInProgress).visibility = View.VISIBLE
//        findViewById<TextView>(R.id.tvEmptyListDone).visibility = View.VISIBLE
        rvTodo=findViewById(R.id.recyclerViewTodo)
        rvInProgress = findViewById(R.id.recyclerViewInProgress)
        rvDone = findViewById(R.id.recyclerViewDone)
        tvEmptyListTodo = findViewById(R.id.tvEmptyListTodo)
        tvEmptyListInProgress = findViewById(R.id.tvEmptyListInProgress)
        tvEmptyListDone = findViewById(R.id.tvEmptyListDone)

        setEmptyListTodo(true)
        setEmptyListInProgress(true)
        setEmptyListDone(true)
        setDummyList()
    }

    private fun setEmptyListTodo(visibility: Boolean) {
        tvEmptyListTodo?.visibility = if (visibility) View.VISIBLE else View.GONE
        rvTodo?.visibility  = if (visibility) View.GONE else View.VISIBLE
    }
    private fun setEmptyListInProgress(visibility: Boolean) {
        tvEmptyListInProgress?.visibility  = if (visibility) View.VISIBLE else View.GONE
        rvInProgress?.visibility  = if (visibility) View.GONE else View.VISIBLE
    }
    private fun setEmptyListDone(visibility: Boolean) {
        tvEmptyListDone?.visibility  = if (visibility) View.VISIBLE else View.GONE
        rvDone?.visibility  = if (visibility) View.GONE else View.VISIBLE
    }


    fun setDummyList(){
        fullList=append(fullList,"Todo1,TODO")
        fullList=append(fullList,"Prog1,PROGRESS")
    }

    fun append(arr: Array<String>, element: String): Array<String> {
        val list: MutableList<String> = arr.toMutableList()
        list.add(element)
        return list.toTypedArray()
    }
}