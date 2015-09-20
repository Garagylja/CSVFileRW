package CsvInterfaces;

/**
 * Created by user on 15.09.2015.
 */

import CsvClasses.ProductType;

import java.io.FileNotFoundException;
import java.util.List;

public interface CsvWriter {

	void writeProductListToSCV (String destinationFileName, List<ProductType> newData, boolean appendToFile) throws FileNotFoundException;

	void writeToSCVRandomData (String destinationFileName, int lineValue);


}
