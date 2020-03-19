#pragma once

#include "guessed_word.hpp"
#include "mistakes.hpp"
#include "word_display.hpp"

class GuessingAttempt {
public:
  GuessingAttempt(char letter, GuessedWord& word, Mistakes& mistakes, WordDisplay& display);

  bool IsSuccessful() const;
private:
  GuessedVec m_guessed;
  bool m_successful;
};
