(ns hangman.core-test
  (:require [clojure.test :refer :all]
            [hangman.core :refer :all]
            [hangman.hangman :refer :all]
            [clojure.string :as s]))

(deftest a-test
  (testing "Wrong word"
    (with-redefs [hangman.hangman/read-letter (fn [] "z")]
      (is (= "You loose, bye!"
            (last
              (s/split-lines 
                (with-out-str
                  (step "alabala" (set "alabala") 3)))))))))
