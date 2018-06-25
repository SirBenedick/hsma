package uebung05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureBaseRSA.SignatureRSARIPEMD160;

public class CaesarFileEncryptor implements IFileEncryptor {

	int shift = 0;

	public CaesarFileEncryptor(int shift) {
		this.shift = shift;
	}

	@Override
	public File encrypt(File sourceDirectory) {
		File[] files = sourceDirectory.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				String name = pathname.getName().toLowerCase();
				return name.endsWith(".txt") && pathname.isFile();
			}
		});

		String[] folders = sourceDirectory.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isDirectory();
			}
		});
		if (folders.length != 0) {
			System.out.println("The follwing directories are in " + sourceDirectory.getName() + ":");
			System.out.print(Arrays.toString(folders));
			
		}

		int count = 0;
		for (int i = 0; i < folders.length; i++) {
			if (folders[i].equals(sourceDirectory.getName() + "_encrypted")) {
				count = 1;
			} else if (folders[i].contains(sourceDirectory.getName() + "_encrypted(" + count + ")")) {
				count++;
			} else if (!folders[i].contains(sourceDirectory.getName() + "_encrypted")) {
				encrypt(new File(sourceDirectory.getPath() + File.separator + folders[i]));
			}
		}

		File target = null;
		for (int i = 0; i < files.length; i++) {
			FileInputStream fis;
			if (count == 0)
				target = new File(sourceDirectory.getPath() + File.separator + sourceDirectory.getName() + "_encrypted"
						+ File.separator + files[i].getName());
			else
				target = new File(sourceDirectory.getPath() + File.separator + sourceDirectory.getName() + "_encrypted("
						+ count + ")" + File.separator + files[i].getName());

			target.getParentFile().mkdirs();
			try {
				CaesarWriter writer = new CaesarWriter(shift, new BufferedWriter(new FileWriter(target)));
				fis = new FileInputStream(files[i]);
				byte[] data = new byte[(int) files[i].length()];
				fis.read(data);
				fis.close();
				String str = new String(data);
				writer.write(str);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return target;
	}

	@Override
	public File decrypt(File sourceDirectory) {
		File[] files = sourceDirectory.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				String name = pathname.getName().toLowerCase();
				return name.endsWith(".txt") && pathname.isFile();
			}
		});

		String[] folders = sourceDirectory.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isDirectory();
			}
		});
		if (folders.length != 0) {
			System.out.println("The follwing directories are in " + sourceDirectory.getName() + ":");
			System.out.println(Arrays.toString(folders));
		}

		int count = 0;
		for (int i = 0; i < folders.length; i++) {
			if (folders[i].equals(sourceDirectory.getName() + "_decrypted")) {
				count = 1;
			} else if (folders[i].contains(sourceDirectory.getName() + "_decrypted(" + count + ")")) {
				count++;
			} else if (!folders[i].contains(sourceDirectory.getName() + "_decrypted")) {
				decrypt(new File(sourceDirectory.getPath() + File.separator + folders[i]));
			}
		}

		File target = null;
		for (int i = 0; i < files.length; i++) {
			if (count == 0)
				target = new File(sourceDirectory.getPath() + File.separator + sourceDirectory.getName() + "_decrypted"
						+ File.separator + files[i].getName());
			else
				target = new File(sourceDirectory.getPath() + File.separator + sourceDirectory.getName() + "_decrypted("
						+ count + ")" + File.separator + files[i].getName());
			target.getParentFile().mkdirs();
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(target));
				CaesarReader reader = new CaesarReader(shift, new BufferedReader(new FileReader(files[i])));
				char[] data = new char[(int) files[i].length()];
				reader.read(data);
				reader.close();
				String str = new String(data);
				writer.write(str);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return target;
	}

	public static void main(String[] args) {
		int choice;
		Scanner input = new Scanner(System.in);
		int exit = 1;
		do {
			do {
				System.out.println("Would you like to encode(1) or decode(2)?");
				choice = Integer.parseInt(input.nextLine());
			} while (choice < 1 || choice > 3);
			System.out.println("By which amount would you like to shift?");
			CaesarFileEncryptor encryptor = new CaesarFileEncryptor(Integer.parseInt(input.nextLine()));
			System.out.println("Input your source directory:");
			File sourceDirectory = new File(input.nextLine());
			if (choice == 1)
				encryptor.encrypt(sourceDirectory);
			else if (choice == 2)
				encryptor.decrypt(sourceDirectory);
			System.out.println("");
			System.out.println("Done!");
			System.out.println("Do you want to do another operation(1) or not (0)?");
			exit = Integer.parseInt(input.nextLine());
		} while (exit == 1);
	}
}
