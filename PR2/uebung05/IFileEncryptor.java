package uebung05;

import java.io.File;
import java.io.IOException;

public interface IFileEncryptor {

	public File encrypt(File sourceDirectory);
	public File decrypt(File sourceDirectory);
	
}
