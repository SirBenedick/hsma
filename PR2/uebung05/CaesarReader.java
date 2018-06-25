package uebung05;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends FilterReader{

	private char[] ringBuffer = new char[58];
	private int shift = 0;
	
	public CaesarReader(int shift,Reader in) {
		super(in);
		this.shift = shift;
		initializeRingBuffer();
	}
	
	public CaesarReader(Reader in, int shift) {
		super(in);
		this.shift = shift;
		initializeRingBuffer();
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

	public CaesarReader(Reader in){
		this(0,in);
	}
	
	@Override
	public int read() throws IOException {
		int c = super.read();
		c = decodeChar(c);
		return c;
	}
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int length = super.read(cbuf, off, len);
		decodeArray(cbuf);
		return length;
	}
	
	@Override
	public int read(char[] cbuf) throws IOException {
		int length = super.read(cbuf, 0, cbuf.length);
		cbuf = decodeArray(cbuf);
		return length;
	}

	private int decodeChar(int c) {
		int pos = 0;
		for (int i = 0; i < ringBuffer.length; i++) {
			if (c == ringBuffer[i])
				pos = i;
		}
		if (c == ringBuffer[pos])
			c = ringBuffer[Math.floorMod(pos - shift, ringBuffer.length)];
		return c;
	}
	
	private char[] decodeArray(char[] cbuf){
		for (int i = 0; i < cbuf.length; i++) {
			int pos = 0;
			for (int j = 0; j < ringBuffer.length; j++) {
				if (cbuf[i] == ringBuffer[j])
					pos = j;
			}
			if (cbuf[i] == ringBuffer[pos])
				cbuf[i] = ringBuffer[Math.floorMod(pos - shift, ringBuffer.length)];
		}
		return cbuf;
	}
}
