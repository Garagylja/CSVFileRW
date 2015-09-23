import CsvClasses.CsvReaderCustom;
import CsvClasses.CsvWriterCustom;
import CsvClasses.ProductType;

import java.util.List;

/**
 * Created by user on 15.09.2015.
 */
public class Runner {
	public static void main (String[] args) {

		String fileName = new String("CsvData.csv");

		CsvWriterCustom writerCustom = new CsvWriterCustom();

		writerCustom.writeToSCVRandomData(fileName, 100000);

		CsvReaderCustom readerCustom = new CsvReaderCustom();
		List<ProductType> productTypes = readerCustom.readFromFile("CsvData.csv");
	}
}
