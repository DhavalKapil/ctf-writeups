import gdb

last_size = None
malloc_map = {}

def ExprAsInt(expr):
    return int(str(gdb.parse_and_eval("(void*)(%s)" % expr)).split(" ")[0], 16)

class MallocFinishBreakpoint(gdb.FinishBreakpoint):
    def __init__ (self):
        gdb.FinishBreakpoint.__init__(
            self,
            gdb.newest_frame(),
            internal=True,
        )
        self.silent = True

    def stop(self):
        where = ExprAsInt('$rax')
        print("0x%.8x <---- malloc of 0x%x bytes" % (where, last_size))

        if where in malloc_map:
            print("[!] where already in malloc map")
        malloc_map[where] = last_size

        return False

class MallocBreakpoint(gdb.Breakpoint):
    def __init__(self):
        gdb.Breakpoint.__init__(self, 'malloc', internal=True)
        self.silent = True

    def stop(self):
        global last_size
        last_size = ExprAsInt('$rdi')
        MallocFinishBreakpoint()

        return False

class FreeBreakpoint(gdb.Breakpoint):
    def __init__ (self):
        gdb.Breakpoint.__init__(self, 'free', internal=True)
        self.silent = True

    def stop(self):
        where = ExprAsInt('$rdi')
        if where in malloc_map:
            print("0x%.8x <---- free of 0x%x bytes" % (where, malloc_map[where]))
            del malloc_map[where]
        else:
            print("0x%.8x <---- free (not in malloc map?!)" % where)

MallocBreakpoint()
FreeBreakpoint()
