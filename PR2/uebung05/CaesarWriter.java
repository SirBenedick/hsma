package uebung05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class CaesarWriter extends FilterWriter {
	private char[] ringBuffer = new char[58];
	private int shift;

	public CaesarWriter(int shift, Writer out) {
		super(out);
		this.shift = shift;
		initializeRingBuffer();
		// TODO Auto-generated constructor stub
	}
	
	protected CaesarWriter(Writer out, int shift) {
		super(out);
		this.shift = shift;
		initializeRingBuffer();
		// TODO Auto-generated constructor stub
	}
	
	public CaesarWriter(Writer out){
		this(0,out);
	}

	private void initializeRingBuffer() {
		char c = 'A';
		for (int i = 0; i < ringBuffer.length - 6; i++) {
			ringBuffer[i] = c;
			if (c == 'Z')
				c = 'a';
			else
				c++;
		}
		ringBuffer[ringBuffer.length - 6] = 'Ä';
		ringBuffer[ringBuffer.length - 5] = 'Ö';
		ringBuffer[ringBuffer.length - 4] = 'Ü';
		ringBuffer[ringBuffer.length - 3] = 'ä';
		ringBuffer[ringBuffer.length - 2] = 'ö';
		ringBuffer[ringBuffer.length - 1] = 'ü';
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		cbuf = encodeArray(cbuf);
		super.write(cbuf, off, len);
	}

	@Override
	public void write(char[] cbuf) throws IOException {
		cbuf = encodeArray(cbuf);
		super.write(cbuf, 0, cbuf.length);
	}

	@Override
	public void write(int c) throws IOException {
		c = encodeChar(c);
		super.write(c);
	}

	@Override
	public void write(String str, int off, int len) throws IOException {
		char[] cbuf = str.toCharArray();
		cbuf = encodeArray(cbuf);
		super.write(cbuf, off, len);
	}
	
	@Override
	public void write(String str) throws IOException {
		char[] cbuf = str.toCharArray();
		cbuf = encodeArray(cbuf);
		super.write(cbuf, 0, cbuf.length);
	}
	

	private char[] encodeArray(char[] cbuf) {
		for (int i = 0; i < cbuf.length; i++) {
			int pos = 0;
			for (int j = 0; j < ringBuffer.length; j++) {
				if (cbuf[i] == ringBuffer[j])
					pos = j;
			}
			if (cbuf[i] == ringBuffer[pos])
				cbuf[i] = ringBuffer[Math.floorMod(pos + shift, ringBuffer.length)];
		}
		return cbuf;
	}
	
	private int encodeChar(int c) {
		int pos = 0;
		for (int i = 0; i < ringBuffer.length; i++) {
			if (c == ringBuffer[i])
				pos = i;
		}
		if (c == ringBuffer[pos])
			c = ringBuffer[Math.floorMod(pos + shift, ringBuffer.length)];
		return c;
	}

	public static void main(String[] args) throws IOException {
		File file = new File("uebung5.txt");
		CaesarWriter writer = new CaesarWriter(0, new BufferedWriter(new FileWriter(file)));
		CaesarReader readerC = new CaesarReader(5, new BufferedReader(new FileReader(file)));
		BufferedReader readerB = new BufferedReader(new FileReader("uebung5.txt"));
		char[] cbuf = { '+', ' ', '-', 'M', 'S', '?'};
		String hello = "inj xtqqyj fzhm jshyäuyji xjns";
		cbuf = new char[(int) file.length()];
		writer.write(hello);
		writer.close();
		char[] read = new char[hello.length()];
		readerC.read(read);
		for (int i = 0; i < read.length; i++) {
			System.out.print(read[i]);
		}
		System.out.println();
	}
}
