#include <stdio.h>
#include <stdlib.h>

void func() {
  register int esp asm("esp");
  if ((esp >= (0x1000000 + 0x200000)) &&
      (esp <= (0x1000000 + 0x200100)) ) {
    asm("mov $1, %eax");
    asm("int $0x80");
  }
}

int main() {
  func();
  return 0;
}
