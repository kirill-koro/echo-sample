package ru.tsu.echoSample.app.feature.topic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.tsu.echoSample.app.databinding.TopicItemBinding
import ru.tsu.echoSample.app.feature.topic.TopicsAdapter.ViewHolder
import ru.tsu.echoSample.app.feature.topic.model.TopicUi

class TopicsAdapter : RecyclerView.Adapter<ViewHolder> {
    constructor(listener: OnItemSelectedListener) : super() {
        this.listener = listener
        setHasStableIds(true)
    }

    class ViewHolder(val binding: TopicItemBinding) : RecyclerView.ViewHolder(binding.root)

    var items: List<TopicUi> = emptyList()
        set(value) {
            field = value
            notifyItemRangeChanged(START_IDX, value.size)
        }

    private val listener: OnItemSelectedListener

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicItemBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val topic = items[position]
        with(holder.binding) {
            title.text = topic.title
            summary.text = topic.summary
            root.setOnClickListener { listener.onNavigateToTopicDetails(topic.id) }
        }
    }

    override fun getItemCount(): Int = items.size

    fun interface OnItemSelectedListener {
        fun onNavigateToTopicDetails(id: Int)
    }

    companion object {
        private const val START_IDX = 0
    }
}
