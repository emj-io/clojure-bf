(ns clj-bf.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [clj-bf.core :refer [interpret]]))

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