package com.bs.employee.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.employee.beans.Employee;
import com.bs.employee.repo.EmployeeRepo;

@Service
public class MultithreadedService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public List<Employee> getAllEmployees() throws InterruptedException {

		long start = System.currentTimeMillis();

		List<Employee> findAll = employeeRepo.findAll();
		long end = System.currentTimeMillis();

		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("#################################Execution time is " + formatter.format((end - start) / 1000d)
				+ " seconds(\"#################################");

		
		return findAll;
	}

	public List<Employee> getAllEmployeesMultithread() throws InterruptedException {
		List<Employee> mainList = new LinkedList<>();

		List<Employee> getByID = new LinkedList<>();
		long start = System.currentTimeMillis();

		// ThreadOne Creation
		Runnable runnable = () -> {
			synchronized (this) {
				mainList.addAll(employeeRepo.getEmployeeByDeptID("1"));
				this.notify();
			}
		};

		Thread threadOne = new Thread(runnable);
		threadOne.start();
		synchronized (threadOne) {
			threadOne.wait();
		}

		// Thread-2 Creation
		Runnable runnableTwo = () -> {
			synchronized (this) {
				mainList.addAll(employeeRepo.getEmployeeByDeptID("2"));
				this.notify();
			}
		};

		Thread threadTwo = new Thread(runnableTwo);
		threadTwo.start();
		synchronized (threadTwo) {
			threadTwo.wait();
		}

		// Thread-3 Creation
		Runnable runnableThree = () -> {
			synchronized (this) {
				mainList.addAll(employeeRepo.getEmployeeByDeptID("3"));
				this.notify();
			}
		};

		Thread threadThree = new Thread(runnableThree);
		threadThree.start();
		synchronized (threadThree) {
			threadThree.wait();
		}
		// Thread-4 Creation
		Runnable runnableFour = () -> {
			synchronized (this) {
				mainList.addAll(employeeRepo.getEmployeeByDeptID("4"));
				this.notify();
			}
		};

		Thread threadFour = new Thread(runnableFour);
		threadFour.start();
		synchronized (threadFour) {
			threadFour.wait();
		}

		long end = System.currentTimeMillis();

		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("#################################Execution time is " + formatter.format((end - start) / 1000d)
				+ " seconds(\"#################################");
		return mainList;
	}

	public void updateEmployee() {
		long start = System.currentTimeMillis();
		List<Employee> findAll = employeeRepo.findAll();
		
		findAll.stream().filter(emp->emp.getDepartment_id()==1).forEach(emp-> emp.setPhone("1"));
		findAll.stream().filter(emp->emp.getDepartment_id()==2).forEach(emp-> emp.setPhone("2"));
		findAll.stream().filter(emp->emp.getDepartment_id()==3).forEach(emp-> emp.setPhone("3"));
		findAll.stream().filter(emp->emp.getDepartment_id()==4).forEach(emp-> emp.setPhone("4"));
		employeeRepo.saveAll(findAll);
		long end = System.currentTimeMillis();

		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("#################################Execution time is " + formatter.format((end - start) / 1000d)
				+ " seconds(\"#################################");	

	}

	public void updateEmployeeByThreads() throws InterruptedException {
		
		long start = System.currentTimeMillis();

		// ThreadOne Creation
		Runnable runnable = () -> {
			synchronized (this) {
				employeeRepo.updateEmployee("1");
				this.notify();
			}
		};

		Thread threadOne = new Thread(runnable);
		threadOne.start();
		synchronized (threadOne) {
			threadOne.wait();
		}

		// Thread-2 Creation
		Runnable runnableTwo = () -> {
			synchronized (this) {
				employeeRepo.updateEmployee("2");
				this.notify();
			}
		};

		Thread threadTwo = new Thread(runnableTwo);
		threadTwo.start();
		synchronized (threadTwo) {
			threadTwo.wait();
		}

		// Thread-3 Creation
		Runnable runnableThree = () -> {
			synchronized (this) {
				employeeRepo.updateEmployee("3");
				this.notify();
			}
		};

		Thread threadThree = new Thread(runnableThree);
		threadThree.start();
		synchronized (threadThree) {
			threadThree.wait();
		}
		// Thread-4 Creation
		Runnable runnableFour = () -> {
			synchronized (this) {
				employeeRepo.updateEmployee("4");
				this.notify();
			}
		};

		Thread threadFour = new Thread(runnableFour);
		threadFour.start();
		synchronized (threadFour) {
			threadFour.wait();
		}

		long end = System.currentTimeMillis();

		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("#################################Execution time is " + formatter.format((end - start) / 1000d)
				+ " seconds(\"#################################");

	}

}
