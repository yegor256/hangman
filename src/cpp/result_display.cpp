#include "result_display.hpp"
#include "game.hpp"
#include <iostream>

ResultDisplay::ResultDisplay(const Game& game) {
  if (game.IsWon()) {
    ShowWin();
  } else {
    ShowLoss();
  }
}

void ResultDisplay::ShowWin() const {
  std::cout << "You won!\n";
}

void ResultDisplay::ShowLoss() const {
  std::cout << "You lost.\n";
}
