(ns clj-bf.core
  (:gen-class))

(defn interpret [code]
	(loop [ip 0 tp 0 tape [0]]
		(condp = (get code ip)
	    	\.    (do
				(println (get tape tp))
				(recur (inc ip) tp tape))
	    	\>	(let [ip+ (inc ip)
	       			tp+ (inc tp)
			   		tape_length (count tape)
			   		tape+ (if (= tape_length tp+) (conj tape 0) tape)]
			  			(recur ip+ tp+ tape+))
			\<   (recur (inc ip) (dec tp) tape)
			\+   (recur (inc ip) tp (assoc tape tp (inc (nth tape tp))))
			\-   (recur (inc ip) tp (assoc tape tp (dec (nth tape tp))))
			nil  tape
			(recur (inc ip) tp tape))))

(defn matching-right-full [code ip bracket-depth]
	(let [bracket-depth-new (+ bracket-depth (condp = (get code ip)
					\[	1
					\]	-1
					0))]
		(if (= 0 bracket-depth-new)
			(inc ip)
			(recur code (inc ip) bracket-depth-new))))

(defn matching-right [code ip] 
	(matching-right-full code (dec ip) 1))

(defn matching-left-full [code ip bracket-depth]
	(let [bracket-depth-new (+ bracket-depth (condp = (get code ip)
					\[	-1
					\]	+1
					0))]
		(if (= 0 bracket-depth-new)
			(inc ip)
			(recur code (dec ip) bracket-depth-new))))

(defn matching-left [code ip] 
	(matching-left-full code (dec ip) 1))

(defn interpret [code]
	(loop [ip 0 tp 0 tape [0]]
		(condp = (get code ip)
			\[	(if (= 0 (get tape tp))
					(recur (matching-right code ip) tp tape)
					(recur (inc ip) tp tape))
			\]	(if (= 0 (get tape tp))
					(recur (inc ip) tp tape)
					(recur (matching-left code ip) tp tape))
	    	\.  (do
					(println (get tape tp))
					(recur (inc ip) tp tape))
	    	\>	(let [ip+ (inc ip)
	       			tp+ (inc tp)
			   		tape_length (count tape)
			   		tape+ (if (= tape_length tp+) (conj tape 0) tape)]
			  			(recur ip+ tp+ tape+))
			\<   (recur (inc ip) (dec tp) tape)
			\+   (recur (inc ip) tp (assoc tape tp (inc (nth tape tp))))
			\-   (recur (inc ip) tp (assoc tape tp (dec (nth tape tp))))
			nil  tape
			(recur (inc ip) tp tape))))

;;(def prog_a "+++[>+<-]")
(def prog_a "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.")
(defn -main [& args]
      (println (interpret prog_a)))

;; Read from file
;;  (if (nth args 0)
;;    (interpreter (slurp (nth args 0)))
;;    (println "usage: clojure-bf filename")))

