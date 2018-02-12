void feed_animal(zoo *z) {
  int animal_idx = get_index_by_name(z);
  return if animal_idx < 0 || > 4;
  a = z->animals[animal_idx];
  int dung_diff = 0;
  int feed_idx = a->feed_index;
  if (a->feeds[feed_idx]) {
    puts("cannot feed more");
  } else {
    feed = a->feeds[feed_idx] = malloc(0x80);
    memset(feed, 0, 0x80);
    if (a->feed_flag_ill) {
      feed->str = offset_of_"Medicine";
      feed->w2 = animals[animal_idx + 1]->dung_index2;
      read(feed->medicine, 8);
      read(feed->med_desc, 120); // Overflow
    } else {
      feed->str = offset_of_"Food";
      puts("Your animal ate a food");
    }
    a->feed_index = (a->feed_index + 1) % 20;
    int diff = (a->feed_index - a->feed_index2 + 20) % 20;
    if (diff == 0 && a->feed[0]) {
      diff = 20;
    }
    if (!a->feed_flag_ill && diff > 4 && is_odd(diff)) {
      int dung_index = a->dung_index;
      if (a->dungs[dung_index]) {
        puts("Clean dung");
        return;
      }
      dung = a->dungs[dung_index] = malloc(0x80);
      memset(dung, 0, 0x80);
      a->dung_index = (a->dung_index + 1) % 25;
      dung_diff = (a->dung_index - a->dung_index2 + 25 % 25);
      if (dung_diff==0 && a->dungs[0]) {
        dung_diff = 20;
      }
    }
    if (dung_duff > 4) {
      a->is_ill = 1;
      puts("Your animal is ill");
    }
  }
}

void clean_animal(zoo *z) {
  animal_idx = get_index_by_name();
  // check animal_idx
  int dung_index2 = a->dung_index2;
  if (a->dungs[dung_index2]) {
    free(a->dungs[dung_index2]);
    a->dungs[dung_index2] = 0;
    a->dungs_index2 = (a->dungs_index2 + 1) % 25;
    if (dung_diff==0) {
      dung_diff = 20;
    }
    printf("Good job");
  } else {
    puts("You don't have to clean dung");
  }
}

void walk(zoo *z) {
  get_index_by_name();
  // check animal index
  int feed_index2 = a->feed_index2;
  if (a->feeds[feed_index2]) {
    free(a->feeds[feed_index2]);
    a->feeds[feed_index2] = 0;
    // increment feed_index2
    if (feed_diff==0) {
      feed_diff = 20;
    }
    if (++a->likes > 14) {
      for(int i = 0;i<=19;i++) {
        if (a->feeds[i] &&
            a->feeds[i]->str != "Medicine" || "Food") { // offset
          puts("Animal is happy\n");
          read(0, a->feeds[i]->medicine_desc, 120); // overflow
        }
      }
    }
  } else {
    puts("doesn't need walk");
  }
}

void take_hospital(zoo *z) {
  // get and check index
  if (a->is_ill) {
    for(int i = 0;i<4;i++) {
      int dung_index2 = a->dung_index2;
      if (!a->dungs[dung_index2]) {
        break;
      }
      free(a->dungs[dung_index2]);
      a->dungs[dung_index2] = 0;
      // increment dung_index2
    }
    int dung_diff;
    if (dung_diff==0 && a->dungs[0]) {
      dung_diff = 20;
    }
    if (dung_diff > 4) {
      a->feed_flag_ill = 1;
      printf("take medicine\n");
    } else {
      a->is_ill = 0;
    }
  } else {
    puts("Not ill");
  }
}
