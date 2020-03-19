#pragma once

#include "guessing_attempt.hpp"
#include "mistakes.hpp"

class AttemptDisplay {
public:
  explicit AttemptDisplay(const GuessingAttempt& attempt, const Mistakes& mistakes);
private:
  const Mistakes& m_mistakes;

  void ShowHit() const;
  void ShowMiss() const;
};
