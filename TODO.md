### Problem

The computer guesses a word and the user
has to suggest letters one by one. Every time the word contains a letter,
the computer opens it (all of them, if there are a few). Every time the
word doesn't contain a letter, the computer gives a penalty point for
the user. If there are five penalty points, the user looses. If there
are no hidden letters anymore, the computer loses.

### Steps

- [x] Pick a random word
- [ ] Guess a letter (out: State of word + "guessText")
    - [x] If letter is in word, reveal it (if hit -> "Hit")
    - [ ] Otherwise, gain penalty point (if miss, "Mistake 1 out of 5")
    - [ ] Check if win/lose condition is met

- [ ] "word1" -> "w o _ d _ _" -> w -> "wxxxx" a word must be hidden at
  first, and then reveal parts of itself if a letter is guessed correctly.

Suggest letter

- [ ] Game starts a Session with a Word, and says "_ _ _\nGuess a letter: "
  (and
  shows an empty gallow)

- [ ] guessing a word that's already there IS NOT a mistake. Word is displayed
  again, and we say "You already guessed that letter."
