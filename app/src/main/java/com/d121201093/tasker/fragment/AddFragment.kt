package com.d121201093.tasker.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.d121201093.tasker.R
import com.d121201093.tasker.database.TaskEntry
import com.d121201093.tasker.databinding.FragmentAddBinding
import com.d121201093.tasker.viewmodel.TaskViewModel

class AddFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddBinding.inflate(inflater)

        val myAdapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.priorities)
        )

        binding.apply {
            spinner.adapter = myAdapter
            buttonAdd.setOnClickListener{
                if(TextUtils.isEmpty(edtTasks.text)){
                    Toast.makeText(requireContext(),"It's Empty!!!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val title_str = edtTasks.text.toString()
                val descriptions = descTask.text.toString()
                val priority = spinner.selectedItemPosition

                val taskEntry = TaskEntry(
                    0,
                    title_str,
                    priority,
                    descriptions
                )
                viewModel.insert(taskEntry)
                Toast.makeText(requireContext(), "added", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_addFragment_to_taskFragment)
            }

        }

        return binding.root
    }

}