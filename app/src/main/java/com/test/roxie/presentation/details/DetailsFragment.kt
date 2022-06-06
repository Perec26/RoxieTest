package com.test.roxie.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.test.roxie.R
import com.test.roxie.base.util.ImageHandler
import com.test.roxie.databinding.FragmentDetailsBinding
import com.test.roxie.presentation.details.model.OrderUi
import com.test.roxie.presentation.main.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

typealias DetailsState = ViewState<OrderUi>

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModel<DetailsViewModel> {
        parametersOf(requireArguments().getInt(EXTRA_ORDER_ID))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.currentOrder.observe(viewLifecycleOwner, ::onNewOrder)
        binding.toolbar.setNavigationOnClickListener { viewModel.onBackPressed() }
    }

    private fun onNewOrder(viewState: DetailsState) {
        if (viewState is ViewState.Success) {
            with(viewState.data) {
                binding.amount.text = requireContext().getString(R.string.amount, amount)
                binding.date.text = requireContext().getString(R.string.date, date)
                binding.time.text = requireContext().getString(R.string.time, time)
                binding.startAddress.text = requireContext().getString(R.string.start_address, startAddress)
                binding.endAddress.text = requireContext().getString(R.string.end_address, endAddress)
                binding.driverName.text = requireContext().getString(R.string.driver_name, driverName)
                binding.modelName.text = requireContext().getString(R.string.model_name, modelName)
                binding.regNumber.text = requireContext().getString(R.string.reg_number, regNumber)
                val bitmap = ImageHandler(requireContext()).getImage(photo)
                binding.image.setImageBitmap(bitmap)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val EXTRA_ORDER_ID = "orderId"

        fun getNewInstance(orderId: Int): DetailsFragment {
            return DetailsFragment().apply {
                arguments = bundleOf(EXTRA_ORDER_ID to orderId)
            }

        }

    }

}