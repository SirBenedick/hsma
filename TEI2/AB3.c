#include<stdio.h>
#include"wave.h"

float* schneller(float* data, int n) {
	float* spedup_data = (float*)malloc(sizeof(float)*n);
	for (int i = 0; i < n / 2; i = i++) {
		spedup_data[i] = data[2 * i];
	}
	free(data);
	return spedup_data;
}

float* readDataChunks(int* n) {
	chunkheader header[1];
	FILE* wav_file;
	float* data;
	int fileSizeInBytes;
	if ((wav_file = fopen("test.wav", "rb")) == NULL)
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
//Not needed
void readSubChunks() {
	chunkheader header;
	FILE* f1;
	int fileSizeInBytes;
	printf("Die Subchunks:");
	if ((f1 = fopen("test.wav", "rb")) == NULL)
		printf("Die Datei konnte nicht gefunden werden");
	fseek(f1, 0L, SEEK_END);
	fileSizeInBytes = ftell(f1);

	fseek(f1, 12 - fileSizeInBytes, 1);
	printf("Position in Datei: %i", ftell(f1));

	do {
		if (fread(&header, sizeof(chunkheader), 1, f1) < 1 && !feof(f1))
			printf("Konnte Datei Header nicht lesen!");
		printf("\nDateiposition %i\n", ftell(f1));
		printf("%c", header.chunk_id[0]);
		printf("%c", header.chunk_id[1]);
		printf("%c", header.chunk_id[2]);
		printf("%c", header.chunk_id[3]);
		printf("\nDeiteiposition: %i\n", ftell(f1));
		printf(" Groesse %i\n", header.chunk_size);

		fseek(f1, header.chunk_size + 8, 1);
		printf("\nDateiposition: %i\n", ftell(f1));

		if (feof(f1))
			printf("END OF FILE");
	} while (ftell(f1) != fileSizeInBytes);

	fclose(f1);
}



int main() {
	//char *p1;
	FILE *f1;
	wavheader wav;

	f1 = fopen("C:/Users/Alex/Documents/Dokumente Hochschule/TEI2/Aufgabe 3/test.wav", "rb");
	fread(&wav, sizeof(wavheader), 1, f1);
	printf("ChunkID: ");
	for (int i = 0; i < 4; i++) {
		printf("%c", wav.riff_chunk_header.chunk_id[i]);
	}
	printf("\nFileSize: %i Bytes laut explorer ist die Datei 52.836B gross. Also 8B groesser.", wav.riff_chunk_header.chunk_size);
	printf("\nfmt Chunk Size : %i", wav.fmt_chunk_header.chunk_size);
	printf("\nFormat: %i, Damit also IEEE float Format", wav.format_type);
	printf("\nAnzahl der Audio Kaneaele: %i, also Mono", wav.channels);
	int sample_rate = wav.sample_rate;
	int bits_per_sample = wav.bits_per_sample;
	printf("\nBlock Abtast Rate/s: %i", sample_rate);
	float laenge = ((float)wav.riff_chunk_header.chunk_size / (float)wav.byterate);
	printf("\nDie Datei ist %f Sekunden lang, dies entspricht der Laenge laut MediaPlayer", laenge);

	//readSubChunks();
	float* data;
	int amount;
	data = readDataChunks(&amount);
	printf("\nDaten: %i\n", amount);
	data = schneller(data, amount);
	char name[] = "schneller.wav";
	writePCM(name, data, amount, wav);
}