(ns hangman.core
  (:gen-class)
  (:require [hangman.hangman :as h]))

(defn -main []
  (let [word (h/create-word)]
    (h/step word (set word) 3)))
