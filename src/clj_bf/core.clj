(ns clj-bf.core
  (:gen-class))

(defn interpret [code]
    (loop [ip 0, tp 0, tape [0]]
	(condp = (get code ip)
	       \.    (do
			(println (get tape tp))
			(recur (inc ip) tp tape))
	       \>    (let [ip+ (inc ip)
	       	     	   tp+ (inc tp)
			   tape_length (count tape)
			   tape+ (if (= tape_length tp+) (conj tape 0) tape)]
			  (recur ip+ tp+ tape+))
	       \<    (recur (inc ip) (dec tp) tape)
	       \+    (recur (inc ip) tp (assoc tape tp (inc (nth tape tp))))
	       \-    (recur (inc ip) tp (assoc tape tp (dec (nth tape tp))))
	       nil   tape
       	       (recur (inc ip) tp tape))))

(def prog_a "+>++>+++<+<++")

(defn -main [& args]
      (interpret prog_a))

;; Read from file
;;  (if (nth args 0)
;;    (interpreter (slurp (nth args 0)))
;;    (println "usage: clojure-bf filename")))

