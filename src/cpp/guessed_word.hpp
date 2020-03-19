#pragma once

#include <string>
#include <vector>
#include <set>

using GuessedVec = std::vector<size_t>;

class GuessedWord {
public:
  GuessedWord();

  GuessedVec Guess(char letter);
  size_t GetSize() const;
  bool IsGuessed() const;
private:
  std::string m_word;
  std::size_t m_guessed_amount;
  std::set<char> m_already_guessed;
};
