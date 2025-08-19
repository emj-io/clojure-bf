# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Brainfuck interpreter implementation in Clojure. The project interprets Brainfuck programs, which use 8 basic commands to manipulate a memory tape and instruction pointer.

## Architecture

- **Core namespace**: `clj-bf.core` contains the main interpreter logic
- **Interpreter function**: `interpret` processes Brainfuck code character by character
- **Memory model**: Uses a vector-based tape that expands as needed
- **Control flow**: Implements bracket matching for loops with `matching-left` and `matching-right` functions

### Key Components

- **Main interpreter loop**: Uses `loop`/`recur` for efficient iteration (core.clj:33-62)
- **Tape operations**: Dynamic memory expansion when moving right past tape boundary
- **Bracket matching**: Recursive functions to find matching `[` and `]` for loop control with proper bounds checking
- **Error handling**: Graceful handling of unmatched brackets and edge cases

## Brainfuck Commands Supported

- `>` - Move tape pointer right
- `<` - Move tape pointer left  
- `+` - Increment current cell
- `-` - Decrement current cell
- `.` - Output current cell value
- `[` - Jump past matching `]` if current cell is 0
- `]` - Jump back to matching `[` if current cell is not 0

## Sample Brainfuck Programs for Testing

```clojure
;; 1. Hello World - Classic program
"++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++."

;; 2. Simple counter (outputs 0,1,2)
"+++++++++[>++++++++<-]>.<+.>+."

;; 3. Fibonacci sequence (first few numbers)
">++++++++++>+>+[[+++++[>++++++++<-]>.<++++++[>--------<-]+<<<]>.>>[[-]<[>+<-]<[>+<-]<[>+<-]>>>]<]"

;; 4. Cell value copy
"+++[>+<-]>."

;; 5. Multiplication (2*3=6) 
"++>+++[<[>+>+<<-]>[<+>-]>>[-]<<-]>>."

;; 6. ASCII art triangle
"++++++++++[>+>+++<<-]>++>+>++++++[>++++++++++<<-]>>-->++++++[>+++++++++++<<-]>>+>++++[>+++++++++++<<-]>>+>+++++[>++++++++++<<-]>>+>.>+.>+.>."

;; 7. Simple addition (3+2=5)
"+++>++[<+>-]<."

;; 8. Print alphabet (A-Z)
"++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.>++.>+++.>++++.>+++++."

;; 9. Nested loops test
"+++[>+++[>+++<-]<-]>>."

;; 10. Memory expansion test (use cells far apart)
">>>>>>>>>>>>>>>>>>>>>+."
```

## Development Commands

This project uses Leiningen for build management. Standard commands:

```bash
lein run                    # Run the main function with hardcoded program
lein test                   # Run tests
lein uberjar               # Build standalone JAR
java -jar target/uberjar/clj-bf-*-standalone.jar  # Run compiled JAR
```

## Project Structure

- `src/clj_bf/core.clj` - Main interpreter implementation
- `test/clj_bf/core_test.clj` - Comprehensive test suite
- `project.clj` - Leiningen project configuration

## Current State

The interpreter is fully functional with comprehensive test coverage (9 test functions, 21 assertions) covering all Brainfuck operations including loops, edge cases, and memory expansion. Includes CI/CD pipeline with automated testing and linting. The main function runs a hardcoded "Hello World!" program.