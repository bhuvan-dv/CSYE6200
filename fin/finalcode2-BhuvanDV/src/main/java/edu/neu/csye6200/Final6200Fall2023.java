package edu.neu.csye6200;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * STUDENT TODO CODE SKELETON
 * 100 TOTAL POINTS Create Objects from CSV Strings using Stream API
 * 
 * GIVEN:
 * 	String[] a (array of CSV Strings)
 * 	interface ItemAPI
 * 
 * STUDENT TODO:
 * 	 10 POINTS	Create ConvertUtil inner class
 * 	 10 POINTS	Create inner Item class from ItemAPI
 * 	 10 POINTS	Create inner ItemFactoryAPI
 * 	 10 POINTS	Create inner ItemFactory class from ItemFactoryAPI
 * 	 10 POINTS	Create inner ItemEnumSingletonFactory from enumerated type
 * 	 50 POINTS  Complete code in method demoStream()
 */
public class Final6200Fall2023 {
	public static final int MAJOR = 2;
	public static final int MINOR = 1;
	public static final String VERSION = MAJOR + "." + MINOR;
	/**
	 * GIVEN Item CSV Strings contained in array a
	 */
	private String[] a = {
			"2,1.99,Skim Milk",
			"4,2.99,Tropicana OJ",
			"3,1.49,Whole Wheat Bread",
			"1,0.99,Candy Corn"
	};
	/**
	 * GIVEN ItemAPI
	 * @author dgpeters
	 */
	private interface ItemAPI {
		int getId();
		void setId(int id);
		double getPrice();
		void setPrice(double price);
		String getName();
		void setName(String name);
		String toCSVString();
	}
	
	/**
	 * STUDENT TODO:
	 * ConvertUtil inner class used to convert String representations to numbers
	 */

	static class ConvertUtil {
		public static int convertToInt(String str) {
			return Arrays.stream(str.split(","))
					.mapToInt(Integer::parseInt)
					.findFirst()
					.orElse(0);
		}

		public static double convertToDouble(String str) {
			return Arrays.stream(str.split(","))
					.mapToDouble(Double::parseDouble)
					.findFirst()
					.orElse(0);
		}
	}

	/**
	 * STUDENT TODO:
	 * ItemFactoryAPI
	 */
	interface ItemFactoryAPI {
		ItemAPI getItem(int id, double price, String name);
	}

	/**
	 * STUDENT TODO:
	 * ItemFactory class
	 */
	static class ItemFactory implements ItemFactoryAPI {
		@Override
		public ItemAPI getItem(int id, double price, String name) {
			Item item = new Item();
			item.setId(id);
			item.setName(name);
			item.setPrice(price);

			return item;
		}
	}


	/**
	 * STUDENT TODO:
	 * ItemEnumSingletonFactory enum
	 */
	enum ItemEnumSingletonFactory {
		INSTANCE;

		private ItemFactoryAPI factory = new ItemFactory();

		public ItemFactoryAPI getFactory() {
			return factory;
		}
	}


	/**
	 * STUDENT TODO:
	 * Item inner class implements Comparable
	 * to provide a natural order for sorting Item object BY HIGHEST PRICE
	 * @author dgpeters
	 *
	 */
	static class Item implements Comparable<Item>, ItemAPI {
		private int id;
		private double price;
		private String name;

		/**
		 * STUDENT TODO:
		 */
		
		/**
		 * GIVEN:
		 * override Object toString and return a String representation of Item object
		 */
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			sb.append("# ").append(id);
			sb.append(" $ ").append(price);
			sb.append(" ").append(name);
			
			return sb.toString();
		}

		@Override
		public int getId() {
			return this.id;
		}

		@Override
		public void setId(int id) {
			this.id = id;
		}

		@Override
		public double getPrice() {
			return this.price;
		}

		@Override
		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toCSVString() {
			return null;
		}

