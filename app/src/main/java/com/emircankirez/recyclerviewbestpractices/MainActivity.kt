package com.emircankirez.recyclerviewbestpractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.emircankirez.recyclerviewbestpractices.adapter.ItemAdapter
import com.emircankirez.recyclerviewbestpractices.data.DummyData
import com.emircankirez.recyclerviewbestpractices.databinding.ActivityMainBinding
import com.emircankirez.recyclerviewbestpractices.model.Item

class MainActivity : AppCompatActivity(), ItemAdapter.OnItemClickListener{
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : ItemAdapter
    private lateinit var itemList : ArrayList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        itemList = DummyData.getData()
        binding.apply {
            val layoutManager =  LinearLayoutManager(this@MainActivity)
            rvItems.layoutManager = layoutManager
            adapter = ItemAdapter(itemList, this@MainActivity)
            // rvItems.addItemDecoration(DividerItemDecoration(baseContext, layoutManager.orientation)) // adding divider between each recycler row
            rvItems.adapter = adapter
        }
    }
    // what happens if I click an item on recyclerView
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "You clicked ${itemList[position].title}.", Toast.LENGTH_SHORT).show()
    }

    // delete item for long click
    override fun onItemLongClick(position: Int) {
        itemList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
}