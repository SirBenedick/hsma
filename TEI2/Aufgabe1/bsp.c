#include <stdio.h>
#include "func.h"
#include <math.h>
#define PYTHAGORAS(a, b) sqrt(((a)*(a))+((b)*(b)))

/*
ZU 3.
gcc -c bsp.c
gcc -c func.c
gcc -o hello bsp.o func.o (-lm beim Linken unter Windows mit minGW nich benötigt)
*/

int  globalfunction(int x, int y)
{
  int z;
  printf("x=%d y=%d z=%d\n",x, y, z);
  z=x-y;
}

int  globalfunction2()
{
  unsigned int sth;
  printf("sth=%u\n",sth);
}

union Aufgabe6{
  int b;
  unsigned char ausgabeArray[4];
};

int main()
{
  int i= 111111;
  int j=-222222;
  unsigned int k=3333333333;

  char myString[] = "C";
  printf("Hallo %s!\n", myString);
  printf("Die ganze Zahl %d mit Vorzeichen %+d und als hex %x und %X.\n", i,i,i,i);
  printf("Die ganze Zahl %d mit Vorzeichen %+d und als hex %x und %X.\n", j,j,j,j);

  printf("Die Variable k: %d und nochmal k: %u.\n", k,k);

  globalfunction2();
  globalfunction(1,2);
  globalfunction(1,2);
  globalfunction2();

  printf("%f\n", drittewurzel(27));
  printf("%f\n", PYTHAGORAS(3,4));
  printf("%f\n", PYTHAGORAS((1+3),(2+1)));
  
//Der Befehl gcc -E bsp.c führt nur den Präprozessor aus und gibt dessen Ausgabe an.

  union Aufgabe6 aufgabe6;
  aufgabe6.b = 0xbaadf00d;
  for(int i=0; i<4; i++){
    printf("%x", aufgabe6.ausgabeArray[i]);
  }
  /*
  Ausgabe:
  df0adba
  das hinterste Byte steht in der ersten Adresse,
  es handelt sich darum um ein Littleendian system
  */
  return 0;
}
