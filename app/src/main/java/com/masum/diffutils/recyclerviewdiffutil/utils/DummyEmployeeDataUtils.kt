package com.masum.diffutils.recyclerviewdiffutil.utils

import com.masum.diffutils.recyclerviewdiffutil.Employee
import java.util.*

object DummyEmployeeDataUtils {
    val employeeListSortedByName: List<Employee>
        get() {
            val employeeList: List<Employee> = employeeList
            Collections.sort(
                employeeList,
                Comparator<Employee> { a1, a2 -> a1.getName().compareTo(a2.getName()) })
            return employeeList
        }
    val employeeListSortedByRole: List<Employee>
        get() {
            val employeeList: List<Employee> = employeeList
            Collections.sort(
                employeeList,
                Comparator<Employee> { a1, a2 -> a2.getRole().compareTo(a1.getRole()) })
            return employeeList
        }
    val employeeList: List<Employee>
        get() {
            val employees: MutableList<Employee> = ArrayList<Employee>()
            employees.add(Employee(1, "Employee 1", "Developer"))
            employees.add(Employee(2, "Employee 2", "Tester"))
            employees.add(Employee(3, "Employee 3", "Support"))
            employees.add(Employee(4, "Employee 4", "Sales Manager"))
            employees.add(Employee(5, "Employee 5", "Manager"))
            employees.add(Employee(6, "Employee 6", "Team lead"))
            employees.add(Employee(7, "Employee 7", "Scrum Master"))
            employees.add(Employee(8, "Employee 8", "Sr. Tester"))
            employees.add(Employee(9, "Employee 9", "Sr. Developer"))
            return employees
        }
}