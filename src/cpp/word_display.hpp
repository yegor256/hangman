#pragma once

#include <vector>
#include <string>

class WordDisplay {
public:
  static constexpr char HIDDEN_LETTER = '?';

  explicit WordDisplay(size_t word_size);

  void Reveal(char letter, const std::vector<size_t>& positions);
  void Show() const;
private:
  std::string m_buffer;
};
