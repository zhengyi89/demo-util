package com.demo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Stream是对集合的包装,通常和lambda一起使用。 使用lambdas可以支持许多操作,如 map, filter, limit, sorted,
 * count, min, max, sum, collect 等等。 同样,Stream使用懒运算,他们并不会真正地读取所有数据,遇到像getFirst()
 * 这样的方法就会结束链式语法。
 * 
 * @author zhengy
 *
 */
public class StreamTest {

	public static void main(String[] args) {

		/*
		 * 我们同样使用forEach方法,增加java程序员的工资5%:
		 */
		// javaProgrammers.forEach((p) -> (p.setSalary(p.getSalary()*2)));
		//
		//
		// printSalary();

		// doSalaryByFilter();

//		customFilter();
	printName();
	}

	static void printName() {
		/*
		 * 现在我们使用forEach方法来迭代输出上述列表:
		 */
		System.out.println("java程序员的姓名－－－－－－－－－－－");
		javaProgrammers.forEach((p) -> System.out.printf("%s %s; ",
				p.getFirstName(), p.getLastName()));
		System.out.println("---------");
		System.out.println("php程序员的姓名－－－－－－－－－－－");
		phpProgrammers.forEach((p) -> System.out.printf("%s %s; ",
				p.getFirstName(), p.getLastName()));
	}

	static void printSalary() {
		/*
		 * 现在我们使用forEach方法来迭代输出上述列表:
		 */
		System.out.println("java程序员的薪水－－－－－－－－－－－");
		javaProgrammers
				.forEach((p) -> System.out.printf("%s; ", p.getSalary()));
		System.out.println("---------");
		System.out.println("php程序员的薪水－－－－－－－－－－－");
		phpProgrammers.forEach((p) -> System.out.printf("%s; ", p.getSalary()));
	}

	/**
	 * 另一个有用的方法是过滤器filter() ,让我们显示月薪超过1400美元的PHP程序员:
	 */
	static void doSalaryByFilter() {
		System.out.println("下面是月薪超过 $1,400 的PHP程序员:");
		phpProgrammers
				.stream()
				.filter((p) -> (p.getSalary() > 1400))
				.forEach(
						(p) -> System.out.printf("%s %s; ", p.getFirstName(),
								p.getLastName()));
	}

	/**
	 * 我们也可以定义过滤器,然后重用它们来执行其他操作
	 */
	static void customFilter() {
		// 定义 filters
		Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
		Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
		Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

		System.out.println("下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");
		phpProgrammers
				.stream()
				.filter(ageFilter)
				.filter(salaryFilter)
				.filter(genderFilter)
				.forEach(
						(p) -> System.out.printf("%s %s; ", p.getFirstName(),
								p.getLastName()));

		// 重用filters
		System.out.println("年龄大于 24岁的女性 Java programmers:");
		javaProgrammers
				.stream()
				.filter(ageFilter)
				.filter(genderFilter)
				.forEach(
						(p) -> System.out.printf("%s %s; ", p.getFirstName(),
								p.getLastName()));
	}

	/**
	 * 使用limit方法,可以限制结果集的个数:
	 */
	static void limit() {
		Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));
		System.out.println("最前面的3个 Java programmers:");
		javaProgrammers
				.stream()
				.limit(3)
				.forEach(
						(p) -> System.out.printf("%s %s; ", p.getFirstName(),
								p.getLastName()));

		System.out.println("最前面的3个女性 Java programmers:");
		javaProgrammers
				.stream()
				.filter(genderFilter)
				.limit(3)
				.forEach(
						(p) -> System.out.printf("%s %s; ", p.getFirstName(),
								p.getLastName()));
	}

	static void sortList() {
		System.out.println("根据 name 排序,并显示前5个 Java programmers:");
		List<Person> sortedJavaProgrammers = javaProgrammers
				.stream()
				.sorted((p, p2) -> (p.getFirstName().compareTo(p2
						.getFirstName()))).limit(5)
				.collect(Collectors.toList());

		sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n",
				p.getFirstName(), p.getLastName()));

		System.out.println("根据 salary 排序 Java programmers:");
		sortedJavaProgrammers = javaProgrammers.stream()
				.sorted((p, p2) -> (p.getSalary() - p2.getSalary()))
				.collect(Collectors.toList());

		sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n",
				p.getFirstName(), p.getLastName()));
	}

	static void getMaxAndMin() {
		System.out.println("工资最低的 Java programmer:");
		Person pers = javaProgrammers.stream()
				.min((p1, p2) -> (p1.getSalary() - p2.getSalary())).get();

		System.out.printf("Name: %s %s; Salary: $%,d.", pers.getFirstName(),
				pers.getLastName(), pers.getSalary());

		System.out.println("工资最高的 Java programmer:");
		Person person = javaProgrammers.stream()
				.max((p, p2) -> (p.getSalary() - p2.getSalary())).get();

		System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(),
				person.getLastName(), person.getSalary());
	}

	static List<Person> javaProgrammers = new ArrayList<Person>() {
		{
			add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43,
					2000));
			add(new Person("Tamsen", "Brittany", "Java programmer", "female",
					23, 1500));
			add(new Person("Floyd", "Donny", "Java programmer", "male", 33,
					1800));
			add(new Person("Sindy", "Jonie", "Java programmer", "female", 32,
					1600));
			add(new Person("Vere", "Hervey", "Java programmer", "male", 22,
					1200));
			add(new Person("Maude", "Jaimie", "Java programmer", "female", 27,
					1900));
			add(new Person("Shawn", "Randall", "Java programmer", "male", 30,
					2300));
			add(new Person("Jayden", "Corrina", "Java programmer", "female",
					35, 1700));
			add(new Person("Palmer", "Dene", "Java programmer", "male", 33,
					2000));
			add(new Person("Addison", "Pam", "Java programmer", "female", 34,
					1300));
		}
	};

	static List<Person> phpProgrammers = new ArrayList<Person>() {
		{
			add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
			add(new Person("Clarette", "Cicely", "PHP programmer", "female",
					23, 1200));
			add(new Person("Victor", "Channing", "PHP programmer", "male", 32,
					1600));
			add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21,
					1000));
			add(new Person("Osborne", "Shad", "PHP programmer", "male", 32,
					1100));
			add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25,
					1300));
			add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36,
					1100));
			add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21,
					1000));
			add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
			add(new Person("Evonne", "Shari", "PHP programmer", "female", 40,
					1800));
		}
	};
}
