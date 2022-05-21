package com.example.librarymanagement.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.librarymanagement.R
import com.example.librarymanagement.databinding.FragmentScancodeBinding
import com.example.librarymanagement.viewmodel.ScanCodeViewModel
import com.google.zxing.integration.android.IntentIntegrator


class ScanCodeFragment : Fragment(R.layout.fragment_scancode), View.OnClickListener {
    private val viewModel: ScanCodeViewModel by lazy {
        ViewModelProvider(this)[ScanCodeViewModel::class.java]
    }
    private var _binding: FragmentScancodeBinding? = null
    private val binding
        get() = requireNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentScancodeBinding.bind(view)
        binding.scanButton.setOnClickListener(this)
        viewModel.endSessionDetails.observe(viewLifecycleOwner) {
            Log.d("himanshu", it.toString())
        }
        //view.findViewById<>()
//        setupAdapter()
    }

//    private fun setupAdapter() {
//        val adapter = PRListAdapter(requireContext(), pullRequests)
//        viewModel.pullRequests.observe(viewLifecycleOwner) {
//            pullRequests.addAll(it as ArrayList<PullRequest>)
//            adapter.notifyDataSetChanged()
//        }
//        binding.recyclerview.apply {
//            this.adapter = adapter
//            this.setHasFixedSize(true)
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(p0: View?) {
        val intentIntegrator = IntentIntegrator(requireActivity())
        intentIntegrator.setPrompt("Scan a QR Code")
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);  // optional
        intentIntegrator.setOrientationLocked(true)
        intentIntegrator.initiateScan()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        @Nullable data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        val intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        // if the intentResult is null then
        // toast a message as "cancelled"
        if (intentResult != null) {
            if (intentResult.contents == null) {
                Toast.makeText(requireContext(), "Cancelled", Toast.LENGTH_SHORT).show()
            } else {
                // if the intentResult is not null we'll set
                // the content and format of scan message
                var a = intentResult.contents
                var b = intentResult.formatName

//                messageText.setText(intentResult.contents)
//                messageFormat.setText(intentResult.formatName)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}