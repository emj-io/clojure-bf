# Brainfuck Example Programs

This directory contains sample Brainfuck programs to test the interpreter.

## Running Examples

```bash
# Command line (recommended - file input functionality)
lein run examples/simple_hello.bf
lein run examples/simple_addition.bf
lein run examples/simple_copy.bf

# Using standalone JAR
lein uberjar
java -jar target/uberjar/clj-bf-*-standalone.jar examples/simple_hello.bf

# Using Clojure REPL
lein repl
(require '[clj-bf.core :refer [interpret]])
(interpret (slurp "examples/simple_hello.bf"))
```

## Tested Programs

| File | Description | Command | Expected Output |
|------|-------------|---------|-----------------|
| `simple_hello.bf` | Hello World program | `lein run examples/simple_hello.bf` | "Hello World!" (ASCII 72,101,108...) |
| `simple_addition.bf` | Add 3+2=5 | `lein run examples/simple_addition.bf` | Number 5 |
| `simple_copy.bf` | Copy value demo | `lein run examples/simple_copy.bf` | Number 3 |

## Additional Programs (with comments)

| File | Description | Notes |
|------|-------------|--------|
| `hello_world.bf` | Commented Hello World | Contains explanatory comments |
| `addition.bf` | Commented addition | Contains explanatory comments |
| `copy_value.bf` | Commented copy demo | Contains explanatory comments |
| `counter.bf` | Counter with comments | Contains explanatory comments |
| `multiplication.bf` | Multiplication demo | Contains explanatory comments |
| `nested_loops.bf` | Nested loops test | Contains explanatory comments |
| `memory_test.bf` | Memory expansion test | Contains explanatory comments |

## Notes

- **simple_*.bf** files contain only Brainfuck code (tested and working)
- **other .bf** files contain comments and may need comment stripping
- Programs output numeric values as integers
- Hello World outputs ASCII values that represent "Hello World!" text
- All examples are tested with the interpreter's file input functionality