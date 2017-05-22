(ns hangman.hangman)

(defn create-word [] "alabala")

(defn error-count [not-guessed letter error]
  (if (contains? not-guessed letter)
    error
    (dec error)))

(defn print-wildcarded [word not-guessed]
  (doseq [w word]
    (if (contains? not-guessed w)
      (print "?")
      (print w)))
  (print "\n"))

(defn read-letter []
  (println "Your guess?")
  (first (read-line)))

(defn step [word not-guessed error]
  (let [letter (read-letter)
        errors (error-count not-guessed letter error)
        not-guessed (disj not-guessed letter)]
    (cond
      (zero? errors) (println "You loose, bye!")
      (empty? not-guessed) (println "You win!")
      :else (do (print "Your word: ")
                (print-wildcarded word not-guessed)
                (println (str "You have " errors " errors left"))
                (recur word not-guessed errors)))))
      
