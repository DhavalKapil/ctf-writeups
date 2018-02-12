#include <stdint.h>

struct feed {
  char *str;
  uint64_t padding;
  char medicine_name[8];
  char medicine_desc[120];
};

struct animal {
  uint32_t initalized;
  char name[20];
  struct feed *feeds[20];
  char *species;
  char *dungs[25];
  uint32_t likes;
  uint32_t feed_index2;
  uint32_t feed_index;
  uint32_t dung_index2;
  uint32_t dung_index;
  uint32_t is_ill;
  uint32_t feed_flag_ill;
};

struct zoo {
  char name[16];
  struct animal animals[5];
};
