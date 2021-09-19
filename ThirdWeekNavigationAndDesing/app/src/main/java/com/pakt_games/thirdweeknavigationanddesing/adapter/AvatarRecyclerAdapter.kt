package com.pakt_games.thirdweeknavigationanddesing.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pakt_games.thirdweeknavigationanddesing.R
import com.pakt_games.thirdweeknavigationanddesing.model.Data
import com.pakt_games.thirdweeknavigationanddesing.util.stringView
import kotlinx.android.synthetic.main.recycler_avatar_row.view.*
import kotlinx.android.synthetic.main.recycler_text_row.view.*

 class AvatarRecyclerAdapter(val dataList:ArrayList<Data>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
     var checkBoxControlValue:Boolean?=false

     //This view holder for the avatar image view items
    class AvatarViewHolder(item: View): RecyclerView.ViewHolder(item) {}
     //This view holder for the text view items
    class TextViewHolder(item: View):RecyclerView.ViewHolder(item) {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view:View
        //attachToRoot if taking parameter true this line exception(WARN)

        var viewHolder:RecyclerView.ViewHolder
        if(viewType== stringView)
        {
            //this row layout for the recycler text item
            view =inflater.inflate(R.layout.recycler_text_row,parent,false)
            viewHolder= TextViewHolder(view)

        }
        else
        {
            //this row layout for the recycler avatar image item
            view =inflater.inflate(R.layout.recycler_avatar_row,parent,false)
            viewHolder= AvatarViewHolder(view)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //if data type =TEXTVİEW and holder TextViewHolder
        if (dataList[position].recyclerViewType == stringView && holder is TextViewHolder)
        {
            //Pushing text in the recycler text row
            dataList[position].recyclerTextAvatar?.let {
                holder.itemView.textViewAvatarText.setText(
                    it
                )
            }
        }
        else
        {
            //Pushing image in the reycler avatar row
            dataList[position].recyclerAvatarRes?.let {
                holder.itemView.imageViewAvatar.setImageResource(
                    it
                )
            }

            //if checkBox selected
                holder.itemView.imageViewCheckBox.setOnClickListener {
                    if(checkBoxControlValue==false)
                    {
                        //checked checkBox
                    holder.itemView.imageViewCheckBox.setImageResource(R.drawable.ic_success_outline)
                    checkBoxControlValue=true
                    }
                    else
                    {
                        //for checkbox cloning the dataList
                        val checkedData=dataList.clone()
                        //Clearing data
                        checkBoxControl(checkedData as List<Data>)
                        checkBoxControlValue=false
                    }
                }
        }


    }
    //Max item count value
    override fun getItemCount(): Int {
        return dataList.size
    }
    //Getting view types
    override fun getItemViewType(position: Int): Int {
        return dataList[position].recyclerViewType
    }
    //update all items
    fun updateToDataList(newDataList:List<Data>)
    {
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }
     //for checkbox update data
    fun checkBoxControl(newDataList:List<Data>)
    {
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }

}
