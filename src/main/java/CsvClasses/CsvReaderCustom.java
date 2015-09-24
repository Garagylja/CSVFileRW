package CsvClasses;

import CsvInterfaces.CsvReader;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 15.09.2015.
 */
public class CsvReaderCustom implements CsvReader {

	private static final String COMMA_DELIMITER = ",";

	private static final int PRODUCT_NAME = 0;
	private static final int PRODUCT_DATE_MANUF = 1;
	private static final int PRODUCT_PRICE = 2;

	private static final Logger LOGGER = Logger.getLogger(CsvReaderCustom.class.toString());

	public CsvReaderCustom () {

	}

	public List<ProductType> readFromFile (String fileName) {
		LOGGER.info("Start .readFromFile");
		BufferedReader fileReader = null;

		List<ProductType> productList = new ArrayList();

		String line = "";

		try {


			//создаем файл ридер

			fileReader = new BufferedReader(new FileReader(fileName));


			//Read the CSV file header to skip it

			fileReader.readLine();

			//Read the file line by line starting from the second line

			while ((line = fileReader.readLine()) != null) {
				//Get all tokens available in lin
				String[] tokens = line.split(COMMA_DELIMITER);

				if (tokens.length > 0) {
					//Create a new ProductType object and fill his  data

					ProductType products = new ProductType(tokens[PRODUCT_NAME], tokens[PRODUCT_DATE_MANUF], Double.parseDouble(tokens[PRODUCT_PRICE]));

					productList.add(products);

				}

			}
			//Распечатать все продукты в листе

			for (ProductType prod : productList) {
				System.out.println(prod.toString());
			}
		} catch (Exception e) {
			LOGGER.error("FileNotFoundException " + e.toString());
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				LOGGER.error("IOException " + e.toString());
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}
		return productList;
	}
}
