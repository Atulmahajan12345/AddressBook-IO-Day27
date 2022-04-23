package com.blz.addressbook;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookMain {
	public static String address_DATA_FILE_PATH = "emp-payroll-data.txt";

	public void writeAddressBookDataData(List<AddressBook> addressBookList) {

		StringBuffer addBookBuffer = new StringBuffer();
		addressBookList.forEach(ab -> {
			addBookBuffer .append(ab + "\n");
		});
		try {
			Files.write(Paths.get(address_DATA_FILE_PATH ), addBookBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public long countLines() {
		long count = 0;
		try {
			count = Files.lines(Paths.get(address_DATA_FILE_PATH )).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void readEmpPayrollData() {
		System.out.println("Reading address book data from the file");
		try {
			Files.lines(Paths.get(address_DATA_FILE_PATH )).map(line -> line.trim()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Contact> getAddressBookData() {
		System.out.println("Storing Emp Payroll data from the file to obj");
		List<Contact> addressDataFromFile = new ArrayList<>();
		try {
			Files.lines(Paths.get(address_DATA_FILE_PATH )).map(line -> {
				line.split(",")[0].split("=");
				line.split(",")[1].split("=");
				line.split(",")[2].split("=");
				line.split(",")[3].split("=");
				line.split(",")[4].split("=");
				Integer.parseInt(line.split(",")[5].split("=")[1]);
				line.split(",")[6].split("=");

				Contact ab = new Contact();
				return ab;
			}).forEach(ab -> addressDataFromFile.add(ab));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return addressDataFromFile;
	}
}