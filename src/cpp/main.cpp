#include "game.hpp"
#include <ctime>
#include <cstdlib>

int main() {
  std::srand(std::time(nullptr));
  Game().Play();

  return 0;
}
