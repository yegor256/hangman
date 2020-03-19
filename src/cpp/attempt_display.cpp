#include "attempt_display.hpp"
#include <iostream>

AttemptDisplay::AttemptDisplay(const GuessingAttempt& attempt, const Mistakes& mistakes)
  : m_mistakes(mistakes) {
  if (attempt.IsSuccessful()) {
    ShowHit();
  } else {
    ShowMiss();
  }
}

void AttemptDisplay::ShowHit() const {
  std::cout << "Hit!\n";
}

void AttemptDisplay::ShowMiss() const {
  std::cout << "Missed, mistake " << m_mistakes.GetAmount() << " out of "
    << m_mistakes.GetMaxAmount() << "\n";
}
