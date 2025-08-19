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

- **Main interpreter loop**: Uses `loop`/`recur` for efficient iteration (core.clj:46-66)
- **Tape operations**: Dynamic memory expansion when moving right past tape boundary
- **Bracket matching**: Recursive functions to find matching `[` and `]` for loop control
- **Duplicate interpret function**: There are two `interpret` functions - the second one (line 45) includes loop support with `[` and `]`

## Brainfuck Commands Supported

- `>` - Move tape pointer right
- `<` - Move tape pointer left  
- `+` - Increment current cell
- `-` - Decrement current cell
- `.` - Output current cell value
- `[` - Jump past matching `]` if current cell is 0
- `]` - Jump back to matching `[` if current cell is not 0

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
- `test/clj_bf/core_test.clj` - Test suite (currently contains placeholder test)
- `project.clj` - Leiningen project configuration

## Current State

The interpreter has a hardcoded "Hello World!" Brainfuck program in `prog_a` variable. The commented code shows intention to read programs from files but is not currently active.