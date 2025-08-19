(ns clj-bf.core-test
  (:require [clojure.test :refer :all]
            [clj-bf.core :refer :all]))

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