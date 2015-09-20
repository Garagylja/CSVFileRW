package CsvInterfaces;

import CsvClasses.ProductType;

import java.util.List;

/**
 * Created by user on 15.09.2015.
 */
public interface CsvReader {

	List<ProductType> readFromFile (String fileName);
}
