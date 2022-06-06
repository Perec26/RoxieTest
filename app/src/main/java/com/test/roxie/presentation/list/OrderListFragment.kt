package com.test.roxie.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.roxie.databinding.FragmentOrderListBinding
import com.test.roxie.presentation.list.model.OrderItemUi
import com.test.roxie.presentation.list.recycler.OrderListAdapter
import com.test.roxie.presentation.main.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

typealias OrderListState = ViewState<List<OrderItemUi>>

class OrderListFragment : Fragment() {

    private var _binding: FragmentOrderListBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModel<OrderListViewModel>()

    private val adapter by lazy { OrderListAdapter(viewModel::onOrderClick) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentOrderListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.orderList.adapter = adapter
        binding.orderList.layoutManager = LinearLayoutManager(context)
        binding.orderList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        binding.button.setOnClickListener { viewModel.onRetryClick() }
        viewModel.state.observe(viewLifecycleOwner, ::onNewState)
    }

    private fun onNewState(orderListState: OrderListState) {
        binding.loading.isVisible = orderListState is ViewState.Loading
        binding.errorGroup.isVisible = orderListState is ViewState.Error

        if (orderListState is ViewState.Success) {
            adapter.items = orderListState.data
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}