#include<stdio.h>
#include"wave.h"
#include<stdlib.h>
#include<math.h>
#define M_PI 3.1415926535897932384626433832795028841971

float calulateAverage(float* values, int n) {
	float sum = 0;
	for (int i = 0; i < n; i++) {
		sum = sum + fabs(values[i]);
	}
	return sum / n;
}

float* readDataChunks(int* n) {
	chunkheader header[1];
	FILE* wav_file;
	float* data;
	int fileSizeInBytes;
	if ((wav_file = fopen("C:/Users/Alex/Documents/Dokumente Hochschule/TEI2/Aufgabe 4/test.wav", "rb")) == NULL)
		printf("File not found!");
	fseek(wav_file, 0L, SEEK_END);
	fileSizeInBytes = ftell(wav_file);

	fseek(wav_file, 12 - fileSizeInBytes, 1);
	do {
		if (fread(header, sizeof(chunkheader), 1, wav_file) < 1 && !feof(wav_file))
			printf("Could not read header!");

		if (header->chunk_id[0] == 'd' && header->chunk_id[1] == 'a' && header->chunk_id[2] == 't' && header->chunk_id[3] == 'a') {
			data = (float*)malloc(header->chunk_size);
			fread(data, header->chunk_size, 1, wav_file);
			*n = header->chunk_size / sizeof(float);
			return data;
		}

		fseek(wav_file, header->chunk_size, 1);
		if (feof(wav_file))
			printf("END OF FILE");
	} while (ftell(wav_file) != fileSizeInBytes);
	printf("NO DATA FOUND");
	fclose(wav_file);
	return NULL;
}

float* sinusSignal(int N,float f,float a,int r) {
	float* values;
	values = (float*)malloc(N * sizeof(float));
	for (int i = 0; i < N; i++) {
		values[i] = a * sin(f * 2 * M_PI * i / r);
	}
	return values;
}

int main() {
	FILE* f1;
	wavheader wav;
	f1 = fopen("C:/Users/Alex/Documents/Dokumente Hochschule/TEI2/Aufgabe 4/test.wav", "rb");
	fread(&wav, sizeof(wavheader), 1, f1);
	int amount;
	float* data;
	data = readDataChunks(&amount);
	float average = calulateAverage(data, amount); //Die Funktion liefert 0.049511 als Ergebnis

	float* sinus = sinusSignal(amount, 1600, average, wav.sample_rate);
	writePCM("sinus1600Hz.wav", sinus, 1600, wav);
	float* sinus7600 = sinusSignal(amount, 7600, average, wav.sample_rate);
	writePCM("sinus7600Hz.wav", sinus7600, 1600, wav);
	//Der entstandene Ton hört sich tiefer als der vorherige an, das liegt daran, dass die Abtastrate
	// nicht 2 mal größer als die Frequenz ist und daher wird der Ton nicht korrekt ausgegeben, denn normalerweise hören sich Töne mit
	// höheren frequenzen auch höher an. (Abtasttheorem)
	float* mixed = malloc(sizeof(float) * amount);
	for (int i = 0; i < amount; i++) {
		mixed[i] = (data[i] + sinus[i]) / 2;
	}
	writePCM("mixed.wav", mixed, amount, wav);	
}