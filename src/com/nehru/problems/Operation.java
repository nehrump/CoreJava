package com.nehru.problems;

class Operation{


    public static void main(String args[]){
        Employee e1=new Employee(50);
        Employee e2=e1;
        Employee e3=e2;
        System.out.println("E1 :"+e1);
        System.out.println("E2 :"+e2);
        System.out.println("E3 :"+e3);

        e3.salary=100;

        System.out.println("E1 :"+e1);
        System.out.println("E2 :"+e2);
        System.out.println("E3 :"+e3);

        e3=new Employee(150);

        System.out.println("E1 :"+e1);
        System.out.println("E2 :"+e2);
        System.out.println("E3 :"+e3);
    }
}

class Employee {
    int salary;

    public Employee(int salary) {
        this.salary = salary;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                '}';
    }
}