		@Override
		public int compareTo(Item o) {
			if (this.price < o.price) {
				return -1;
			} else if (this.price > o.price) {
				return 1;
			} else return 0;
		}
	} // end class Item
	
	/**
	 * STUDENT TODO:
	 * 
	 * COMPLETE THIS CODE.
	 * 
	 * FOR EACH CODE BLOCK,
	 * Use the GIVEN String[] a (CSV Strings) 
	 * and Stream API and COMPLETE CODE as described below:
	 * NOTE: MUST USE Stream API TO DO ALL WORK and to SHOW RESULTS ON CONSOLE
	 */
	public void demoStream() {
		System.out.println("\n\t" + Final6200Fall2023.class.getName() + ".demoStream() ... ");
		
		{
			System.out.println("\n\t" + "Ia (5 POINTS): Stream CSV Strings to SHOW ORIGINAL CSV Strings");
			// STUDENT TODO: create Stream from array a
			Arrays.stream(a)
					.forEach(System.out::println);
			System.out.println();
		}
		{
			System.out.println("\n\t" + "Ib (5 POINTS): Stream CSV Strings to Sort and SHOW CSV Strings");
			// STUDENT TODO: create Stream from array a
			Arrays.stream(a)
					.sorted()
					.forEach(System.out::println);
			System.out.println();
		}

		{
			System.out.println("\n\t" + "II (10 POINTS): Stream CSV Strings to produce Item ");
			System.out.println(a.length + " items");
			// STUDENT TODO: create Stream from array a

			// STUDENT TODO: use Stream operations
			List<ItemAPI> itemList = Arrays.stream(a)
					.map(s -> {
						String[] parts = s.split(",");
						int id = ConvertUtil.convertToInt(parts[0]);
						double price = ConvertUtil.convertToDouble(parts[1]);
						String name = parts[2];
						return new ItemFactory().getItem(id, price, name);
					})
					.collect(Collectors.toList());
			itemList.forEach(System.out::println);

			System.out.println();
		}

		{
			System.out.println("\n\t" + "III (10 POINTS): Stream CSV Strings to produce Item with Singleton Factory ");
			System.out.println(a.length + " items");
			// STUDENT TODO: create Stream from array a

			// STUDENT TODO: use Stream operations
			List<ItemAPI> itemListWithFactory = Arrays.stream(a)
					.map(s -> {
						String[] parts = s.split(",");
						int id = ConvertUtil.convertToInt(parts[0]);
						double price = ConvertUtil.convertToDouble(parts[1]);
						String name = parts[2];
						return ItemEnumSingletonFactory.INSTANCE.getFactory().getItem(id, price, name);
					})
					.collect(Collectors.toList());
			itemListWithFactory.forEach(System.out::println);
			System.out.println();
		}

		{
			System.out.println("\n\t" + "IV (10 POINTS): Stream SORTED CSV Strings to produce Item  ");
			System.out.println(a.length + " items");
			// STUDENT TODO: create Stream from array a

			// STUDENT TODO: use Stream operations
			List<ItemAPI> sortedItemList = Arrays.stream(a)
					.map(s -> {
						String[] parts = s.split(",");
						int id = ConvertUtil.convertToInt(parts[0]);
						double price = ConvertUtil.convertToDouble(parts[1]);
						String name = parts[2];
						return new ItemFactory().getItem(id, price, name);
					})
					.sorted(Comparator.comparingInt(ItemAPI::getId)) // Sort by Id
					.collect(Collectors.toList());
			sortedItemList.forEach(System.out::println);

			System.out.println();
		}

		{
			System.out.println("\n\t" + "V (10 POINTS): Stream CSV Strings to produce SORTED Item List ");
			System.out.println(a.length + " items");
//            List<ItemAPI> itemList =
//                    // STUDENT TODO: create Stream from array a
//
//                    // STUDENT TODO: use Stream operations
//
//                    // STUDENT TODO: create Stream from itemList
//                    System.out.println();
			List<ItemAPI> itemList = Arrays.stream(a)
					.map(s -> {
						String[] parts = s.split(",");
						int id = ConvertUtil.convertToInt(parts[0]);
						double price = ConvertUtil.convertToDouble(parts[1]);
						String name = parts[2];
						return new ItemFactory().getItem(id, price, name);
					})
					.sorted(Comparator.comparingDouble(ItemAPI::getPrice).reversed())
					.collect(Collectors.toList());
			itemList.forEach(System.out::println);
		}
		
		System.out.println("\n\t" + Final6200Fall2023.class.getName() + ".demoStream() ... done!");
	}
	/**
	 * demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + Final6200Fall2023.class.getName() + ".demo() version ["+VERSION+"]... ");
		
		Final6200Fall2023 obj = new Final6200Fall2023();
		
		obj.demoStream();
		System.out.println("\n\t" + Final6200Fall2023.class.getName() + ".demo() version ["+VERSION+"]... done!");
	}
}
