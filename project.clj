(defproject clj-bf "0.1.0-SNAPSHOT"
  :description "A Brainfuck interpreter implemented in Clojure"
  :url "https://github.com/emj-io/clojure-bf"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :plugins [[jonase/eastwood "0.2.3"]]
  :main ^:skip-aot clj-bf.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
