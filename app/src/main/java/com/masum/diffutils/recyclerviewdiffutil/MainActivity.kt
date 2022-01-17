package com.masum.diffutils.recyclerviewdiffutil

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.appybuilder.mdbillalhossain1.recyclerviewdiffutil.databinding.ActivityMainBinding
import com.masum.diffutils.recyclerviewdiffutil.utils.DummyEmployeeDataUtils

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mRecyclerViewAdapter by lazy {
        EmployeeRecyclerViewAdapter(DummyEmployeeDataUtils.employeeListSortedByRole)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = mRecyclerViewAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sort_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sort_by_name -> {
                mRecyclerViewAdapter.updateEmployeeListItems(
                    DummyEmployeeDataUtils.employeeListSortedByName
                )
                return true
            }
            R.id.sort_by_role -> {
                mRecyclerViewAdapter.updateEmployeeListItems(
                    DummyEmployeeDataUtils.employeeListSortedByRole
                )
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}