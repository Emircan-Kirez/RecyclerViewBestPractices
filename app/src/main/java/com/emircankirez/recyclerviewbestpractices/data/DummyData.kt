package com.emircankirez.recyclerviewbestpractices.data

import com.emircankirez.recyclerviewbestpractices.model.Item

object DummyData {
    fun getData() : ArrayList<Item>{
        val itemList = ArrayList<Item>()
        for(i in 0..20){
            val item = Item("Title $i", "Content $i")
            itemList.add(item)
        }
        return itemList
    }
}