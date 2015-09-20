package CsvClasses;

import CsvInterfaces.CsvWriter;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 15.09.2015.
 */
public class CsvWriterCustom implements CsvWriter {

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	private static final Logger LOGGER = Logger.getLogger(CsvWriterCustom.class.toString());

	private static final String FILE_HEADER = "Name,DateManufacture,IdProduct,Price,ExpirationDate";


	public void writeProductListToSCV (String destinationFileName, List<ProductType> newData, boolean appendToFile) throws FileNotFoundException {
		LOGGER.info("Start .writeProductToCSV");
		for (int i = 0; i < newData.size(); i++) {

			if (appendToFile) {
				try {
					File file = new File(destinationFileName);
					if (!file.exists()) {
						try {
							file.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					OutputStreamWriter writeToCSV = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file, appendToFile)));
					writeToCSV.write(newData.get(i).toCsvString());

					writeToCSV.flush();
					writeToCSV.close();

				} catch (FileNotFoundException e) {
					LOGGER.error("File not found!" + e.toString());
					e.printStackTrace();
				} catch (IOException e) {
					LOGGER.error(e.toString());
					e.printStackTrace();
				}
			}
			i++;
		}

	}

	public void writeToSCVRandomData (String destinationFileName, int lineValue) {

		List<ProductType> product = new ArrayList<ProductType>(lineValue);
		LOGGER.info("Start .writeToCSVRandomData");

		for (int i = 0; i < lineValue; i++) {

			product.add(new ProductType(String.format("Product%d", i), String.format("0%d/09/2015", i), (double) 10 + i, 100 + i, String.format("0%d/09/%d", i, (2015 + i))));

		}
		FileWriter fileWriter = null;

		try {

			fileWriter = new FileWriter(destinationFileName);

			//записать хедер в файл

			fileWriter.append(FILE_HEADER.toString());

			//поставить каретку перехода на новую строку в конец строки хедера
			fileWriter.append(NEW_LINE_SEPARATOR);

			for (ProductType prod : product) {

				fileWriter.append(prod.toCsvString());
			}

			System.out.println("CSV file was created successfully !!!");

		} catch (IOException e) {
			LOGGER.error("Не верно введен номер строки!" + "\n");
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}

	}
}
