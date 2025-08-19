(ns clj-bf.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [clj-bf.core :refer [interpret matching-right matching-left]]))

(defn capture-output [f]
  (let [out (java.io.StringWriter.)]
    (binding [*out* out]
      (f)
      (str out))))

(deftest test-basic-operations
  (testing "empty program"
    (is (= [0] (interpret ""))))
  
  (testing "increment operation"
    (is (= [3] (interpret "+++"))))
  
  (testing "move right"
    (is (= [0 0] (interpret ">"))))
  
  (testing "move and increment"
    (is (= [0 2] (interpret ">++")))))

(deftest test-output
  (testing "simple output"
    (is (= "3\n" (capture-output #(interpret "+++."))))))

(deftest test-decrement-operations
  (testing "basic decrement"
    (is (= [-1] (interpret "-"))))
  
  (testing "increment then decrement"
    (is (= [1] (interpret "+++--")))))

(deftest test-move-left
  (testing "move left from position 0 stays at 0"
    (is (= [5] (interpret "+++++<"))))
  
  (testing "move right then left"
    (is (= [3 0] (interpret "+++><")))))

(deftest test-edge-cases
  (testing "process valid chars only"
    (is (= [4] (interpret "++x+y+"))))
  
  (testing "only invalid characters"
    (is (= [0] (interpret "xyz")))))

(deftest test-memory-expansion
  (testing "expanding memory with multiple moves"
    (is (= [0 0 0 0 1] (interpret ">>>>+")))))

(deftest test-bracket-matching
  (testing "matching-right finds closing bracket"
    (is (= 5 (matching-right "++[++]+" 2))))
  
  (testing "matching-left finds opening bracket" 
    (is (= 2 (matching-left "++[++]+" 5))))
  
  (testing "unmatched brackets return nil"
    (is (= nil (matching-right "++[++" 2)))
    (is (= nil (matching-left "++]+" 2)))))

(deftest test-simple-loops
  (testing "empty loop is skipped"
    (is (= [0] (interpret "[+++]"))))
  
  (testing "simple copy loop"
    (is (= [0 3] (interpret "+++[>+<-]"))))
  
  (testing "nested loops"
    (is (= [0 0 6] (interpret "+++[>++[>+<-]<-]")))))

(deftest test-hello-world
  (testing "Hello World program executes without errors"
    (let [hello-world "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++."
          result (interpret hello-world)]
      (is (vector? result))
      (is (> (count result) 0)))))

(deftest test-file-input
  (testing "interpreter works with file input"
    (let [result (interpret (slurp "examples/simple_copy.bf"))]
      (is (= [0 3] result))))
  
  (testing "simple addition from file"
    (let [result (interpret (slurp "examples/simple_addition.bf"))]
      (is (= [5 0] result))))
  
  (testing "hello world from file produces output"
    (let [output (capture-output #(interpret (slurp "examples/simple_hello.bf")))]
      (is (> (count output) 0))
      (is (.contains output "72")))))