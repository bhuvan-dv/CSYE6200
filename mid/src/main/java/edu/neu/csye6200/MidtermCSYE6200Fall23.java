package edu.neu.csye6200;

import java.util.*;

/**
 * class MidtermCSYE6200Fall23 (STUDENT PARTIALLY CODED VERSION)
 * 
 * 
 * STUDENT TODO: 
 * Complete the implementation of this class as follows (MUST DOCUMENT WORK WITH DETAILED DEV_LOG Strings):
 * 
 * Create a generic object model inner class
 * 20 POINTS	class Model INCLUDING
 * 				method to add object to model
 * 				method to sort all objects in model by supplied Comparator
 * 				method toString() to return String representation model state, i.e. return toString() on all objects
 * 
 * 10 POINTS	code inner Person class implementing PersonAPI
 * 				code inner Student class derived from Person implementing StudentAPI
 * 				code inner Employee class derived from Person implementing EmployeeAPI
 * 
 * 10 POINTS	code inner Item class implementing ItemAPI
 * 				code inner Bread class derived from Item
 * 				code inner Oj class derived from Item
 * 				code inner Milk class derived from Item
 * 
 * 15 Points	complete code for demoIntegerModel
 * 15 Points	complete code for demoStringModel
 * 
 * 15 Points	complete code for demoPersonModel
 * 15 Points	complete code for demoItemModel
 * 	
 */
public class MidtermCSYE6200Fall23 {
	public static final int MAJOR = 2;
	public static final int MINOR = 4;
	public static final String[] DEV_LOG = {
			"initial revision",
			"* START OF DEV LOG -- Author @(Bhuvan D V) *",
			"* Firstly wrote method implementation logic for all overrideable methods inside (Person, Item) Class from the respective API interface (PersonAPI, ItemAPI) *",
			"* the above point applies for both Item class (id, price, name) and Person class (id, age, name) *",
			"* classes which extend Person class like student class has gpa and Employee class has wage as an aditional param *",
			"* With the factory methods (Early Singleton,Lazy Singleton and Enum Singleton) *",
			"* I created the respective objects through upcasting (Person-->Student, Employee), (Item-->Bread, Milk, Oj) from respective factory methods *",
			"* Added these items to the model list, by creating List <T> and the class Model <T> using Generics type <T> *",
			"* Implemented sort(Comparator<? super T> c) using various ways method reference and lambda way  *",
			"* based on various sort conditions I have sort data by passing Comparator.comparing(item->item) into the sort method *",
			"* END OF DETAILED DEV LOG Strings DO NOT DELETE *"
	};
	public static final String VERSION = MAJOR + "." + MINOR + DEV_LOG.length;
	
	/**
	 * // STUDENT TODO:
	 * 
	 * code class Model using generic programming
	 */
	private static class Model <T> { // STUDENT TODO:
		private String name = Object.class.getSimpleName();
		List <T> list =new ArrayList<>();
		public Model() {} 
		public Model(String name) {this.name = name; } 
		public void add(T ob){// STUDENT TODO:
			list.add(ob);
		}
		public void sort(Comparator<? super T> c) {    // STUDENT TODO:
			list.sort(c);
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			
			sb.append("Total number of ").append(name).append(" objects in model: ").append(list.size()).append("\n");
			for (T o : list) {
				sb.append(o).append("\n");
			}
			
			return sb.toString();
		}
	}
	
