package com.masum.diffutils.recyclerviewdiffutil

import com.masum.diffutils.recyclerviewdiffutil.Employee
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.masum.diffutils.recyclerviewdiffutil.R
import com.masum.diffutils.recyclerviewdiffutil.EmployeeDiffCallback
import androidx.recyclerview.widget.DiffUtil.DiffResult
import androidx.recyclerview.widget.DiffUtil
import android.widget.TextView
import java.util.ArrayList

class EmployeeRecyclerViewAdapter(employeeList: List<Employee>?) :
    RecyclerView.Adapter<EmployeeRecyclerViewAdapter.ViewHolder>() {
    private val mEmployees: MutableList<Employee> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = mEmployees[position]
        holder.name.text = employee.getName()
        holder.role.text = employee.getRole()
    }

    fun updateEmployeeListItems(employees: List<Employee>?) {
        val diffCallback = EmployeeDiffCallback(mEmployees, employees)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        mEmployees.clear()
        mEmployees.addAll(employees!!)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
        return mEmployees.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val role: TextView
        val name: TextView

        init {
            name = itemView.findViewById<View>(R.id.employee_name) as TextView
            role = itemView.findViewById<View>(R.id.employee_role) as TextView
        }
    }

    init {
        mEmployees.addAll(employeeList!!)
    }
}