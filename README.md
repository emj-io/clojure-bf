# clj-bf

A Brainfuck interpreter implemented in Clojure.

## Overview

Brainfuck is an esoteric programming language with only 8 commands that operates on a memory tape. This interpreter provides a complete implementation supporting all Brainfuck operations including loops, memory expansion, and robust error handling.

## Features

- ✅ **Complete Brainfuck support** - All 8 commands implemented
- ✅ **Loop functionality** - Proper bracket matching with nested loop support  
- ✅ **Dynamic memory** - Automatic tape expansion as needed
- ✅ **Error handling** - Graceful handling of unmatched brackets and edge cases
- ✅ **Comprehensive tests** - 21 test assertions covering all functionality
- ✅ **CI/CD pipeline** - Automated testing and linting on every commit

## Installation

### Prerequisites

- Java 8 or higher
- [Leiningen](https://leiningen.org/) for development

### Setup

```bash
git clone https://github.com/emj-io/clojure-bf.git
cd clojure-bf
lein deps
```

## Usage

### Run the Hello World program

```bash
# Run built-in Hello World program
lein run

# Run Hello World from file
lein run examples/simple_hello.bf
```

### Build standalone JAR

```bash
lein uberjar
java -jar target/uberjar/clj-bf-*-standalone.jar
```

### Run example programs

```bash
# Run from files (recommended)
lein run examples/simple_hello.bf     # Hello World
lein run examples/simple_addition.bf  # 3+2=5  
lein run examples/simple_copy.bf      # Copy value demo

# Run with JAR
java -jar target/uberjar/clj-bf-*-standalone.jar examples/simple_hello.bf
```

### Interactive use

```clojure
(require '[clj-bf.core :refer [interpret]])

;; Simple increment and output
(interpret "+++.")  ; Outputs: 3

;; Load from file
(interpret (slurp "examples/simple_hello.bf"))  ; Hello World
```

## Brainfuck Language Reference

| Command | Description |
|---------|-------------|
| `>` | Move tape pointer right |
| `<` | Move tape pointer left |
| `+` | Increment current cell |
| `-` | Decrement current cell |
| `.` | Output current cell value |
| `[` | Jump past matching `]` if current cell is 0 |
| `]` | Jump back to matching `[` if current cell is not 0 |

### Example Programs

The `examples/` directory contains sample Brainfuck programs:

```bash
# Command line usage (recommended)
lein run examples/simple_hello.bf      # Hello World → "Hello World!"
lein run examples/simple_addition.bf   # 3+2=5 → outputs: 5
lein run examples/simple_copy.bf       # Copy demo → outputs: 3

# REPL usage  
(interpret (slurp "examples/simple_hello.bf"))     # Hello World
(interpret (slurp "examples/simple_addition.bf"))  # Addition
```

**Tested Examples:**
- `simple_hello.bf` - Hello World program (outputs ASCII text)
- `simple_addition.bf` - Addition (3+2=5, outputs: 5)  
- `simple_copy.bf` - Value copy demo (outputs: 3)

See `examples/README.md` for additional programs and descriptions.

## Development

### Running tests

```bash
lein test
```

### Linting

```bash
clj-kondo --lint src test
```

### CI/CD

The project includes GitHub Actions workflow that automatically:
- Runs all tests
- Performs linting checks  
- Validates on Java 11
- Triggers on push/PR to master

## Architecture

- **Core interpreter**: `src/clj_bf/core.clj` - Main execution engine
- **Bracket matching**: Recursive functions for loop control
- **Memory model**: Vector-based tape with dynamic expansion
- **Test suite**: `test/clj_bf/core_test.clj` - Comprehensive coverage

## Contributing

1. Fork the repository
2. Create a feature branch
3. Add tests for new functionality
4. Ensure all tests pass: `lein test`
5. Ensure linting passes: `clj-kondo --lint src test`
6. Submit a pull request

## License

Copyright © 2015

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.