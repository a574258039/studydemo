package com.zzg.study.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 690. 员工的重要性
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 *
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-importance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode690 {


    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        int total = 0;
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(employeeMap.get(id));
        while (!queue.isEmpty()) {
            Employee employee = queue.poll();
            total += employee.importance;
            for (Integer integer : employee.subordinates) {
                queue.offer(employeeMap.get(integer));
            }
        }
        return total;
    }



    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}