	/**
	 * GIVEN object APIs
	 */
	private interface PersonAPI {
		int getId();
		void setId(int id);
		int getAge();
		void setAge(int age);
		String getName();
		void setName(String name);
	}
	private interface StudentAPI extends PersonAPI {
		double getGpa();
		void setGpa(double gpa);
	}
	private interface EmployeeAPI extends PersonAPI {
		double getWage();
		void setWage(double wage);
	}
	private interface ItemAPI {
		int getId();
		void setId(int id);
		double getPrice();
		void setPrice(double price);
		String getName();
		void setName(String name);
	}
	/**
	 * // STUDENT TODO:
	 * object Factory APIs and Factory classes
	 */
	private interface PersonFactoryAPI {
		// STUDENT TODO:
		public Person bringPerson(String CSV_Data);
	}
	private interface ItemFactoryAPI {
		// STUDENT TODO:
		public Item bringItem(String CSV_DATA);
	}
	private enum PersonFactoryEnumSingleton {
		// STUDENT TODO:
		Instance;
		Person p;
		public Person getPerson(){
			return p;
		}
		public Person setPerson(String PERSON_CSV_DATA){
			String [] data=PERSON_CSV_DATA.split(",");
			p=new Person(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2]);
			return p;
		}
	}
	private static class PersonFactoryEagerSingleton implements PersonFactoryAPI {
		@Override
		public Person bringPerson(String PERSON_CSV_DATA) {
			String [] data=PERSON_CSV_DATA.split(",");
			return new Person(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2]);
		}
		// STUDENT TODO:
	}
	private static class StudentFactoryEagerSingleton implements PersonFactoryAPI {
		private static final StudentFactoryEagerSingleton inst=new StudentFactoryEagerSingleton();
		private StudentFactoryEagerSingleton(){}
		public static StudentFactoryEagerSingleton getInstance(){
			return inst;
		}
		@Override
		public Person bringPerson(String STUDENT_CSV_DATA) {
			String [] data=STUDENT_CSV_DATA.split(",");
			int id=Integer.parseInt(data[0]);
			int age=Integer.parseInt(data[1]);
			String name=data[2];
			double gpa=Double.parseDouble(data[3]);
			return new Employee(id,age,name,gpa);
		}
		// STUDENT TODO:
	}
	private static class EmployeeFactoryEagerSingleton implements PersonFactoryAPI {
		private static final EmployeeFactoryEagerSingleton inst=new EmployeeFactoryEagerSingleton();
		private EmployeeFactoryEagerSingleton(){}
		public static EmployeeFactoryEagerSingleton getInstance(){
			return inst;
		}
		@Override
		public Person bringPerson(String EMPLOYEE_CSV_DATA) {
			String [] data=EMPLOYEE_CSV_DATA.split(",");
			int id=Integer.parseInt(data[0]);
			int age=Integer.parseInt(data[1]);
			String name=data[2];
			double wage=Double.parseDouble(data[3]);
			return new Employee(id,age,name,wage);
		}
		// STUDENT TODO:
	}
	private static class EmployeeFactoryLazySingleton implements PersonFactoryAPI {
		private static EmployeeFactoryLazySingleton inst =new EmployeeFactoryLazySingleton();
		private EmployeeFactoryLazySingleton(){
			inst=null;
		}
		public static synchronized EmployeeFactoryLazySingleton getInstance(){
			if(inst==null){
				inst= new EmployeeFactoryLazySingleton();
			}
			return inst;
		}
		@Override
		public Person bringPerson(String EMPLOYEE_CSV_DATA) {
			String [] data=EMPLOYEE_CSV_DATA.split(",");
			int id=Integer.parseInt(data[0]);
			int age=Integer.parseInt(data[1]);
			String name=data[2];
			double wage=Double.parseDouble(data[3]);
			return new Employee(id,age,name,wage);
		}
		// STUDENT TODO:
	}
	
	private static class ItemFactoryEagerSingleton implements ItemFactoryAPI {
		// STUDENT TODO:
		private static final ItemFactoryEagerSingleton inst= new ItemFactoryEagerSingleton();
		private ItemFactoryEagerSingleton(){

		}
		public static ItemFactoryEagerSingleton getInstance(){
			return inst;
		}
		@Override
		public Item bringItem(String CSV_DATA) {
			String [] data=CSV_DATA.split(",");
			return new Item(Integer.parseInt(data[0]),Double.parseDouble(data[1]),data[2]);
		}
	}
	private static class BreadFactoryLazySingleton implements ItemFactoryAPI {
		// STUDENT TODO:
		private static BreadFactoryLazySingleton inst=new BreadFactoryLazySingleton();
		private BreadFactoryLazySingleton(){
			inst=null;
		}
		public static synchronized BreadFactoryLazySingleton getInstance(){
			if(inst == null){
				inst=new BreadFactoryLazySingleton();
			}
			return inst;
		}
		@Override
		public Item bringItem(String CSV_DATA) {
			String [] data=CSV_DATA.split(",");
			return new Bread(Integer.parseInt(data[0]),Double.parseDouble(data[1]),data[2]);
		}
	}
	private static class OjFactoryEagerSingleton implements ItemFactoryAPI {
		// STUDENT TODO:
		private static final OjFactoryEagerSingleton inst=new OjFactoryEagerSingleton();
		private OjFactoryEagerSingleton(){

		}
		public static OjFactoryEagerSingleton getInstance(){
			return inst;
		}
		@Override
		public Item bringItem(String CSV_DATA) {
			String [] data=CSV_DATA.split(",");
			return new Oj(Integer.parseInt(data[0]),Double.parseDouble(data[1]),data[2]);
		}
	}
	private static class MilkFactoryEagerSingleton implements ItemFactoryAPI {
		// STUDENT TODO:
		private static final MilkFactoryEagerSingleton inst =new MilkFactoryEagerSingleton();
		private MilkFactoryEagerSingleton(){

		}
		public static MilkFactoryEagerSingleton getInstance(){
			return  inst;
		}
		@Override
		public Item bringItem(String CSV_DATA) {
			String [] data=CSV_DATA.split(",");
			return new Milk(Integer.parseInt(data[0]),Double.parseDouble(data[1]),data[2]);
		}
	}
	/**
	 * // STUDENT TODO:
	 * Object classes
	 */
	private static class Person implements PersonAPI{

	// STUDENT TODO:
		private int id;
		private int age;
		private String name;

		public Person(int id, int age, String name) {
			this.id=id;
			this.age=age;
			this.name=name;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("Person: ");
			
			sb.append(" # ").append(id);
			sb.append(" ").append(name);
			sb.append(", age ").append(age);
			
			return sb.toString();
		}

		@Override
		public int getId() {
			return id;
		}

		@Override
		public void setId(int id) {
			this.id=id;
		}

		@Override
		public int getAge() {
			return age;
		}

		@Override
		public void setAge(int age) {
			this.age=age;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public void setName(String name) {
			this.name=name;
		}
	}
	private static class Student extends Person implements StudentAPI {
		 double gpa;

		 public Student(int id, int age, String name,double gpa){
			 super(id,age,name);
			 this.gpa=gpa;
		 }

		@Override
		public double getGpa() {
			return this.gpa;
		}

		@Override
		public void setGpa(double gpa) {
			this.gpa=gpa;
		} // STUDENT TODO:
	// STUDENT TODO:
	}
	private static class Employee extends Person implements EmployeeAPI {

		private double wage;
		public Employee(int id, int age, String name,double wage){
			super(id,age,name);
			this.wage=wage;
		}

		@Override
		public double getWage() {
			return this.wage;
		}

		@Override
		public void setWage(double wage) {
			this.wage=wage;
		} // STUDENT TODO:
	// STUDENT TODO:
	}
	
	public static class Item implements ItemAPI {
	// STUDENT TODO:
		String name;
		int id;
		double price;
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("Item: ");
			
			sb.append(" # ").append(id);
			sb.append(" $ ").append(price);
			sb.append(" ").append(name);
			
			return sb.toString();
		}
		public Item(int id, double price, String name){
			this.id=id;
			this.price=price;
			this.name=name;
		}
		@Override
		public int getId() {
			return this.id;
		}

		@Override
		public void setId(int id) {
			this.id=id;
		}

		@Override
		public double getPrice() {
			return this.price;
		}

		@Override
		public void setPrice(double price) {
			this.price=price;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public void setName(String name) {
			this.name=name;
		}
	} // end class Item
	private static class Bread extends Item {
		public Bread(int id, double price, String name) {
			super(id, price, name);
		}// STUDENT TODO:
		// STUDENT TODO:
	}
	private static class Oj extends Item {
		public Oj(int id, double price, String name) {
			super(id, price, name);
		} // STUDENT TODO:
		// STUDENT TODO:
	}
	private static class Milk extends Item {
		public Milk(int id, double price, String name) {
			super(id, price, name);
		} // STUDENT TODO:
		// STUDENT TODO:
	}

	/**
	 * STUDENT TODO: Complete coding of this method
	 */
	public static void demoIntegerModel() {
		// STUDENT TODO:
		int[] a = { 3,1,4,2 };	// supplied data to add to model IN THIS ORDER
		// STUDENT TODO:
		Model<Integer> model = new Model<>(Item.class.getSimpleName());
//		List<Integer> model= new ArrayList<>();
		for(int num:a) {
			model.add(num);
		}
		System.out.println(model);
		
		System.out.println("sort in Default Natural (numerical) order...");
			// STUDENT TODO:
		model.sort(Comparator.comparingInt(num -> (int) num));
		System.out.println(model);
		
		System.out.println("sort in REVERSE (numerical) order...");
			// STUDENT TODO:
		model.sort(Comparator.comparingInt(num -> (int)num*-1));
		System.out.println(model);
	}
	/**
	 * STUDENT TODO: Complete coding of this method
	 */
	public static void demoStringModel() {
		 // STUDENT TODO:
		String[] a = { "C", "A", "D", "B" }; // supplied data to add to model IN THIS ORDER
		// STUDENT TODO:
		Model<String> model = new Model<>(Item.class.getSimpleName());
		for(String str:a){
			model.add(str);
		}
//		List<String> model= Arrays.asList(a);
		System.out.println(model);
		
		System.out.println("sort in Default Natural (alphabetical) order...");
			// STUDENT TODO:
		model.sort(Comparator.comparing(str->str));
		System.out.println(model);
		
		System.out.println("sort in REVERSE alphabetical order...");
			// STUDENT TODO:
		model.sort(Comparator.reverseOrder());
		System.out.println(model);
	}
	/**
	 * STUDENT TODO: Complete coding of this method
	 */
	public static void demoItemModel() {
		Model<ItemAPI> model = new Model<>(Item.class.getSimpleName());
		/**
		 * STUDENT TODO:
		 * 
		 * IN THE FOLLOWING ORDER
		 * add Item object to model using a Eager Singleton factory AND ITEM_CSV_DATA
		 * add Bread object to model using a Lazy Singleton factory AND ITEM_CSV_DATA
		 * add Oj object to model using a Eager Singleton factory AND ITEM_CSV_DATA
		 * add Milk object to model using a Eager Singleton factory AND ITEM_CSV_DATA
		 */
		// STUDENT TODO:

		//adding ITEM
		String ITEM_CSV_DATA="20,20,Rice";
		ItemFactoryEagerSingleton IfEs= ItemFactoryEagerSingleton.getInstance();
		model.add(IfEs.bringItem(ITEM_CSV_DATA));

		//adding Bread
		ITEM_CSV_DATA="05,2.75,Bread";
		BreadFactoryLazySingleton BfLs=BreadFactoryLazySingleton.getInstance();
		model.add(BfLs.bringItem(ITEM_CSV_DATA));

		//adding Orange Juice Oj
		ITEM_CSV_DATA="15,25.89,Oj";
		OjFactoryEagerSingleton OfEs=OjFactoryEagerSingleton.getInstance();
		model.add(OfEs.bringItem(ITEM_CSV_DATA));

		//adding milk
		ITEM_CSV_DATA="01,2.23,Milk";
		MilkFactoryEagerSingleton MfEs=MilkFactoryEagerSingleton.getInstance();
		model.add(MfEs.bringItem(ITEM_CSV_DATA));

		System.out.println(model);

		System.out.println("sort by ID...");
		 // STUDENT TODO:
		model.sort(Comparator.comparingInt(ItemAPI::getId));
		System.out.println(model);

		System.out.println("sort by ASCENDING PRICE (e.g. $1,$2,$3,$4,$5...");
		 // STUDENT TODO:
		model.sort(Comparator.comparingDouble(ItemAPI::getPrice));
		System.out.println(model);

		System.out.println("sort in Default Natural (alphabetical) order...");
			// STUDENT TODO:
		model.sort(Comparator.comparing(ItemAPI::getName));
		System.out.println(model);

		System.out.println("sort in REVERSE alphabetical order...");
		 // STUDENT TODO:
		model.sort(Comparator.comparing(ItemAPI::getName).reversed());
		System.out.println(model);
	}
	/**
	 * STUDENT TODO: Complete coding of this method
	 */
	public static void demoPersonModel() {
		Model<PersonAPI> model = new Model<>(Person.class.getSimpleName());
		/**
		 * STUDENT TODO:
		 * 
		 * IN THE FOLLOWING ORDER
		 * add Person object to model using an Enum Singleton factory AND PERSON_CSV_DATA
		 * add Student object to model using a Eager Singleton factory AND PERSON_CSV_DATA
		 * add Employee object to model using a Lazy Singleton factory AND PERSON_CSV_DATA
		 */
		// STUDENT TODO:

		//adding Persons - ENUM SINGLETON WAY
		String PERSON_CSV_DATA="12,35,Bhuvan";
		PersonFactoryEnumSingleton PfEs=PersonFactoryEnumSingleton.Instance;
		model.add(PfEs.setPerson(PERSON_CSV_DATA));

		//adding Student
		PERSON_CSV_DATA="1,23,Ajay,4.0";
		StudentFactoryEagerSingleton SfEs=StudentFactoryEagerSingleton.getInstance();
		model.add(SfEs.bringPerson(PERSON_CSV_DATA));

		//adding Employee
		PERSON_CSV_DATA="13,28,Raj,350";
		EmployeeFactoryLazySingleton EfLs=EmployeeFactoryLazySingleton.getInstance();
		model.add(EfLs.bringPerson(PERSON_CSV_DATA));

		System.out.println(model);

		System.out.println("sort by ID...");
		model.sort(Comparator.comparingInt(value -> value.getId()));
		 // STUDENT TODO:
		System.out.println(model);

		System.out.println("sort by ASCENDING Age (e.g. 1,2,3,4,5)...");
		 // STUDENT TODO:
		model.sort(Comparator.comparingInt(PersonAPI::getAge));
		System.out.println(model);

		System.out.println("sort in Default Natural (alphabetical) order...");
			// STUDENT TODO:
		model.sort(Comparator.comparing(value->value.getName()));
		System.out.println(model);

		System.out.println("sort in REVERSE alphabetical order...");
		 // STUDENT TODO:
		model.sort(Comparator.comparing(PersonAPI::getName).reversed());
		System.out.println(model);	// STUDENT TODO:
	}
	public static void demo() {
		System.out.println("\n\t" + MidtermCSYE6200Fall23.class.getName() + ".demo() [ version " + VERSION + " ] ...");
		
		MidtermCSYE6200Fall23.demoIntegerModel();
		MidtermCSYE6200Fall23.demoStringModel();
		MidtermCSYE6200Fall23.demoItemModel();
		MidtermCSYE6200Fall23.demoPersonModel();
		for(String a:DEV_LOG){
			System.out.println(a);
		}
		System.out.println("\n\t" + MidtermCSYE6200Fall23.class.getName() + ".demo() ... done!");
	}

}
