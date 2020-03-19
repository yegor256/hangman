#include "game.hpp"
#include "guessing_attempt.hpp"
#include "result_display.hpp"
#include "attempt_display.hpp"

constexpr size_t MAX_MISTAKES = 5;

Game::Game()
  : m_guessed_word()
  , m_mistakes(MAX_MISTAKES)
  , m_word_display(m_guessed_word.GetSize())
  , m_user_input() {
}

void Game::Play() {
  while (!IsOver()) {
    char letter = m_user_input.InputLetter();
    GuessingAttempt attempt(
      letter,
      m_guessed_word,
      m_mistakes,
      m_word_display
    );

    AttemptDisplay(attempt, m_mistakes);
    m_word_display.Show();
  }

  ResultDisplay(*this);
}

bool Game::IsOver() const {
  return IsWon() || IsLost();
}

bool Game::IsWon() const {
  return m_guessed_word.IsGuessed();
}

bool Game::IsLost() const {
  return m_mistakes.IsMaxAmountReached();
}

