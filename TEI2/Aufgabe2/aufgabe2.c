#include <stdio.h>
#include <stdlib.h>

void quadriere(float* x){
  *x = (*x * *x);
}

struct Vector2D{
  float x;
  float y;
};

int main(){
  float f = 17;
  float* fp = &f;
  printf("Wert der Speicherstelle auf die fp zeigt: %f\n",*fp);
  printf("Speicherstelle von f: %p\n", &f);
  printf("Speicherstelle von fp: %p\n", &fp);
  printf("Speicherstelle auf die fp Zeigt: %p\n", fp);

  float* fheap;
  printf("Speicherstelle von fheap: %p\n", fheap);
  fheap = (float *) malloc(sizeof(fheap));
  printf("Speicherstelle nach Allocation: %p\n", fheap);
  *fheap = 5.0;
  printf("Float Wert von fheap: %f\n", *fheap);

  printf("Aufgabe 2:\n");
  quadriere(&f);
  printf("%f\n",f);
  quadriere(fheap);
  printf("%f\n",*fheap);

  printf("Aufgabe 3:\n");
  struct Vector2D Vector1;
  struct Vector2D *Vector2 = malloc(sizeof(*Vector2));
  Vector1.x = 4;
  printf("Der Wert von Vektor 1: %f\n", Vector1.x);
  quadriere(&Vector1.x);
  printf("Der Wert von Vektor 1 nach dem Quadrieren: %f\n", Vector1.x);
  Vector2->x = 4;
  printf("Der Wert von Vektor 2: %f\n", Vector2->x);
  quadriere(&Vector2->x);
  printf("Der Wert von Vektor 2 nach dem Quadrieren: %f\n", Vector2->x);
  return 0;
}
