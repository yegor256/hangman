#pragma once

#include "guessed_word.hpp"
#include "mistakes.hpp"
#include "word_display.hpp"
#include "user_input.hpp"

class Game {
public:
  Game();
  void Play();

  bool IsOver() const;
  bool IsWon() const;
  bool IsLost() const;
private:
  GuessedWord m_guessed_word;
  Mistakes m_mistakes;
  WordDisplay m_word_display;
  UserInput m_user_input;
};
