#include "guessing_attempt.hpp"

GuessingAttempt::GuessingAttempt(char letter, GuessedWord& word, Mistakes& mistakes, WordDisplay& word_display)
  : m_guessed(word.Guess(letter))
  , m_successful(!m_guessed.empty()) {
  if (!m_successful) {
    mistakes.MakeOne();
  }
  word_display.Reveal(letter, m_guessed);
}

bool GuessingAttempt::IsSuccessful() const {
  return m_successful;
}
