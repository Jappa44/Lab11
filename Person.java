

/**
 * 
 */
public class Person implements Comparable<Person>{

	private int age, zipCode;;
	private String name, address;
	private double salary;
	
	public Person() {
		
	}
	
	public Person(int age, String name, String address, int zipCode, double salary) {
		setAge(age);
		setName(name);
		setAddress(address);
		setZipCode(zipCode);
		setSalary(salary);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return 	String.format("%d %s %s %d $%,.2f%n", age, name, address, zipCode, salary);
	}

	@Override
	public int compareTo(Person o) {
		
		if (this.getSalary() > o.getSalary()) {
			return 1;
		} else if (this.getSalary() < o.getSalary()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	
}
