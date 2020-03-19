#pragma once

#include "mistakes.hpp"
#include "guessing_attempt.hpp"

class Game;

class ResultDisplay {
public:
  explicit ResultDisplay(const Game& game);
private:
  void ShowWin() const;
  void ShowLoss() const;
};
