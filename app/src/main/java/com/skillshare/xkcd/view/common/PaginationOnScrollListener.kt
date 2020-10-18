package com.skillshare.Skillshare.util.view.recycler_view

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * OnScrollListener which can be attached to a recyclerview in order to hook up to api requests for
 * infinite scroll using paginated data sources. Only supports LinearLayoutManagers
 *
 * Example usage:
 * recyclerView.addOnScrollListener(PaginationRecyclerViewOnScrollListener(
 *  itemsFromEndThreshold = 20,
 *  onPastThreshold = { make new paginated call if needed }
 * ))
 */
class PaginationRecyclerViewOnScrollListener(
    private val itemsFromEndThreshold: Int,
    private val onPastThreshold: () -> Unit)
    : RecyclerView.OnScrollListener() {

    /**
     * Convenience constructor for cleaner Java usages
     */
    constructor(itemsFromEndThreshold: Int, loadMore: Runnable) : this(
        itemsFromEndThreshold,
        { loadMore.run() }
    )

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val layoutManager = recyclerView.layoutManager
        if (layoutManager is LinearLayoutManager) {
            layoutManager.orientation
            val scrollTriggered = when (layoutManager.orientation) {
                RecyclerView.HORIZONTAL -> dx > 0
                else -> dy > 0
            }
            if (scrollTriggered) {
                val lastVisibleItem = layoutManager.findLastCompletelyVisibleItemPosition()
                val totalItems = layoutManager.itemCount
                if (totalItems - lastVisibleItem - 1 < itemsFromEndThreshold) {
                    onPastThreshold()
                }
            }
        }
    }
}