#pragma once

#include "guessed_word.hpp"
#include <vector>
#include <string>

class WordDisplay {
public:
  static constexpr char HIDDEN_LETTER = '?';

  explicit WordDisplay(size_t word_size);

  void Reveal(char letter, const GuessedVec& positions);
  void Show() const;
private:
  std::string m_buffer;
};
