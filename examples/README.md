# Brainfuck Example Programs

This directory contains sample Brainfuck programs to test the interpreter.

## Running Examples

```bash
# Using Clojure REPL
lein repl
(require '[clj-bf.core :refer [interpret]])
(interpret (slurp "examples/hello_world.bf"))

# Or modify src/clj_bf/core.clj to read from file:
# (def prog_a (slurp "examples/hello_world.bf"))
# lein run
```

## Programs

| File | Description | Expected Output |
|------|-------------|-----------------|
| `hello_world.bf` | Classic Hello World program | "Hello World!" |
| `counter.bf` | Outputs ASCII values 0,1,2 | Numbers 0,1,2 |
| `copy_value.bf` | Copy value 3 to next cell | Number 3 |
| `addition.bf` | Add 3+2 | Number 5 |
| `multiplication.bf` | Multiply 2*3 | Number 6 |
| `nested_loops.bf` | Test nested loop functionality | Number 27 |
| `memory_test.bf` | Test memory expansion | Number 1 |

## Notes

- Programs output numeric values, not ASCII characters (except Hello World)
- To see ASCII output, use programs that generate values 32-126
- The interpreter handles all edge cases including unmatched brackets