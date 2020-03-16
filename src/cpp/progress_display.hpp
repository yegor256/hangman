#pragma once

#include "mistakes.hpp"

class ProgressDisplay {
public:
  explicit ProgressDisplay(Mistakes& mistakes);

  void ShowHit() const;
  void ShowMiss() const;
  void ShowWin() const;
  void ShowLoss() const;
private:
  Mistakes& m_mistakes;
};
