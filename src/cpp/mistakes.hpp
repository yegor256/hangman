#pragma once

#include <cstddef>

class Mistakes {
public:
  explicit Mistakes(int max_amount);

  void MakeOne();
  int GetAmount() const;
  int GetMaxAmount() const;
  int IsMaxAmountReached() const;
private:
  int m_max_amount;
  int m_amount;
};
