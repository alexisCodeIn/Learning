/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.sleeptracker

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding
import com.google.android.gms.wearable.DataItem
import com.google.android.gms.wearable.DataItemAsset
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.ClassCastException

private val ITEM_VIEW_TYPE_HEADER = 0
private val ITEM_VIEW_TYPE_ITEM = 1

class SleepNightAdapter(private val clickListener: SleepNightListener): ListAdapter<com.example.android.trackmysleepquality.sleeptracker.DataItem,RecyclerView.ViewHolder>(SleepNightDiffCallback()) {

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> ViewHolder.from(parent)
            else -> throw ClassCastException("Unknow viewType ${viewType}")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is com.example.android.trackmysleepquality.sleeptracker.DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is com.example.android.trackmysleepquality.sleeptracker.DataItem.SleepNightItem -> ITEM_VIEW_TYPE_ITEM
        }
    }

    fun addHeaderAndSubmitList(list: List<SleepNight>?) {
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(com.example.android.trackmysleepquality.sleeptracker.DataItem.Header)
                else -> listOf(com.example.android.trackmysleepquality.sleeptracker.DataItem.Header) + list.map {
                    com.example.android.trackmysleepquality.sleeptracker.DataItem.SleepNightItem(
                        it
                    )
                }
            }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val nightItem = getItem(position) as com.example.android.trackmysleepquality.sleeptracker.DataItem.SleepNightItem
                holder.bind(clickListener, nightItem.sleepNight)
            }
        }
    }

    class ViewHolder private constructor(val binding: ListItemSleepNightBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(
            clickListener: SleepNightListener,
            item: SleepNight
        ) {
            binding.sleep = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemSleepNightBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    class TextViewHolder(view: View): RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): TextViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.header, parent, false)
                return TextViewHolder(view)
            }
        }
    }
}


class SleepNightDiffCallback :
    DiffUtil.ItemCallback<com.example.android.trackmysleepquality.sleeptracker.DataItem>() {
    override fun areItemsTheSame(oldItem: com.example.android.trackmysleepquality.sleeptracker.DataItem, newItem: com.example.android.trackmysleepquality.sleeptracker.DataItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: com.example.android.trackmysleepquality.sleeptracker.DataItem, newItem: com.example.android.trackmysleepquality.sleeptracker.DataItem): Boolean {
        return oldItem == newItem
    }
}

class SleepNightListener(val clickListener: (sleepId: Long) -> Unit) {
    fun onClick(night: SleepNight) = clickListener(night.nightId)

    data class holamundo(val nothing: Nothing){

    }
}

sealed class DataItem {
    data class SleepNightItem(val sleepNight: SleepNight): com.example.android.trackmysleepquality.sleeptracker.DataItem(){
        override  val id = sleepNight.nightId
    }

    object Header: com.example.android.trackmysleepquality.sleeptracker.DataItem() {
        override val id = Long.MIN_VALUE
    }

    abstract val id: Long

    }