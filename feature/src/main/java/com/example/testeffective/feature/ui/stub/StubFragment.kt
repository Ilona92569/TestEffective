package com.example.testeffective.feature.ui.stub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testeffective.feature.databinding.FragmentStubBinding

class StubFragment : Fragment() {
    private var _binding: FragmentStubBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentStubBinding.inflate(inflater, container, false)
            .also { _binding = it }.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}