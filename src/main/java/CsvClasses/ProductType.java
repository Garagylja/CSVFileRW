package CsvClasses;

import java.io.IOException;

/**
 * Created by user on 15.09.2015.
 */

public class ProductType implements Comparable {

	private String name;
	private String dateManufacture;
	private double price;


	public ProductType () {

		this.name = null;
		this.dateManufacture = null;
		this.price = 0.0;

	}

	public ProductType (String name, String dateManufacture, double price) {

		this.name = name;
		this.dateManufacture = dateManufacture;
		this.price = price;

	}

	public int compareTo (Object o) {

		return compareToName((ProductType) o);
	}

	public String getName () {

		return name;
	}

	public void setName (String name) {

		this.name = name;
	}

	public String getDateManufacture () {

		return this.dateManufacture;
	}

	public void setDateManufacture (String dateManufacture) {

		this.dateManufacture = dateManufacture;
	}

	public double getPrice () {

		return price;
	}

	public void setPrice (double price) {

		this.price = price;
	}


	// сравнения по полям

	public int compareToName (ProductType productType) {

		this.name = productType.name;

		return this.name.compareTo(productType.getName());

	}

	public int compareToDateManufacture (ProductType productType) {

		return this.dateManufacture.compareTo(productType.dateManufacture);

	}


	public int compareToPrice (ProductType productType) {

		if (this.price > productType.price) {
			return 1;
		}
		if (this.price < productType.price) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString () {

		return "Product: " + this.name + " Date Manufacture: " + this.dateManufacture + " | Price: " + this.price;
	}

	//метод который формирует строку для записи в csv file
	public String toCsvString () {

		return this.name + "," + this.dateManufacture + "," + this.price +"\n";
	}

}
